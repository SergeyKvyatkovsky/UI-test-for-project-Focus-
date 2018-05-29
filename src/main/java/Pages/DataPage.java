package Pages;


import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

//import javafx.scene.control.Tab;


public class DataPage extends IPage{

    //Вкладка содержимое
    By buttonContentTab = By.xpath("//span[text()='Содержимое']/..");

    //Список таблиц
    //By listTables = By.xpath("//div[@id='tabPanel-body']//div[contains(@id, 'menuGridView')]/dataTable/tbody/tr");
    By listTables = By.xpath("//div[@id='tabPanel-body']//div[contains(@id, 'menuGridView')]/table/tbody/tr/td/div");

    //Значения из списка таблиц
    //Counterpatries
    By buttonCounterparties = By.xpath("//div[@id='tabPanel-body']//div[contains(@id, 'menuGridView')]/table//td/div[text()='Counterparties']");

    //Столбцы таблицы
    By columnsTable = By.xpath("//div[contains(@id, 'dictGrid')]/div/div/div/div/div/span");

    //Новая запись
    By buttonNewRecord = By.xpath("//span[text()='Новая запись...']");

    // Данные выбор таблици book
    By booksTable = By.xpath(".//td/div[text()='Books']");

    // Сортировка таблицы
    By sortButton = By.xpath(".//span[starts-with(@id, 'gridcolumn') and text()='Таблицы']");

    // Первый элемент таблицы    подправить Xpath пока костыль для проверки метода.
     By firstElementInFrameLeft = By.xpath(".//*[@id='menuGridView-gridview-1141']/table/tbody/tr[2]/td/div");

    //Все элементы таблицы
    By allElementTableLeft = By.xpath("//*[starts-with(@id, 'dataTab')]//div[contains(@class, 'cell-inner')]");

    public DataPage(WebDriver driver) {
        super(driver);
    }

    public DataPage waitForContentTab(){
        int i = 0;
        i++;
        waitFor(buttonContentTab);
        return this;
    }

    //@Step("Open dataTable 'Counterparties'")
    public DataPage clickCounterparties()
    {
        waitFor(buttonCounterparties);
        click(buttonCounterparties);
        return this;
    }

    //@Step("ChooseBookInTable")
    public DataPage chooseBookInTable(){
        waitFor(booksTable);
        click(booksTable);
        return this;
    }

    //Сортировка таблицы
    public DataPage sort(){
        click(sortButton);
        return this;
    }

    public DataPage sortAseertion(){
        List listForm = new ArrayList();
        for(int k=0;  k<getSizeOfElements(allElementTableLeft); k++) {
            String text = getElement(allElementTableLeft, k).getText();
            listForm.add(text);
            System.out.println(text);
        }
            String indexStr = String.valueOf(listForm.get(0));
            String textForComparison = getText(firstElementInFrameLeft);
            System.out.println(textForComparison);
            System.out.println(indexStr);
            waitSeconds(1000);  //этот вэйт для дебаг точки пока не убирайте.
            Assert.assertEquals(textForComparison,indexStr);
        return this;
    }

    @Step("Check columns")
    public boolean checkColumnNames(ArrayList<String> listFromParametes) throws InterruptedException {
        ArrayList<String> listFromTest = new ArrayList<>();
        waitFor(columnsTable);

        for (int i=0; i<getSizeOfElements(columnsTable); i++){
            moveTo(getElement(columnsTable, i));
            listFromTest.add(getElement(columnsTable, i).getText());
            //System.out.println(getSizeOfElements(columnsTable)+"      " + getElement(columnsTable, i).getText());
        }

        if (listFromParametes.containsAll(listFromTest) && listFromTest.containsAll(listFromParametes))
            return true;
        else
            return false;
    }



}
