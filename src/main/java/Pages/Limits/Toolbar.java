package Pages.Limits;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import javax.tools.Tool;

public class Toolbar extends IPage{

    //Кнопка Создать подкатегорию
    By buttonCreateSubcategory = By.xpath("//button[starts-with(@id, 'btnNewSubcategory-button')]");

    //Кнопка "Посмотреть категорию"
    By buttonViewCategory = By.xpath("//button[starts-with(@id, 'btnViewCategory')]");

    //Заголовок категории
    By divCategoryHeader = By.xpath("//div[@class='lim-cat-header']");

    //Кнопка "Создать лимит"
    By buttonNewLimit = By.xpath("//button[starts-with(@id, 'btnNewLimit-button')]");

    //? Лимит CEEBS
    By spanLimitCEEBS = By.xpath("//div[starts-with(@id, 'newLimitMenu')]//span[contains(text(), 'CEEBS')]");

    By spanLimitOPA = By.xpath("//div[starts-with(@id, 'newLimitMenu')]//span[contains(text(), 'OPA')]");

    //Клонировать
    By spanClone = By.xpath("//img[contains(@class, 'limit-clone')]/../span[contains(@id, 'menuitem')]");


    //Форма поиска в закладке лимит.
    By findFormLimits = By.xpath(".//input[starts-with(@id,'cmbSearchItems')]");

    //Первый элемент из выпадающего списка поиска.
    By firstElementINDropDownList = By.xpath(".//*[starts-with(@id, 'boundlist')]/div/span[1]");

    By firstElementINDropDownListForAssert= By.xpath(".//*[starts-with(@id, 'boundlist')]/div[1]");

    public Toolbar(WebDriver driver) {
        super(driver);
    }

    @Step("Создание подкатегории")
    public Toolbar createSubcategory(){
        waitFor(buttonCreateSubcategory);
        click(buttonCreateSubcategory);
        return this;
    }

    public Toolbar checkCategoryHeader(String name){
        waitFor(divCategoryHeader);
        Assert.assertEquals(getText(divCategoryHeader), name);
        return this;
    }

    @Step("Просмотр категории")
    public Toolbar viewCategory(){
        waitFor(buttonViewCategory);
        click(buttonViewCategory);
        return this;
    }

    public Toolbar createNewLimit(){
        waitFor(buttonNewLimit);
        click(buttonNewLimit);
        return this;
    }

    public Toolbar selectCEEBS(){
        waitFor(spanLimitCEEBS);
        click(spanLimitCEEBS);
        return this;
    }

    public Toolbar selectOPA(){
        waitFor(spanLimitOPA);
        click(spanLimitOPA);
        return this;
    }

    public Toolbar clickClone(){
        waitFor(spanClone);
        click(spanClone);
        return this;
    }
    public Toolbar inputFindFormLimits(String findWord) {
        click(findFormLimits);
        waitFor(findFormLimits);
        sendKeys(findFormLimits,findWord);
     //   waitSeconds(5000);
        waitFor(firstElementINDropDownList);
        String textInElementT = getElement(By.xpath(" .//*[starts-with(@id, 'boundlist')]/div[1]"),0).getText();
        System.out.println(textInElementT);
        textInElementT.contains(findWord);
        Assert.assertTrue(textInElementT.contains(findWord));
      //  waitSeconds(5000);
        click(firstElementINDropDownList);
        waitFor(buttonViewCategory);
        return this;
    }
}
