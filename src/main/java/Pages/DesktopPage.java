package Pages;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class DesktopPage extends IPage{

    String desktopPage = "//div[@id='portal-body']";

    //Лимиты Всего:
    By labelLimitsAll = By.xpath(desktopPage + "/div/div[2]/*/div[2]/*/*/*/table[5]/*/*/td[2]/div");

    //Загрузка
    By loader = By.xpath("//div[contains(@id, 'loadmask')]");



    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    public DesktopPage waitLimitsAll()
    {
        waitFor(labelLimitsAll);
        return this;
    }


    //@Step("Loading")
    public DesktopPage waitForHideLoading()
    {
        waitFor(loader);
        waitForHide(loader);
        return this;
    }



}
