package com.github.eliogrin.models;

import com.github.eliogrin.dto.UserDto;
import com.github.eliogrin.models.core.AbstractModel;

public class AgentModel extends AbstractModel {

    private UserDto data = new UserDto();
    private static final String ROLE_AGENT = "ROLE_AGENT";

    public AgentModel() {
        data.setRole(ROLE_AGENT);
    }

    public UserDto data() {
        return data;
    }

    public void data(UserDto data) {
        data.setRole(ROLE_AGENT);
        this.data = data;
    }

    public void save() {
        String query = "UPDATE users SET name=:name, password=:password, hash=:hash WHERE id=:id";
        if (data().getId() == 0) {
            query = "INSERT INTO users (name, password, role, hash) values (:name, :password, :role, :hash)";
        }
        connector().instance().createQuery(query).bind(data()).executeUpdate();
    }

    public void remove() {
        String query = "DELETE FROM users WHERE id=:id";
        connector().instance().createQuery(query).addParameter("id", data().getId()).executeUpdate();
    }

    public void load() {
        String query = "SELECT * FROM users WHERE id=:id";
        data = connector().instance().createQuery(query).bind(data()).executeAndFetchFirst(UserDto.class);
    }
}
