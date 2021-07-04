package infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    protected static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    private static Configuration configuration = new Configuration();
    private static final String chrome_webdriver_key = "webdriver.chrome.driver";
    private static final String ie_webdriver_key = "webdriver.ie.driver";
    private static DesiredCapabilities cap;
    private static ChromeOptions chromeOpt;
    private static String browserName;

    public void setupBrowser(String browser, boolean headless) throws Exception {
        browserName = browser;

        if (browser.equalsIgnoreCase("ie")) {
            System.setProperty(ie_webdriver_key, configuration.getIEDriverLocation());
            cap = DesiredCapabilities.internetExplorer();
            cap.setCapability("ie.ensureCleanSession", true);
            if (headless == true) {
                throw new Exception("IE Browser does not support headless");
            }
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty(chrome_webdriver_key, configuration.getChromeDriverLocation());
            cap = DesiredCapabilities.chrome();
            chromeOpt = new ChromeOptions();
            chromeOpt.addArguments("--window-size=1920,1080"); // Prevents error: element not interactable
            if (headless == true) {

                chromeOpt.addArguments("--headless");
            }
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOpt);
        } else {
            throw new Exception("Browser is not supported");
        }
    }

    public WebDriver getDriverInstance() {
        if (null == drivers.get()) {
            WebDriver myWebDriver = null;
            if (browserName.equalsIgnoreCase("ie")) {
                myWebDriver = new InternetExplorerDriver();
            } else if (browserName.equalsIgnoreCase("Chrome")) {
                myWebDriver = new ChromeDriver(chromeOpt);
            }
            myWebDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            drivers.set(myWebDriver);
        }
        return drivers.get();
    }

    public void openWebUrl() {
        getDriverInstance().get(configuration.getUrl());
    }

    public void closeBrowser() {
        getDriverInstance().quit();
        drivers.remove();
    }
}
