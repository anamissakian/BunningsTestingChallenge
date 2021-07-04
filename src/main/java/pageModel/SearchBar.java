package pageModel;


import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SearchBar extends BasePage {
    public SearchBar(DriverManager driver) {
        super(driver);
    }


    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * The getSearchBarText method returns the Search Bar text
     *
     * @param :
     * @return searchBarText
     */
    public String getSearchBarText() {
        WebElement searchBarElement = driver.getDriverInstance().findElement(By.id("header-search"));
        String searchBarText = searchBarElement.findElement(By.tagName("placeholder")).getText();
        Reporting.logSteps("Search bar - Get search bar text");
        return searchBarText;
    }

    /**
     * The clickOnSearchBar method that clicks on Search Bar
     *
     * @param
     * @return
     */
    public void clickOnSearchBar() {
        driver.getDriverInstance().findElement(By.id("custom-css-outlined-input")).click();
        Reporting.logSteps("Search bar - Click on Search bar");
    }

    /**
     * The inputSearchTerm method that inputs a searchValue in the Search Bar
     *
     * @param searchTerm
     * @return
     */
    public void inputSearchTerm(String searchTerm) {
        driver.getDriverInstance().findElement(By.id("custom-css-outlined-input")).sendKeys(searchTerm);
        Reporting.logSteps("Search bar - Input search term");
    }

    /**
     * The clickOnSearchButton ethod that clicks on Search Button
     *
     * @param
     * @param
     */
    public void clickOnSearchButton() {
        driver.getDriverInstance().findElement(By.cssSelector("button#crossIcon")).click();
        Reporting.logSteps("Search bar - Click on Search button");
    }


}// class
