import data.Product;
import pageModel.ProductSearchResultsPage;
import pageModel.SearchBar;
import pageModel.SearchLeftSection;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//*************This tests covers***************************
//Click on  Search bar
//Input a term (e.g. paint)
//Click on search button
//Validate that the right Webpage is being displayed
//Click on Search bar
//Click on an item of the list
//Validate that the right Webpage is being displayed

//********************************************************


public class LeftSectionRecentSearchesTests extends BaseTest {


    @Test(groups = {"Recent Searches"},
            description = "To validate that the the correct page is being displayed after clicking on Product from the Recent searches list")

    public void verifySearchResultsByClickOnProductTest() {

        //Data used in Test
        Product productToSearch = new Product("Paint");
        String expectedSectionTitle = "Recent searches";

        //Sections-Pages used in Test
        SearchBar searchBar = new SearchBar(driver);
        SearchLeftSection searchLeftSection = new SearchLeftSection(driver);
        ProductSearchResultsPage productSearchResultsPage = new ProductSearchResultsPage(driver);

        SoftAssert softAssert = new SoftAssert();

        searchBar.clickOnSearchBar();
        searchBar.inputSearchTerm(productToSearch.getProductName());
        searchBar.clickOnSearchButton();

        String productDisplayedInSearchResultsPage = productSearchResultsPage.getSearchedTermText();

        softAssert.assertEquals(productDisplayedInSearchResultsPage, productToSearch.getProductName(), "Product in search results page and product entered are not the same (TC001)");

        searchBar.clickOnSearchBar();

        String actualSectionTitle = searchLeftSection.getSectionTitleText();
        softAssert.assertEquals(actualSectionTitle, expectedSectionTitle, "Title section displayed is not correct (TC007)");

        searchLeftSection.clickOnItemOnRecentSearchList(productToSearch.getProductName());

        productDisplayedInSearchResultsPage = productSearchResultsPage.getSearchedTermText();
        softAssert.assertEquals(productDisplayedInSearchResultsPage, productToSearch.getProductName(), "Product in search results page and product entered are not the same (TC003");

        softAssert.assertAll();
    }

}//Class