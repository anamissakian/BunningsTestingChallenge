package pageModel;

import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.openqa.selenium.By;

public class CategoryPage extends BasePage {

    public CategoryPage(DriverManager driver) {
        super(driver);
    }

    /**
     * The getCategoryTitleText method returns the Category Title text
     *
     * @param :
     * @return categoryTitle
     */
    public String getCategoryTitleText() {
        String categoryTitle = driver.getDriverInstance().findElement(By.cssSelector("h1[class^='MuiTypography-root Herostyle__StyledTitle']")).getText();
        Reporting.logSteps("Category webpage - Get Category title text");
        return categoryTitle;
    }


}//Class