package StepDefinitions;

import PageObject.HomePage;
import PageObject.StoreLandingPage;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public HomeSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @Given("Go to Home Page")
    public void goToHomePage(){

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @Given("Search Address for discover store")
    public void searchAddressForDiscoverStore() {

        HomePage homePage = new HomePage(driver, wait);
        homePage.searchAddress("cisauk");
        homePage.selectAddress();
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("Choose favourite supermarket")
    public void chooseFavouriteSupermarket(){

        HomePage homePage = new HomePage(driver, wait);
        homePage.selectFavouriteStore();
        StoreLandingPage storeLandingPage = new StoreLandingPage(driver, wait);
        Assert.assertTrue(storeLandingPage.storeLandingPageIsDisplayed());
    }
}
