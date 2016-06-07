package com.github.eliogrin.workers;

import com.github.eliogrin.DbConnector;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CleanUpWorker")
public class CleanUpWorker {

    @Autowired
    private DbConnector connector;

    private int maximumAge = 0;

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public void cleanOldEvents() {
        DateTime time = new DateTime();
        String queue = "DELETE FROM events WHERE timestamp < :time";
        connector.instance().createQuery(queue).addParameter("time", time.minusMinutes(maximumAge)).executeUpdate();
    }
}
