import data.Product;
import pageModel.CategoryPage;
import pageModel.ProductPage;
import pageModel.SearchBar;
import pageModel.SearchRightSection;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//*************These tests covers***************************
//Test verifySearchResultsByClickOnCardProductTest:
//Click on  Search bar
//Input a term (e.g. paint)
//Validate that Section title gets updated correctly
//Click on desired card
//Validate that the right Webpage is being displayed

//Test verifySearchResultsByClickOnCardCategoryTest:
//Click on  Search bar
//Input a term (e.g. paint)
//Click on 'Category' from desired card
//Validate that the right Webpage is being displayed
//********************************************************


public class RightSectionCardsListTests extends BaseTest {


    @Test(groups = {"Cards List"},
            description = "To validate that the the correct page is being displayed after clicking on Product from the cards list")

    public void verifySearchResultsByClickOnCardProductTest() {

        //Data used in Test
        String searchTerm = "Paint";
        Product productToSearch = new Product("Taubmans Easycoat Low Sheen White Interior Wall Paint - 1L");
        String expectedSectionTitle = "Suggested for you";

        //Sections-Pages used in Test
        SearchBar searchBar = new SearchBar(driver);
        SearchRightSection searchRightSection = new SearchRightSection(driver);
        ProductPage productPage = new ProductPage(driver);

        SoftAssert softAssert = new SoftAssert();

        searchBar.clickOnSearchBar();
        searchBar.inputSearchTerm(searchTerm);

        searchRightSection.waitForTextToUpdate(expectedSectionTitle);

        String actualSectionTitle = searchRightSection.getSectionTitleText();

        softAssert.assertEquals(actualSectionTitle, expectedSectionTitle, "Section title displayed is not correct TC(015)");

        searchRightSection.clickOnProductCard(productToSearch.getProductName());
        String productDisplayedProductPage = productPage.getProductTitleText();

        softAssert.assertEquals(productDisplayedProductPage, productToSearch.getProductName(), "Product in product webpage and product selected in card are not the same (TC016)");

        softAssert.assertAll();
    }

    @Test(groups = {"Cards List"},
            description = "To validate that the the correct page is being displayed after clicking on Category from a card")

    public void verifySearchResultsByClickOnCardCategoryTest() {

        //Data used in Test
        String searchTerm = "Paint";
        Product productToSearch = new Product("Taubmans Easycoat Low Sheen White Interior Wall Paint - 1L", "Paint & Wallpaper");
        String expectedSectionTitle = "Suggested for you";

        //Sections-Pages used in Test
        SearchBar searchBar = new SearchBar(driver);
        SearchRightSection searchRightSection = new SearchRightSection(driver);
        CategoryPage categoryPage = new CategoryPage(driver);

        SoftAssert softAssert = new SoftAssert();

        searchBar.clickOnSearchBar();
        searchBar.inputSearchTerm(searchTerm);

        searchRightSection.waitForTextToUpdate(expectedSectionTitle);

        searchRightSection.clickOnCardCategoryTitle(productToSearch.getProductName());

        String categoryDisplayedProductPage = categoryPage.getCategoryTitleText();

        softAssert.assertEquals(categoryDisplayedProductPage, productToSearch.getCategory(), "Category in category webpage and category selected in card are not the same (TC017)");

        softAssert.assertAll();
    }

}//Class