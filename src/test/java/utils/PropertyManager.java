package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	
	private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "/src/test/java/utils/Configurations.properties";
    
    private static String path;
    private static String browser;
    private static String url;
    private static String user;
    private static String pass;
 
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }
    
 
    private void loadData() {
        
    	Properties prop = new Properties();
 
        try {
            prop.load(new FileInputStream(propertyFilePath));
            
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        path = prop.getProperty("path");
        browser = prop.getProperty("browser");
        url = prop.getProperty("url");
        user = prop.getProperty("user");
        pass = prop.getProperty("pass");
    }
    
    public String getPathChrome() {
    	return path;
    }
    
    public String getBrowser () {
        return browser;
    }
    
    public String getURL () {
        return url;
    }
 
    public String getUser () {
        return user;
    }
 
    public String getPass () {
        return pass;
    }
}
