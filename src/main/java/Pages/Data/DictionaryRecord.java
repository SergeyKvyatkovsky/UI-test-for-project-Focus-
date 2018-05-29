package Pages.Data;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class DictionaryRecord extends IPage{

    By spanDictionaryRecordHeader = By.xpath("//span[contains(@id, 'winDictionaryRecord') and text()='Новая запись']");

    //Поле Id
    By inputId = By.xpath("//input[starts-with(@id, 'fldId-lsnumberfield')]");

    //Поле Name
    By inputName = By.xpath("//label[text()='Name:']//following::input[1]");

    //Поле ShortName
    By inputShortName = By.xpath("//label[text()='ShortName:']//following::input[1]");

    //Чекбокс isClient
    By checkboxIsClient = By.xpath("//label[text()='IsClient:']//following::input[1]");

    //Чекбокс IsIssuer
    By checkboxIsIssuer = By.xpath("//input[starts-with(@id, 'fldIssuer-checkboxfield')]");

    //Поле Type
    By inputType = By.xpath("//label[text()='Type:']//following::input[1]");

    //Поле поиска
    By inputSearch = By.xpath("//label[text()='Поиск:']//following::input[1]");

    //Тип Counterparties -> Individual
    //By divTypeIndividual = By.xpath("//div[contains(@id, 'gridpanel')]/div/table/tbody/tr/td/div[text()='Individual']");
    By divTypeIndividual = By.xpath("//div[contains(@id, 'grData-gridpanel')]//div[text()='Individual']");


    //Тип Counterparties -> Corporate
    By divTypeCorporate = By.xpath("//div[contains(@id, 'gridpanel')]/div/table/tbody/tr/td/div[text()='Corporate']");

    //Тип Counterparties
    //TODO Попросить Лыгина добавить ид
    //By divTypes = By.xpath("//div[contains(@id,'winDictionaryRecord-dictionarywindow')]/table//div[contains(@class, 'grid-cell')]");


    //===========Общие=============
    //Кнопка Выбрать
    By buttonSelect = By.xpath("//button[contains(@id, 'btnSelect')]/span[text()='Выбрать']");

    //Кнопка Сохранить
    By buttonSave = By.xpath("//div[contains(@id, 'toolbar')]//button[contains(@id, 'btnSave')]/span[text()='Сохранить']");

    //Кнопка Удалить
    By buttonDelete = By.xpath("//button[starts-with(@id, 'btnDelete-button')]");

    //Сообщение - Кнопка Да
    By buttonYes = By.xpath("//button[starts-with(@id, 'yes-button')]");

    //Кнопка Редактировать
    By buttonEdit = By.xpath("//button[starts-with(@id, 'btnEdit-button')]");

    public DictionaryRecord(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку 'Новая запись'")
    public DictionaryRecord waitForHeader(){
        waitFor(spanDictionaryRecordHeader);
        return this;
    }

    public DictionaryRecord typeName(String name){
        waitFor(inputName);
        clear(inputName);
        sendKeys(inputName, name);
        return this;
    }

    public DictionaryRecord typeShortName(String shortName){
        waitFor(inputShortName);
        clear(inputShortName);
        sendKeys(inputShortName, shortName);
        return this;
    }

    public DictionaryRecord clickIsClient(){
        waitFor(checkboxIsClient);
        click(checkboxIsClient);
        return this;
    }

    public DictionaryRecord clickType(){
        waitFor(inputType);
        click(inputType);
        return this;
    }

    //Выбрать тип
    @Step("Выбор типа контрагента")
    public DictionaryRecord selectType(By by){
        waitFor(by);


       //waitForClickable(by);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        moveTo(by);

        click(by);
        waitFor(buttonSelect);
        click(buttonSelect);
        waitForHide(buttonSelect);
        return this;
    }

    public DictionaryRecord selectTypeIndividual(){
        selectType(divTypeIndividual);
        return this;
    }

    public DictionaryRecord selectTypeCorporate(){
        selectType(divTypeCorporate);
        return this;
    }

//    public DictionaryRecord waitForTypeIndividual(){
//        waitFor(divTypeIndividual);
//        return this;
//    }
//
//    public DictionaryRecord selectType(){
//        click(divTypeIndividual);
//        waitFor(buttonSelect);
//        click(buttonSelect);
//        waitForHide(buttonSelect);
//        return this;
//    }

    public DictionaryRecord checkTypeField(){
        //getName(inputType.findElement())
        System.out.println(getName(inputType));
        return this;
    }

    @Step("Сохранение новой записи")
    public DictionaryRecord saveRecord(){
        waitFor(buttonSave);
        click(buttonSave);
        return this;
    }

    //Нажать кнопку Удалить
    public DictionaryRecord clickDeleteButton(){
        waitFor(buttonDelete);
        click(buttonDelete);
        return this;
    }

    //Нажатие да в messagebox
    public DictionaryRecord clickYesInMessageBox(){
        waitFor(buttonYes);
        click(buttonYes);
        return this;
    }

    //Проверка Id
    public DictionaryRecord assertId(String id){

        waitFor(inputId);
        Assert.assertEquals(getValue(inputId) ,id);
        return this;
    }

    public DictionaryRecord clickEdit(){
        waitFor(buttonEdit);
        click(buttonEdit);
        waitFor(buttonSave);
        return this;
    }

    public DictionaryRecord clickIsIssuer(){
        waitFor(checkboxIsIssuer);
        click(checkboxIsIssuer);
        return this;
    }
}
