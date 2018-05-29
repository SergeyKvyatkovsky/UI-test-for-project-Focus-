package Pages.Administration;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GridPanel extends IPage{

    By  itemTimers = By.xpath("//*[@id = 'rowTimers']");

    public GridPanel(WebDriver driver) {
        super(driver);
    }

    public GridPanel selectTimers(){
        waitFor(itemTimers);
        click(itemTimers);
        return this;
    }

}
