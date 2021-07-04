package pageModel;


import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class SearchLeftSection extends BasePage {
    public SearchLeftSection(DriverManager driver) {
        super(driver);
    }


    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * The getLeftSection method returns the WebElement for the Left Section panel
     *
     * @param :
     * @return WebElement
     */
    private WebElement getLeftSection() {
        return driver.getDriverInstance().findElement(By.cssSelector("div.leftSection"));
    }

    /**
     * The getSectionTitleText method returns title text in the Section
     *
     * @param :
     * @return String
     */
    public String getSectionTitleText() {
        Reporting.logSteps("Search Left Section - Get Section Title Text");
        return getLeftSection().findElement(By.cssSelector("div[class^='PopularRecentSuggestionsstyle__ContentWrapper']>p")).getText();
    }

    /**
     * The getCloseButton method returns the WebElement for the Close button X
     *
     * @param :
     * @return
     */
    public void clickOnCloseButton() {
        getLeftSection().findElement(By.cssSelector("button[class^='PopularRecentSuggestionsstyle__CloseTypeaheadButtonContainer']")).click();
    }

    /**
     * The getSuggestionListItems method returns all the WebElements in the search suggestion list
     *
     * @param :
     * @return List<WebElement>
     */
    private List<WebElement> getSuggestionListItems() {
        return getLeftSection().findElements(By.cssSelector("div[class^='PopularRecentSuggestionsstyle__LinkContainer']"));
    }

    /**
     * The getSuggestionListItemsTexts method returns all the items texts in the search suggestion list
     *
     * @param :
     * @return List<String>
     */
    private List<String> getSuggestionListItemsTexts() {
        List<String> returnList = new ArrayList<String>();
        var items = getSuggestionListItems();
        for (WebElement item :
                items) {
            returnList.add(item.getText());
        }
        return returnList;
    }

    /**
     * The getSuggestionListItemByText method returns the WebElement in the search suggestion list
     * that matches the text parameter. If the text is not found null is returned.
     *
     * @param : text
     * @return item
     */
    private WebElement getSuggestionListItemByText(String text) {
        for (WebElement item : getSuggestionListItems()) {
            if (item.getText() == text)
                return item;
        }
        return null;
    }

    // -----------------------------------------------------------------
    // Popular Searches
    // -----------------------------------------------------------------

    /**
     * The getPopularSearches method returns all the items texts in the Popular Searches list
     *
     * @param :
     * @return List<String>
     */
    public List<String> getPopularSearches() {
        Reporting.logSteps("Search Left Section - Get Popular searches list");
        return getSuggestionListItemsTexts();
    }

    /**
     * The getPopularSearchItemByText method returns the WebElement in the list of Popular Searches
     * that matches the text parameter. If the text is not found null is returned.
     *
     * @param :
     * @return WebElement
     */
    public WebElement getPopularSearchItemByText(String text) {
        Reporting.logSteps("Search Left Section - Get Popular search item by Text");
        return getSuggestionListItemByText(text);
    }

    // -----------------------------------------------------------------
    // Recent Searches
    // -----------------------------------------------------------------

    /**
     * The getRecentSearches method returns all the items texts in the Recent Searches list
     *
     * @param :
     * @return List<String>
     */
    public List<String> getRecentSearches() {
        Reporting.logSteps("Search Left Section - Get Recent searches list");
        return getSuggestionListItemsTexts();
    }

    /**
     * The getRecentSearchItemByText method returns the WebElement in the list of Recent Searches
     * that matches the text parameter. If the text is not found null is returned.
     *
     * @param : text
     * @return item
     */
    private WebElement getRecentSearchItemByText(String text) {
        for (WebElement item : getSuggestionListItems()) {
            if (item.getText().equalsIgnoreCase(text))
                return item;
        }
        return null;
    }

    /**
     * The clickOnItemOnRecentSearchList method clicks on an item of the Recent Search list based on a text.
     *
     * @param : text
     * @return
     */
    public void clickOnItemOnRecentSearchList(String text) {
        Reporting.logSteps("Search Left Section - Click on item from Recent search list");
        WebElement itemToSearch = getRecentSearchItemByText(text);
        itemToSearch.click();
    }

    /**
     * The clickOnClearRecentSearchesButton clicks on the Clear Recent Searches button
     *
     * @param :
     * @return
     */
    public void clickOnClearRecentSearchesButton() {
        Reporting.logSteps("Search Left Section - Click on Clear Recent searches");
        getLeftSection().findElement(By.cssSelector("button[class^='PopularRecentSuggestionsstyle__ClearSuggestionsContainer']")).click();
    }

    // -----------------------------------------------------------------
    // Search Suggestions
    // -----------------------------------------------------------------

    /**
     * The getSearchSuggestions method returns all the items texts in the Search Suggestions list
     *
     * @param :
     * @return
     */
    public List<String> getSearchSuggestions() {
        Reporting.logSteps("Search Left Section - Get Search suggestions");
        return getSuggestionListItemsTexts();
    }


}// class
