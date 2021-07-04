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
//Click on Clear Recent Searches
//Validate that 'Popular Searches' list is being displayed

//********************************************************


public class LeftSectionClearRecentSearchesTests extends BaseTest {


    @Test(groups = {"Clear Recent Searches"},
            description = "To validate that 'Recent searches' list gets cleared when clicking on Clear Recent Searches")

    public void verifySearchResultsByClickOnProductTest() {

        //Data used in Test
        Product productToSearch = new Product("Paint");
        String expectedSectionTitle = "Popular searches";

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

        searchLeftSection.clickOnClearRecentSearchesButton();

        String sectionTitletext = searchLeftSection.getSectionTitleText();

        softAssert.assertEquals(sectionTitletext, expectedSectionTitle, "Clear Recent searches is not working (TC009)");

        softAssert.assertAll();
    }

}//Class