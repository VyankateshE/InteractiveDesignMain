package com.convert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final String DEFAULT_CONFIG_FILE_PATH = "/application.properties";
    private static Properties properties = new Properties();

    static {
        loadProperties(DEFAULT_CONFIG_FILE_PATH);
    }

    public static void loadProperties(String configFilePath) {
        try (InputStream inputStream = AppConfig.class.getResourceAsStream(configFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately (e.g., logging, fallback values)
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

