package StepDefinitions;

import PageObject.HomePage;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public LoginSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @Given("Open Login Page")
    public void openLoginPage() {

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.homePageIsDisplayed());
        homePage.clickAkunMenu();
        Assert.assertTrue(homePage.loginFormIsDisplayed());
    }

    @When("Input email \"(.*)\" and password \"(.*)\"")
    public void inputEmailAndPassword(String email, String password){

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.loginFormIsDisplayed());
        homePage.fillEmail(email);
        homePage.fillPassword(password);
        homePage.clickButtonLogin();
    }

    @Then("Login Successful")
    public void loginSuccessful(){

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.homePageAfterLoginIsDisplayed());
    }
}
