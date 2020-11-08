package PageObject;

import Utilities.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StoreLandingPage extends BaseClass {

    public StoreLandingPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "header-store-info")
    private WebElement infoStore;

    @FindBy(id = "searchbar-input")
    public static WebElement inputSearch;


    public boolean storeLandingPageIsDisplayed(){

        WaitUntilElementVisible(infoStore);
        infoStore.isDisplayed();
        WaitUntilElementVisible(HomePage.headerLogo);
        HomePage.headerLogo.isDisplayed();
        WaitUntilElementVisible(inputSearch);
        inputSearch.isDisplayed();
        return true;
    }

    public void searchProduct(String keyword) {

        WaitUntilElementVisible(inputSearch);
        inputSearch.isEnabled();
        inputSearch.click();
        inputSearch.sendKeys(keyword);
        inputSearch.sendKeys(Keys.ENTER);
    }


}
