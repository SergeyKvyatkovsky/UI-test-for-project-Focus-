package Pages.TradesBlotter;

import Core.IPage;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;
import java.util.*;

import static Core.ITest.mainFrame;

public class Toolbar extends IPage{

    //Новая сделка
    By buttonNewTrade = By.xpath("//button[starts-with(@id, 'newTradeButton-button')]");

    //Список сделок
    By listNewTradeMenu = By.xpath("//div[starts-with(@id, 'mnuNewTrade-menu')]//span[starts-with(@id, 'menuitem')]");

    //Форма поиска Индентиф-ры
    By formIdInList = By.xpath(".//input[@name='trade_id']");

    //Первый элемент поиска ID обращается к ID.
    By firstElementID = By.xpath(".//body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/table/tbody/tr[2]/td[1]");

    By FirstElementType = By.xpath(".//body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/table/tbody/tr[2]/td[4]");

    //Кнопка активировать
    By buttonActivate = By.xpath(".//span[text()='Активировать журнал']");

    By allElementsDeal = By.xpath(".//body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/table/tbody/tr[2]");

    //Вкладка авторизации в свойствах сделки
    By elementInDealAutorization = By.xpath(".//span[text()='Авторизация']");

    //Вкладка параметры  в свойствах сделки поле Айди
    By elementInDealAutorizationID = By.xpath(".//div[text()='Id']//following::td[1]/div[1]");

    //Вкладка авторизация  в свойствах сделки поле статус
    By elementInDealAutorizationStatus = By.xpath(".//label[text()='Статус:']//following::td/div[starts-with(@id, 'authStatus-displayfield')]");

    //Вкладка лимит  в свойствах сделки
    By elementInDealLimit = By.xpath(".//span[starts-with(@id, 'tab')and text()='Лимиты']");

    //Вкладка детали  в свойствах сделки
    By elementInDealDetail = By.xpath(".//span[text()='Детали']");

    //Вкладка детали  в свойствах сделки поле дата
    By ElementInDealDetailData = By.xpath(".//div[text()='Date']//following::td[1]/div[1]");

    //Вкладка обзательства  в свойствах сделки
    By elementInDealLiabilities = By.xpath(".//span[text()='Обязательства']");

    //Кнопка удалить в форме редатирования сделки
    By buttonDelete = By.xpath("//span[text()='Удалить']");

    //Кнопка Да в форме редатирования сделки после удаления
    By buttonYesAdterDelete = By.xpath("//span[text()='Да']");

    //Кнопка Сохранить в форме редатирования сделки
    By buttonSaveInFormEdit = By.xpath("//span[text()='Сохранить' and starts-with(@id, 'btnSave')]");

    //Дата изменения сделки из главной таблицы
    By dataEdit = By.xpath(".//body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/table/tbody/tr[2]/td[21]");

    //В меню правой кнопки мыши кнопка редактировать сделку
    By afterClickPKMMenuEdit = By.xpath("//span[text()='Редактировать сделку...']");



    public Toolbar(WebDriver driver) {
        super(driver);
    }

    @Step("Создание новой сделки")
    public Toolbar createNewTrade(String tradeType){
        waitFor(buttonNewTrade);
        click(buttonNewTrade);
        waitFor(listNewTradeMenu);
        getElementFromList(listNewTradeMenu, tradeType).click();
        return this;
    }

    @Step("Ввод в форму Индентиф-ры")
    public Toolbar inputIDInForm(String ID,String type){
        sendKeys(formIdInList,ID);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String textInTableID = getText(firstElementID);
        String textInTableType = getText(FirstElementType);
        System.out.println("Текст введённый в таблице:"+textInTableID);
        Assert.assertEquals(textInTableID,ID);
        Assert.assertEquals(textInTableType,type);
        return this;
    }

    @Step("Проверка полей при просмотре журнала сделок")
    public List<String> сheckingАieldsViewTransactionLog(){

        List<String> listForm = new ArrayList<String>();
        waitSeconds(3000);
        for(int i = 0; i<getSizeOfElements(allElementsDeal); i++) {
            String d = getElement(allElementsDeal,i).getText();
            listForm.addAll(Arrays.asList(d.split("\n")));
        }
        waitSeconds(2000);
        doubleClick(firstElementID);
        System.out.println(listForm);
        return listForm;
    }

    @Step("Проверка полей при просмотре журнала сделок нажать вкладку авторизация") //Рефактор
    public Toolbar сheckingTransactionLogAutorization(List<String> listform){

        System.out.println(listform);
        mainFrame.waitForHideLoading();
        click(elementInDealAutorizationID);
        String id = getText(elementInDealAutorizationID);
        System.out.println("Ищем:" + id);
        if (listform != null) {
            boolean b = listform.contains(id);
            System.out.println("Проверка вкладки Параметры:" + b);
        } else {
            System.out.println("listform is null!");
        }


        click(elementInDealAutorization);
        mainFrame.waitForHideLoading();
        String atorization = getText(elementInDealAutorizationStatus);
        System.out.println("Ищем:" + atorization);
        if (listform != null) {
            boolean b = listform.contains(atorization);
            System.out.println("Проверка вкладки Авторизация:" + b);
        } else {
            System.out.println("listform is null!");
        }

        click(elementInDealLimit);

        click(elementInDealDetail);
        mainFrame.waitForHideLoading();
        String outstandingAmount = getText(By.xpath(".//div[text()='Outstanding Quantity']//following::td[1]/div[1]"));
        System.out.println("Ищем:" + outstandingAmount);
        if (listform != null) {
            boolean b = listform.contains(outstandingAmount);
            System.out.println("Проверка вкладки Детали:" + b);
        } else {
            System.out.println("listform is null!");
        }
        mainFrame.waitForHideLoading();
        String date = getText(ElementInDealDetailData);
        System.out.println("Ищем:" + date);
        if (listform != null) {
            boolean b = listform.contains(date);
            System.out.println("Проверка вкладки Детали:" + b);

        } else {
            System.out.println("listform is null!");
        }

        click(elementInDealLiabilities);
        return this;
    }

    @Step("Нажатие на кнопку Ативировать") //Рефактор
    public Toolbar chooseEditDeal(){
        mainFrame.waitForHideLoading();
        rightClick(firstElementID);
        click(afterClickPKMMenuEdit);
        return this;
    }

    @Step("Нажатие на кнопку делите и затем да")
    public Toolbar alertEditDealPressDelet(){
        mainFrame.waitForHideLoading();
        click(buttonDelete);
        click(buttonYesAdterDelete);
        return this;
    }

    @Step("Айди для сравнения во внешний мир")
    public String receivingID(){
        mainFrame.waitForHideLoading();
        String receivID = getText(firstElementID);
        System.out.println(receivID);
        return receivID;
    }

    @Step("Сравнение айди до и после удаления")
    public Toolbar assertDeleteDeals(String receivID){
        System.out.println(receivID);
        String extentedID = getText(firstElementID);
        Assert.assertNotEquals(receivID,extentedID);
        return this;
    }

    @Step("Кнопка сохранить")
    public Toolbar alertEditDealPressSave(){
        click(buttonSaveInFormEdit);
        return this;
    }


    @Step("Нажатие на кнопку Ативировать")
    public Toolbar pressButtonActiv(){
        click(buttonActivate);
        return this;
    }

    @Step("Сравнение даты")
    public Toolbar assertEditData(){
        mainFrame.waitForHideLoading();
        String dateForm = getText(dataEdit);
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String dateStr = format1.format(d);
        System.out.println("from " + dateForm);
        System.out.println("str " + dateStr);
        Assert.assertEquals(dateStr,dateForm);
        return this;
    }
 }

