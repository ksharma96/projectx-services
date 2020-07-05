package com.ks.projectxservices.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EnvironmentProperties implements EnvironmentAware {

    private Environment env;

    public String getXapikey() {
        return xapikey;
    }

    private final String xapikey;

    @Autowired
    public EnvironmentProperties(@Value("${restdb.xapikey}") String xapikey) {
        this.xapikey = xapikey;
    }

    public String getProperty(String propertyName) {
        return env.getProperty(propertyName);
    }

    @Override
    public void setEnvironment(Environment environment) {
        env = environment;
    }
}

