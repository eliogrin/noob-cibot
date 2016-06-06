package com.github.eliogrin.models;

import com.github.eliogrin.dto.UserDto;
import com.github.eliogrin.models.core.AbstractModel;

public class UserModel extends AbstractModel {

    private UserDto data = new UserDto();

    public UserDto data() {
        return data;
    }

    public void data(UserDto data) {
        this.data = data;
    }

    public void load() {
        String query = "SELECT * FROM users WHERE name = :name";
        data = connector().instance().createQuery(query).bind(data).executeAndFetchFirst(UserDto.class);
    }
}
