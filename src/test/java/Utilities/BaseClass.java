package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BaseClass {

    public static WebDriver driver;
    private static WebDriverWait wait;

    public BaseClass(WebDriver driver, WebDriverWait wait) {

        BaseClass.driver = driver;
        BaseClass.wait = wait;
    }

    protected void WaitUntilElementVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void WaitUntilListElementVisible(List<WebElement> listElement) {

        wait.until(ExpectedConditions.visibilityOfAllElements(listElement));
    }
    
    protected boolean ElementIsDisabled(WebElement element) {

        return !element.isEnabled();
    }

    protected void WaitUntilElementIsClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void WaitUntilElementSelected(WebElement element) {

        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    protected void WaitUntilElementIsNotVisible(WebElement webElement) {

        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    protected void WaitUntilListElementIsNotVisible(List<WebElement> webElementList) {

        wait.until(ExpectedConditions.invisibilityOfAllElements(webElementList));
    }
}
