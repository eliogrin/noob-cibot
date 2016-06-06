package com.github.eliogrin.models.core;

import com.github.eliogrin.DbConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelFactory {

    @Autowired
    private DbConnector connector;
    private Logger log = LoggerFactory.getLogger(ModelFactory.class);

    public <T extends AbstractModel> T getModel(Class<T> modelClass) {
        T model = null;
        try {
            model = modelClass.newInstance();
            model.setConnector(connector);
        } catch (ReflectiveOperationException e) {
            log.error("Failed to init '{}' model", modelClass.getSimpleName());
        }
        return model;
    }
}
