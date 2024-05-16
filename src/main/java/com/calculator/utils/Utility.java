package com.calculator.utils;

import java.io.*;
import java.util.Properties;

public class Utility {
    private static Properties CONFIG_PROPERTY;
    private static final String CONFIG_PATH = "src/test/resources/config/config.properties";

    public static void readConfigProperty() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_PATH);
            properties.load(fileInputStream);
            CONFIG_PROPERTY = properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getConfigProperty(String propertyName) {
        if (CONFIG_PROPERTY == null) {
            readConfigProperty();
        }
        return CONFIG_PROPERTY.getProperty(propertyName);
    }
}
