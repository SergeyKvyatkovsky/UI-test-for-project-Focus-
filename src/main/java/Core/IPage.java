package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Helpers.ParamReader.getParameterByXpath;
import static Helpers.ParameterFiles.GENERAL;

public class IPage {

    private final WebDriver driver;

    int timeWaitFor = 20;
    int timeWaitForHide = 20;

    //int timeWaitFor = Integer.parseInt(getParameterByXpath(GENERAL, "//timeWaitFor/text()"));
    //int timeWaitForHide = Integer.parseInt(getParameterByXpath(GENERAL, "//timeWaitForHide/text()"));

    public IPage(WebDriver driver) {
        //int timeWaitFor = Integer.parseInt(ParamReader.getParameter("timeWaitFor"));
        //int timeWaitForHide = Integer.parseInt(ParamReader.getParameter("timeWaitForHide"));

        this.driver = driver;
    }

    protected boolean click(By By)
    {
        driver.findElement(By).click();
        return true;
    }

    protected void doubleClick(By by){
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(by)).perform();
    }

    protected void doubleClick(WebElement e){
        Actions action = new Actions(driver);
        action.doubleClick(e).perform();
    }

    protected void rightClick(By by){
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(by)).perform();
    }

    protected void sendKeys(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    protected void clear(By by){
        driver.findElement(by).clear();
    }

    protected void sendKeys(By by, Keys key)
    {
        driver.findElement(by).sendKeys(key);
    }

    protected void waitForPresence(By locator){
        (new WebDriverWait(driver, timeWaitFor)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitFor(By locator)
    {
        //(new WebDriverWait(driver, timeWaitFor)).until(ExpectedConditions.presenceOfElementLocated(locator));
        (new WebDriverWait(driver, timeWaitFor)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement getElementFromList(By locator, String elementName){
        //Map<String, WebElement> map = new HashMap<String, WebElement>();
        WebElement webElement;
        WebElement targetElement = null;
        for(int i=0; i<getSizeOfElements(locator); i++)
        {
            webElement = getElement(locator, i);
            //map.put(webElement.getText(), webElement);
            if (webElement.getText().equals(elementName))
                targetElement = webElement;
        }
        return targetElement;
    }

    protected int getIndexFromList(By locator, String elementName){
        int index = 0;
        WebElement webElement;
        for(int i=0; i<getSizeOfElements(locator); i++)
        {
            webElement = getElement(locator, i);
            if (webElement.getText().equals(elementName))
                index = i;
        }
        return index;
    }

    protected void waitForHide(By locator)
    {
        (new WebDriverWait(driver, timeWaitForHide))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitSeconds(long miliseconds)
    {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean isElementPresent(By by)
    {
        if (driver.findElement(by).isDisplayed())
            return true;
        else
            return false;
    }

    protected WebElement getElement(By by, int position)
    {
        WebElement w = driver.findElements(by).get(position);
        return w;
    }

    protected List<WebElement> getElements(By by){
        return driver.findElements(by);
    }

    protected int getSizeOfElements(By by)
    {
        int s = driver.findElements(by).size();
        return s;
    }

    protected void moveTo(WebElement e)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(e).perform();
    }

    protected void moveTo(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    protected String getText(By by){
        return driver.findElement(by).getText();
    }

    protected String getName(By by){
        return driver.findElement(by).getAttribute("name");
    }

    protected String getValue(By by) { return driver.findElement(by).getAttribute("value"); }

    protected boolean isAttributeExist(By by, String attributeName){
        if (driver.findElement(by).getAttribute(attributeName)==null)
            return false;
        else
            return true;
    }

}