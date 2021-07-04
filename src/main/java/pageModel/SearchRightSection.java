package pageModel;


import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class SearchRightSection extends BasePage {
    public SearchRightSection(DriverManager driver) {
        super(driver);
    }


    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * The getRightSection method returns the WebElement for the Right Section panel
     *
     * @param :
     * @return WebElement
     */
    private WebElement getRightSection() {
        return driver.getDriverInstance().findElement(By.cssSelector("div.rightSection"));
    }

    /**
     * The getSectionTitleText method returns title text in the Section
     *
     * @param :
     * @return String
     */
    public String getSectionTitleText() {
        Reporting.logSteps("Search Right Section - Get Section Title Text");
        return getRightSection().findElement(By.cssSelector("p[class^='PopularSearchResultsstyle__TextContainer']")).getText();
    }

    /**
     * The getCampaign method returns the WebElement for the Campaign panel
     *
     * @param :
     * @return
     */
    public void clickOnCampaign() {
        Reporting.logSteps("Search Right Section - Click on 'Find out more");
        getRightSection().findElement(By.cssSelector("div[class^='PopularSearchResultsstyle__PopularSearchDIYContainer']")).click();
    }

    /**
     * The getCardListItems method returns all the WebElements in the card list
     *
     * @param :
     * @return List<WebElement>
     */
    private List<WebElement> getCardListItems() {
        return getRightSection().findElements(By.cssSelector("div[class^='PopularSearchResultsstyle__PopularSearchCardsContainer'] div[class^='PopularSearchCardstyle__PopularSearchCardContainer']"));
    }

    /**
     * The getCardListItemsTexts method returns all the items texts in the card list
     *
     * @param :
     * @return List<String>
     */
    public List<String> getCardListItemsTexts() {
        List<String> returnList = new ArrayList<String>();
        var items = getCardListItems();
        for (WebElement item :
                items) {
            returnList.add(item.findElement(By.cssSelector("p")).getText());
        }
        Reporting.logSteps("Search Right Section - Get Card list items texts");
        return returnList;
    }

    /**
     * The getCardListItemByText method returns the WebElement in the card list
     * that matches the text parameter. If the text is not found null is returned.
     *
     * @param : text
     * @return WebElement
     */
    private WebElement getCardListItemByText(String text) {
        for (WebElement item : getCardListItems()) {
          String t = item.findElement(By.cssSelector("p")).getText();
            if (item.findElement(By.cssSelector("p")).getText().equalsIgnoreCase(text))
                return item;
        }
        return null;
    }

    /**
     * The clickOnProductCard method clicks on an item of the Card List based on a productTitle
     *
     * @param : productTitle
     * @return
     */
    public void clickOnProductCard(String productTitle) {
        WebElement itemCard = getCardListItemByText(productTitle);
        itemCard.click();
    }

    /**
     * The clickOnProductCard method clicks on an item of the Card List based on a productTitle
     *
     * @param : productTitle
     * @return
     */
    public void clickOnCardCategoryTitle(String productTitle) {
        var cardItem = getCardListItemByText(productTitle);
       cardItem.findElement(By.cssSelector("div[data-locator=category-urls]>a:nth-child(1)")).click();

    }

    /**
     * The waitForTextToUpdate method waits for the Title text to update
     *
     * @param : titleText
     * @return
     */

    public void waitForTextToUpdate(String titleText) {
        WebDriverWait wait = new WebDriverWait(driver.getDriverInstance(), 10);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement titleSection = driver.findElement(By.cssSelector("p[class^='PopularSearchResultsstyle'"));
                String titleSectionText = titleSection.getAttribute("data-locator");
                if (titleSectionText.equalsIgnoreCase(titleText))
                    return true;
                else
                    return false;
            }
        });
    }


}// class
