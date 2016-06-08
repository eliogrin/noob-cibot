package com.github.eliogrin.models;

import com.github.eliogrin.dto.UserDto;
import com.github.eliogrin.models.core.AbstractModel;

public class ConsumerModel extends AbstractModel {

    private UserDto data = new UserDto();

    public UserDto data() {
        if (data == null) {
            data = new UserDto();
        }
        return data;
    }

    public void data(UserDto data) {
        this.data = data;
    }

    public void load() {
        String query = "SELECT * FROM users WHERE name = :name";
        data = connector().instance().createQuery(query).bind(data).executeAndFetchFirst(UserDto.class);
    }

    public void load(final String hash) {
        String query = "SELECT * FROM users WHERE hash = :hash";
        data = connector().instance().createQuery(query).addParameter("hash", hash).executeAndFetchFirst(UserDto.class);
    }

    public boolean isLoaded() {
        return data().getId() != 0;
    }
}
