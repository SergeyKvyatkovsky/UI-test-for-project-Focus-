package Pages.Data;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class Table extends IPage{

    //Столбцы таблицы
    //TODO Лыгин должен изменить id у таблицы
    //By columnsTable = By.xpath("//div[contains(@id, 'dictGrid')]/div/div/div/div/div/span");
    By columnsTable = By.xpath("//div[contains(@id, 'dictGrid')]//span[contains(@id, 'gridcolumn')]");

    //Строка таблицы
    By rowsTable = By.xpath("//div[starts-with(@id, 'dictGrid-gridpanel')]//table[@class = 'x-grid-table x-grid-table-resizer']//tr[contains(@class, 'x-grid-row')]");

    //Кнопка "След. страница"
    By buttonNextPage = By.xpath("//button[starts-with(@id, 'next-button')]");

    //Кнопка "Пред. страница"
    By buttonPrevPage = By.xpath("//button[starts-with(@id, 'prev-button')]");

    //Кнопка "Послед. страница"
    By buttonLastPage = By.xpath("//button[starts-with(@id, 'last-button')]");

    //Кнопка "Перв. страница"
    By buttonFirstPage = By.xpath("//button[starts-with(@id, 'first-button')]");

    By inputNumberPage = By.xpath("//input[starts-with(@id, 'inputItem-numberfield')]");

    // В колонках выпадающий список.
    By dropDownHeaderColumsList = By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[1]/span");

    // Кнопка выпадающего меню.
    By dropDownHeaderColumsListTwo = By.xpath("//body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div[1]/div");

    // В выпадающем списке выбор меню "Столбцы"
    By selectColumsInDropDownHeaderColumsList = By.xpath(".//a[starts-with(@id, 'columnItem-menuitem')]");

    // Выбор шапки элементов таблицы books
    By rowsInTheColums = By.xpath(".//body/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div");

    //Чек-бокс в выпающем меню с текстом Id
    By checkBocks = By.xpath("//div[starts-with(@id, 'menucheckitem')]/a[starts-with(@id, 'menucheckitem')]");

    public Table(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка столбцов")
    public boolean checkColumnNames(ArrayList<String> listFromParametes) throws InterruptedException {
        ArrayList<String> listFromTest = new ArrayList<>();
        waitFor(columnsTable);

        for (int i=0; i<getSizeOfElements(columnsTable); i++){
            moveTo(getElement(columnsTable, i));
            listFromTest.add(getElement(columnsTable, i).getText());
            System.out.println(getSizeOfElements(columnsTable)+"      " + getElement(columnsTable, i).getText());
        }

        if (listFromParametes.containsAll(listFromTest) && listFromTest.containsAll(listFromParametes))
            return true;
        else
            return false;
    }

    public Table clickRow(int row){

        getElement(rowsTable, row);
        waitFor(rowsTable);
        doubleClick(getElement(rowsTable, row));

        return this;
    }

    public String getNumberPage(){

        return getText(inputNumberPage);
    }

    public Table clickDropDownColumsListAndClickCheckBoxID(){  // Убираем check-box  ID

        click(dropDownHeaderColumsList);
        click(dropDownHeaderColumsListTwo);
        moveTo(selectColumsInDropDownHeaderColumsList);
        waitFor(checkBocks);
        click(checkBocks);

        return this;
    }

    public Table sizeHeaderRows(){

        waitForHide(rowsInTheColums);   // Вставляем в Массив headerRows все элементы шапки таблицы.
        waitFor(rowsInTheColums);
        List headerRows = new ArrayList();
        for(int i=0; i<getSizeOfElements(rowsInTheColums); i++) {
            String nameColums = getElement(rowsInTheColums, i).getText();
            headerRows.add(nameColums);
            System.out.println(nameColums);
        }

        int rows = headerRows.size();
        System.out.println(rows);
        Assert.assertEquals(getSizeOfElements(rowsInTheColums), rows);

        clickDropDownColumsListAndClickCheckBoxID(); // Нажимаем check-box

        waitForHide(rowsInTheColums);     // Вставляем в Массив headerRowsAfterClick все видимые после
        List headerRowsAfterClick = new ArrayList();  // нажатия на check-box элементы шапки таблицы.
        for(int i=0;  i<getSizeOfElements(rowsInTheColums); i++) {
            String nameColums = getElement(rowsInTheColums, i).getText();
            headerRowsAfterClick.add(nameColums);
            System.out.println(nameColums);
        }

        int rowsAfterClick = headerRowsAfterClick.size();
        System.out.println(rowsAfterClick);
        Assert.assertEquals(getSizeOfElements(rowsInTheColums), rowsAfterClick);
        System.out.println(headerRowsAfterClick);
        System.out.println(headerRows);

        headerRows.get(0).equals(headerRowsAfterClick.get(0));
        Assert.assertNotEquals(headerRows.get(0), headerRowsAfterClick.get(0)); // Сравниваем два массива.

        return this;
    };

   /* public Table clickNewRecordRow(){
        waitFor(divRecordNew);
        click(divRecordNew);
        return this;
    }

    public Table clickEditRecordRow(){
        waitFor(divRecordEdit);
        click(divRecordEdit);
        return this;
    }*/

}
