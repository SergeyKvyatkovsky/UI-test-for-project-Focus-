package Pages.Data;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class MenuGridPanel extends IPage {

    //Список таблиц
    By listTables = By.xpath("//div[@id='tabPanel-body']//div[contains(@id, 'menuGridView')]/table/tbody/tr/td/div");

    //Значения из списка таблиц
    //Counterpatries
    By buttonCounterparties = By.xpath("//div[@id='tabPanel-body']//div[contains(@id, 'menuGridView')]/table//td/div[text()='Counterparties']");


    public MenuGridPanel(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие таблицы 'Counterparties'")
    public MenuGridPanel clickCounterparties()
    {
        waitFor(buttonCounterparties);
        click(buttonCounterparties);
        return this;
    }


}
