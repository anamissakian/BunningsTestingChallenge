package pageModel;

import infrastructure.DriverManager;
import infrastructure.Reporting;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    public ProductPage(DriverManager driver) {
        super(driver);
    }

    /**
     * The getProductTitleText method returns the Product Title text
     *
     * @param :
     * @return productTitle
     */
    public String getProductTitleText() {
        String productTitle = driver.getDriverInstance().findElement(By.cssSelector("h1[data-locator='product-title")).getText();
        Reporting.logSteps("Product webpage - Get Product title text");
        return productTitle;
    }


}//Class