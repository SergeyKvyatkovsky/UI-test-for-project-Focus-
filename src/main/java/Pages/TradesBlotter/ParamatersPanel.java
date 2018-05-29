package Pages.TradesBlotter;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class ParamatersPanel extends IPage{

    //Кнопка Активировать/Деактивировать журнал
    By buttonStartStopBlotter = By.xpath("//button[starts-with(@id, 'btnStartStopBlotter')]");

    //Поле "Идентиф-ры"
    By inputTradeId = By.name("trade_id");

    public ParamatersPanel(WebDriver driver) {
        super(driver);
    }

    @Step("Активаация/деактивация журнала")
    public ParamatersPanel startStopBlotter(){
        waitFor(buttonStartStopBlotter);
        click(buttonStartStopBlotter);
        return this;
    }

    public ParamatersPanel typeTradeId(String id){
        sendKeys(inputTradeId, id);
        return this;
    }
}
