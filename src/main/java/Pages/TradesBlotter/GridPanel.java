package Pages.TradesBlotter;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GridPanel extends IPage{

    final static String TABLE = "//div[starts-with(@id, 'tblTrades')]";

    final static String CHILD_DIV = "./td/div";

    By listDivFirstColumn = By.xpath(TABLE + "//td[1]/div[contains(@class, 'x-grid-cell')]");

    By spanFirstColumnHeader = By.xpath(TABLE + "//span[contains(@class, 'x-column-header')][1]");

    //Заголовки таблицы
    By listSpanColumnHeaders = By.xpath(TABLE + "//span[contains(@class, 'x-column-header')]");

    By listDivGridCell = By.xpath(TABLE + "//td");

    By rows = By.xpath(TABLE + "//tr[starts-with(@class, 'x-grid-row')]");

    public GridPanel(WebDriver driver) {
        super(driver);
    }

    public GridPanel sortColumn(){
        waitFor(spanFirstColumnHeader);
        click(spanFirstColumnHeader);
        return this;
    }

    //Получение текста эл-тов из первого столбца
    public List<String> getTextFromColumns(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i<getSizeOfElements(listDivFirstColumn); i++)
        {
            list.add(getElement(listDivFirstColumn, i).getText());
        }
        return list;
    }

    public List<String> getValuesFromColumn(String columnName){
        int index = getIndexFromList(listSpanColumnHeaders, columnName);
        int rowsCount = getSizeOfElements(rows);
        List<String> values = new ArrayList<String>();
        for (int i=0; i<rowsCount; i++){
            values.add(getElement(rows, i).findElements(By.xpath(CHILD_DIV)).get(index).getText());
        }
        return values;
    }
}
