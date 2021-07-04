package infrastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private Properties properties;
    private final String propertyFilePath = "Configuration//Configuration.properties";

    public Configuration() {
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

    public String getChromeDriverLocation() {
        String chromeDriverLocation = properties.getProperty("chromeDriverLocation");
        if (chromeDriverLocation != null)
            return chromeDriverLocation;
        else
            throw new RuntimeException("chromeDriverLocation not specified in the Configuration.properties file.");
    }

    public String getIEDriverLocation() {
        String IEDriverLocation = properties.getProperty("ieDriverLocation");
        if (IEDriverLocation != null)
            return IEDriverLocation;
        else
            throw new RuntimeException("ieDriverLocation not specified in the Configuration.properties file.");
    }

    public long getTimeout() {
        String timeout = properties.getProperty("timeout");
        if (timeout != null)
            return Long.parseLong(timeout);
        else
            throw new RuntimeException("timeout not specified in the Configuration.properties file.");
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

}
