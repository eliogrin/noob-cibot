package com.github.eliogrin.models;

import com.github.eliogrin.dto.UserDto;
import com.github.eliogrin.models.core.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class AgentsModel extends AbstractModel {

    private List<UserDto> data = new ArrayList<UserDto>();
    private static final String ROLE_AGENT = "ROLE_AGENT";

    public List<UserDto> data() {
        return data;
    }

    public void data(List<UserDto> data) {
        this.data = data;
    }

    public void load() {
        String query = "SELECT * FROM users WHERE role = :role";
        data = connector().instance().createQuery(query).addParameter("role", ROLE_AGENT)
                .executeAndFetch(UserDto.class);
    }
}
