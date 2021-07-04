import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
    DriverManager driver = new DriverManager();

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "headless"})
    public void setup(@Optional("chrome") String browserType,
                      @Optional("false") boolean headless) throws MalformedURLException {
        try {
            driver.setupBrowser(browserType, headless);
            driver.openWebUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Reporting.takeScreenshots(driver.getDriverInstance());
        }
        driver.closeBrowser();

    }
}
