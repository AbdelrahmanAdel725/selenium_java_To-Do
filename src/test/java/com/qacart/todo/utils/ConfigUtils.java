package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private final Properties properties;
    public static ConfigUtils configUtils;
    private ConfigUtils()
    {
        properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
    }
    public static ConfigUtils getInstance()
    {
        if(configUtils == null)
        {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl()
    {
       String prop = properties.getProperty("baseUrl");
       if(prop != null) return prop;
       throw new RuntimeException("Could find baseUrl in properties file");
    }
    public String getEmail()
    {
        String prop = properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Could find Email in properties file");
    }
    public String getPassword()
    {
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Could find Password in properties file");
    }
}
