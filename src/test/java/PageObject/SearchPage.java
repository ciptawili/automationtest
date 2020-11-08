package PageObject;

import Utilities.BaseClass;
import cucumber.api.java.de.Wenn;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BaseClass {

    public SearchPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h2[@class='jsx-906838217']")
    private WebElement getKeywordResult;

    @FindBy (xpath = "//h2[@class='jsx-2751153571 jsx-717190455']")
    private List<WebElement> getTitleProduct;

    @FindBy (id = "Sorting-PLP-Search")
    private WebElement comboSorting;

    @FindBy (xpath = "//div[@class='select PLP-Search-sorting-dropdown__menu css-26l3qy-menu']")
    private WebElement locateSorting;

    @FindBy (xpath = "//div[contains(text(), 'A - Z')]")
    private WebElement optionsaz;

    @FindBy (xpath = "//div[@class='select PLP-Search-sorting-dropdown__single-value css-1uccc91-singleValue']")
    private WebElement resultSorting;

    public boolean searchPageIsDisplayed() {

        WaitUntilElementVisible(StoreLandingPage.inputSearch);
        StoreLandingPage.inputSearch.isDisplayed();
        WaitUntilElementVisible(getKeywordResult);
        getKeywordResult.isDisplayed();
        WaitUntilElementVisible(comboSorting);
        comboSorting.isDisplayed();
        return true;
    }

    public String getKeywordSearch(){

        WaitUntilElementVisible(getKeywordResult);
        getKeywordResult.isDisplayed();
        return getKeywordResult.getText();
    }

    public String getTitleProduct(){

        WaitUntilListElementVisible(getTitleProduct);
        return getTitleProduct.get(1).getText();
    }

    public String getResultSorting(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WaitUntilElementVisible(resultSorting);
        resultSorting.isDisplayed();
        return resultSorting.getText();
    }

    public void clickSorting(){

        WaitUntilElementVisible(comboSorting);
        comboSorting.isEnabled();
        comboSorting.click();
    }

    public void selectSorting() {

        WaitUntilElementVisible(locateSorting);
        locateSorting.isDisplayed();
        WaitUntilElementVisible(optionsaz);
        optionsaz.isDisplayed();
        optionsaz.click();
    }
}
