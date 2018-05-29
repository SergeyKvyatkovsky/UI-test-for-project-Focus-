package Pages.Data;

import Core.IPage;
import Pages.MainFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Toolbar extends IPage{

    //Вкладка содержимое
    By buttonContentTab = By.xpath("//span[text()='Содержимое']/..");

    //Новая запись
    //By buttonNewRecord = By.xpath("//span[text()='Новая запись...']");
    By buttonNewRecord = By.xpath("//button[contains(@id, 'newItemButton-button')]");

    //Строка поиска
    By inputSearch = By.xpath("//input[starts-with(@id, 'search-lssearchfield') and @type='text']");

    By firstRecordingInTable = By.xpath(".//div[starts-with(@id,'gridview')]/table/tbody/tr[2]/td[2]/div");

    public Toolbar(WebDriver driver) {
        super(driver);
    }

    public Toolbar waitForContentTab(){
        waitFor(buttonContentTab);
        return this;
    }

    //Нажатие на 'Новая запись'
    public Toolbar clickNewRecord(){
        waitFor(buttonNewRecord);
        click(buttonNewRecord);
        return this;
    }

    public Toolbar typeInSearchInput(String text){
        waitFor(inputSearch);
        clear(inputSearch);
        sendKeys(inputSearch, text);
        return this;
    }
    // В форме поиска в закладке дата ввод,поиск сранение с вводимым значением.
    public Toolbar findDataMenu(String inputValues){
        waitSeconds(2000); //Нужно убрать wait'ы, но благодаря Ajax mainFrame.waitForHideLoading();  не рабоатет.
        sendKeys(inputSearch,inputValues);
        waitSeconds(3000);
        String value = getElement(firstRecordingInTable, 0).getText();
        Assert.assertEquals(value,inputValues);
        return this;
    }
}
