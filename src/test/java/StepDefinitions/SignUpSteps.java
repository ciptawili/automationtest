package StepDefinitions;

import PageObject.HomePage;
import Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Utilities.DataGenerator.*;

public class SignUpSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public SignUpSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    private String firstName = generateFirstName();

    private String lastName = generateLastName();

    private String email = generateEmailAddress();

    @Given("Open sign up page")
    public void openSignUpPage() {

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.homePageIsDisplayed());
        homePage.clickAkunMenu();
        homePage.clickSignUp();
        Assert.assertTrue(homePage.signUpFormIsDisplayed());
    }

    @When("Sign up with valid data")
    public void signUpWithValidData(){

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.signUpFormIsDisplayed());
        homePage.fillFirstName(firstName);
        homePage.fillLastName(lastName);
        homePage.clickCountryCode();
        homePage.fillPhoneNumber("8190002333");
        homePage.fillSignUpEmail(email);
        homePage.fillSignUpPassword("test@123");
        homePage.clickButtonSignUp();
    }

    @Then("Success Sign Up")
    public void successSignUp() {

        HomePage homePage = new HomePage(driver, wait);
        Assert.assertTrue(homePage.signUpFormIsDisplayed());
    }
}
