package StepDefinitions;

import PageObject.SearchPage;
import PageObject.StoreLandingPage;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public SearchSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @When("Search product \"(.*)\"")
    public void searchProduct(String product){

        StoreLandingPage storeLandingPage = new StoreLandingPage(driver, wait);
        storeLandingPage.searchProduct(product);
    }

    @Then("Success search product with keyword \"(.*)\"")
    public void successSearchProductWithKeyword(String product){

        SearchPage searchPage = new SearchPage(driver, wait);
        Assert.assertTrue(searchPage.searchPageIsDisplayed());
        String textSearch = searchPage.getKeywordSearch();
        Assert.assertEquals(textSearch.toLowerCase(), product.toLowerCase());
        String titleProduct = searchPage.getTitleProduct();
        String searchProdcut = product;
        Assert.assertTrue(titleProduct.toLowerCase().contains(searchProdcut.toLowerCase()));
    }

    @When("Sorting product A-Z")
    public void sortingProductAz(){

        SearchPage searchPage = new SearchPage(driver, wait);
        Assert.assertTrue(searchPage.searchPageIsDisplayed());
        searchPage.clickSorting();
        searchPage.selectSorting();
    }

    @Then("Success Sorting Product")
    public void successSortingProduct(){

        SearchPage searchPage = new SearchPage(driver, wait);
        Assert.assertTrue(searchPage.searchPageIsDisplayed());
        String resultSorting = searchPage.getResultSorting();
        Assert.assertEquals(resultSorting, "A - Z");
    }
}
