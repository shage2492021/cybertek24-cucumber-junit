package com.cybertek.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();    // this needs to be static...static block cannot access static variables

    static{
        try {
            // Open file using inputStream
            FileInputStream inputStream = new FileInputStream("configuration.properties");
            //load to properties object
            properties.load(inputStream);

            //close the file after loading
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading config file");
        }
    }

    /**
     * Method is used to read value from configurations.properties file
     * @param key   -> key name in properties file
     * @return  -> value for the key. returns null if key not found
     * EX: driver.get(ConfigurationReader.getProperty(""));
     */
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
