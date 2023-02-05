package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs//Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public  String getStandardUsername(){
        String standardUsername=properties.getProperty("standardUsername");
        if (standardUsername != null) return standardUsername;
        else throw new RuntimeException("standardUsername not specified in the Configuration.properties file.");
    }

    public String getPassword(){
        String password=properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the Configuration.properties file.");
    }

    public String getUsernameRequiredErrorTxt(){
        String usernameRequired=properties.getProperty("usernameRequired");
        if (usernameRequired != null) return usernameRequired;
        else throw new RuntimeException("usernameRequired not specified in the Configuration.properties file.");
    }

    public String getPasswordRequiredErrorTxt(){
        String passwordRequired=properties.getProperty("passwordRequired");
        if (passwordRequired != null) return passwordRequired;
        else throw new RuntimeException("passwordRequired not specified in the Configuration.properties file.");
    }
    public  String getDataDoesNotMatchErrorTxt(){
        String dataDoesNotMatch=properties.getProperty("dataDoesNotMatch");
        if (dataDoesNotMatch != null) return dataDoesNotMatch;
        else throw new RuntimeException("dataDoesNotMatch not specified in the Configuration.properties file.");
    }
    public long getExplicitWaitTime(){
        String explicitWaitTime=properties.getProperty("explicitWaitTime");
        if (explicitWaitTime != null) return Long.parseLong(properties.getProperty("explicitWaitTime"));
        else throw new RuntimeException("dataDoesNotMatch not specified in the Configuration.properties file.");
    }
}