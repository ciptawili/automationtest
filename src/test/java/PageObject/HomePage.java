package PageObject;

import Utilities.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    private Random random = new Random();

    @FindBy (xpath = "//img[@alt='HappyFresh Logo']")
    public static WebElement headerLogo;

    @FindBy (id = "header-acc-off")
    private WebElement buttonAkun;

    @FindBy (id = "header-acc-in")
    private WebElement buttonAkunAfterLogin;

    @FindBy (id = "login-form-email")
    private WebElement inputEmail;

    @FindBy (id = "login-form-password")
    private WebElement inputPassword;

    @FindBy (id = "login-form-button")
    private  WebElement buttonLogin;

    @FindBy (id = "login-form-signup-link")
    private WebElement linkSignUp;

    @FindBy (id = "signup-form-firstname")
    private WebElement inputFirstName;

    @FindBy (id = "signup-form-lastname")
    private WebElement inputLastName;

    @FindBy (xpath = "//div[@class='select__placeholder css-1wa3eu0-placeholder' and contains(text(),'Select')]")
    private WebElement selectCountryCode;

    @FindBy (id ="react-select-signup-form-country-code-input")
    private WebElement inputCountryCode;

    @FindBy (xpath = "//div[@class='select__menu css-26l3qy-menu'")
    private WebElement formCountryCode;

    @FindBy (xpath = "//div[@class='select__option css-yt9ioa-option']")
    private List<WebElement> valueCountryCode;

    @FindBy (id = "signup-form-phone-number")
    private WebElement inputPhoneNumber;

    @FindBy (id = "signup-form-email")
    private WebElement inputSignUpEmail;

    @FindBy (id = "signup-form-password")
    private WebElement inputSignUpPassword;

    @FindBy (id = "signup-form-button")
    private WebElement buttonSignUp;

    @FindBy (xpath = "//div[@class='jsx-2158945293 jsx-389142024 modal blowUp entered']")
    private WebElement modalPhoneVerification;

    @FindBy (xpath = "//div[@id='landing-suppliers']//div[1]//div[contains(@class, 'slick-slide slick-active') and @data-index='0']//div[@class='jsx-2313362881 root landing']")
    private List<WebElement> listFavouriteStore;

    @FindBy (xpath = "//div[@id='landing-speciality']//div[1]//div[contains(@class, 'slick-slide slick-active') and @data-index='0']//div[@class='jsx-2313362881 root landing']//div[@class='jsx-2313362881 store-card']")
    private WebElement selectSpecialStore;

    @FindBy (xpath = "//input[contains(@class, 'jsx-3888565580 jsx-2151840156 control has-prefix')]")
    private  WebElement inputAddress;

    @FindBy (xpath = "//div[@class='jsx-2737002068 jsx-2796352036 option']")
    private List<WebElement> listAddress;


    public boolean homePageIsDisplayed() {

        WaitUntilElementVisible(headerLogo);
        headerLogo.isDisplayed();
        WaitUntilElementVisible(buttonAkun);
        buttonAkun.isDisplayed();
        WaitUntilElementVisible(inputAddress);
        inputAddress.isDisplayed();
        return true;
    }

    public boolean successSignUp() {

        WaitUntilElementVisible(modalPhoneVerification);
        modalPhoneVerification.isDisplayed();
        return true;
    }

    public boolean homePageAfterLoginIsDisplayed() {

        WaitUntilElementVisible(headerLogo);
        headerLogo.isDisplayed();
        WaitUntilElementVisible(buttonAkunAfterLogin);
        buttonAkunAfterLogin.isDisplayed();
        WaitUntilElementVisible(inputAddress);
        inputAddress.isDisplayed();
        return true;
    }

    public boolean loginFormIsDisplayed() {

        WaitUntilElementVisible(inputEmail);
        inputEmail.isDisplayed();
        WaitUntilElementVisible(inputPassword);
        inputPassword.isDisplayed();
        WaitUntilElementVisible(buttonLogin);
        buttonLogin.isDisplayed();
        WaitUntilElementVisible(linkSignUp);
        linkSignUp.isDisplayed();
        return true;
    }

    public boolean signUpFormIsDisplayed(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WaitUntilElementVisible(inputFirstName);
        inputFirstName.isDisplayed();
        WaitUntilElementVisible(inputLastName);
        inputLastName.isDisplayed();
        WaitUntilElementVisible(inputPhoneNumber);
        inputPhoneNumber.isDisplayed();
        WaitUntilElementVisible(inputSignUpEmail);
        inputSignUpEmail.isDisplayed();
        WaitUntilElementVisible(inputSignUpPassword);
        inputSignUpPassword.isDisplayed();
        WaitUntilElementVisible(buttonSignUp);
        buttonSignUp.isDisplayed();
        return true;
    }

    public void clickAkunMenu() {

        WaitUntilElementVisible(buttonAkun);
        buttonAkun.isDisplayed();
        buttonAkun.click();
    }

    public void fillEmail(String email){

        WaitUntilElementVisible(inputEmail);
        inputEmail.isEnabled();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void fillPassword(String password) {

        WaitUntilElementVisible(inputPassword);
        inputPassword.isEnabled();
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void clickButtonLogin() {

        WaitUntilElementVisible(buttonLogin);
        buttonLogin.isEnabled();
        buttonLogin.click();
    }

    public void clickSignUp() {

        WaitUntilElementVisible(linkSignUp);
        linkSignUp.isDisplayed();
        linkSignUp.click();
    }

    public void fillFirstName(String firstName) {

        WaitUntilElementVisible(inputFirstName);
        inputFirstName.isEnabled();
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {

        WaitUntilElementVisible(inputLastName);
        inputLastName.isEnabled();
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }

    public void clickCountryCode(){

        WaitUntilElementVisible(selectCountryCode);
        selectCountryCode.isEnabled();
        selectCountryCode.click();
        inputCountryCode.sendKeys(Keys.ENTER);

    }

    public String selectCountryCode () {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WaitUntilListElementVisible(valueCountryCode);
        int randomValue = random.nextInt(valueCountryCode.size());
        String countryCodeText = valueCountryCode.get(randomValue).getText();
        WaitUntilElementVisible(valueCountryCode.get(randomValue));
        WaitUntilElementIsClickable(valueCountryCode.get(randomValue));
        valueCountryCode.get(randomValue).isDisplayed();
        valueCountryCode.get(randomValue).isEnabled();
        valueCountryCode.get(randomValue).click();
        return countryCodeText;
    }

    public void fillPhoneNumber (String phone) {

        WaitUntilElementVisible(inputPhoneNumber);
        inputPhoneNumber.isEnabled();
        inputPhoneNumber.clear();
        inputPhoneNumber.sendKeys(phone);
    }

    public void fillSignUpEmail(String email) {

        WaitUntilElementVisible(inputSignUpEmail);
        inputSignUpEmail.isEnabled();
        inputSignUpEmail.clear();
        inputSignUpEmail.sendKeys(email);
    }

    public void fillSignUpPassword(String password) {

        WaitUntilElementVisible(inputSignUpPassword);
        inputSignUpPassword.isEnabled();
        inputSignUpPassword.clear();
        inputSignUpPassword.sendKeys(password);
    }

    public void clickButtonSignUp() {

        WaitUntilElementVisible(buttonSignUp);
        buttonSignUp.isEnabled();
        buttonSignUp.click();
    }

    public String selectFavouriteStore () {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WaitUntilListElementVisible(listFavouriteStore);
        int randomValue = random.nextInt(listFavouriteStore.size());
        String listStore = listFavouriteStore.get(randomValue).getText();
        WaitUntilElementVisible(listFavouriteStore.get(randomValue));
        WaitUntilElementIsClickable(listFavouriteStore.get(randomValue));
        listFavouriteStore.get(randomValue).isDisplayed();
        listFavouriteStore.get(randomValue).isEnabled();
        listFavouriteStore.get(randomValue).click();
        return listStore;
    }

    public void clickSpecialStore(){

        WaitUntilElementVisible(selectSpecialStore);
        selectSpecialStore.isDisplayed();
        selectSpecialStore.isEnabled();
        selectSpecialStore.click();
    }

    public void searchAddress(String address){

        WaitUntilElementVisible(inputAddress);
        inputAddress.isEnabled();
        inputAddress.click();
        inputAddress.sendKeys(address);
    }

    public String selectAddress () {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WaitUntilListElementVisible(listAddress);
        int randomValue = random.nextInt(listAddress.size());
        String list = listAddress.get(randomValue).getText();
        WaitUntilElementVisible(listAddress.get(randomValue));
        WaitUntilElementIsClickable(listAddress.get(randomValue));
        listAddress.get(randomValue).isDisplayed();
        listAddress.get(randomValue).isEnabled();
        listAddress.get(randomValue).click();
        return list;
    }
}
