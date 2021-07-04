package infrastructure;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting {

    public static void logSteps(String stepDescription) {
        Reporter.log(stepDescription, true);
    }

    public static void takeScreenshots(WebDriver driver) {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            FileUtils.copyFile(file, new File("C:\\Selenium\\ErrorScreenshots" + timeStamp + ".jpg"));
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}