package com.github.eliogrin.models.core;

import com.github.eliogrin.DbConnector;

public class AbstractModel {

    private DbConnector connector;

    public void setConnector(DbConnector connector) {
        this.connector = connector;
    }

    protected DbConnector connector() {
        return connector;
    }
}
