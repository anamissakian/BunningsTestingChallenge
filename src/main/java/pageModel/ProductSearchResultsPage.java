package pageModel;

import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.openqa.selenium.By;

public class ProductSearchResultsPage extends BasePage {

    public ProductSearchResultsPage(DriverManager driver) {
        super(driver);
    }

    /**
     * The getSearchedTermText method returns the searched term text
     *
     * @param :
     * @return searchedTerm
     */
    public String getSearchedTermText() {
        String searchedTerm = driver.getDriverInstance().findElement(By.cssSelector("div.searchTerm>h2.MuiTypography-root.MuiTypography-h2>span")).getText();
        Reporting.logSteps("Product search results webpage - Get searched term text");
        return searchedTerm;
    }


}//Class