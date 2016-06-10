package com.github.eliogrin;

import com.google.gson.JsonArray;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.session.SessionFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class EventsProvider {

    private final static int EVENTS_LIMIT = 5;
    private final static Logger log = LoggerFactory.getLogger(EventsProvider.class);

    private RequestSpecification requestProfile = null;
    private Map<String, String> credentials = new HashMap<String, String>();

    public EventsProvider(String endpoint, String username, String token) {
        requestProfile = new RequestSpecBuilder().setBaseUri(endpoint).setContentType(ContentType.URLENC)
                .addFilter(new SessionFilter()).build();
        credentials.put("username", username);
        credentials.put("password", token);
    }

    private void authorizationRequest() {
        log.info("Authorization initialized.");
        RestAssured.given(requestProfile).formParameters(credentials).post("/login");
    }

    public JsonArray getEvents() {
        return getEvents(EVENTS_LIMIT);
    }

    public JsonArray getEvents(int quantity) {
        JsonArray result = new JsonArray();
        try {
            Response response = RestAssured.given(requestProfile).queryParameter("limit", quantity).get("/rest/events");
            if (response.statusCode() == HttpServletResponse.SC_UNAUTHORIZED) {
                authorizationRequest();
                getEvents(quantity);
            }
            if (response.statusCode() == HttpServletResponse.SC_OK) {
                log.debug("Processing non empty response. {}", response.getBody());
                result = response.as(JsonArray.class);
            }
        } catch (Exception e) {
            /** Reset filter to renew session */
            requestProfile.noFilters().filter(new SessionFilter());
            log.error("Protocol error renew session\n{}", e.getMessage());
        }
        return result;
    }
}
