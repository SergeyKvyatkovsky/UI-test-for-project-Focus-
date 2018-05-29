package Pages;

import Core.IPage;
import Helpers.UserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static Core.ITest.tradeParametersPanel;
import static Core.ITest.username;
import static org.openqa.selenium.Keys.ALT;

public class HeaderForm extends IPage{

    //Иконка пользователя
    By menuUser = By.className("ls-login-icon");

    //Мои настройки
    //By buttonMySettings = By.xpath("//span[text()='Мои настройки']");
    By buttonMySettings = By.xpath("//span[contains(@id, 'mitUserSettings-menuitem')]");

    //Выйти
    //By buttonLogout = By.xpath("//div[contains(@id, 'settingsmenu')]//span[text()='Выйти']");
    By buttonLogout = By.xpath("//span[contains(@id, 'mitSignout-menuitem')]");

    //Вкладка "Данные"
    //By buttonDataTab = By.xpath("//span[text()='Данные']/..");
    By buttonDataTab = By.xpath("//button[contains(@id, 'tbData-tab')]");

    //Вкладка Лимиты
    By buttonLimitsTab = By.xpath("//button[starts-with(@id, 'tbLimits-tab')]");

    //Вкладка Администрирование
    By buttonAdminTab = By.xpath("//button[starts-with(@id, 'tbAdmin-tab')]");

    //Кнопка Добавить
    By buttonReportsMenu = By.xpath("//button[starts-with(@id, 'btnReportsMenu-button')]");

    //Журналы
    By listDivTabMenu = By.xpath("//div[@id='menuTree-body']/div[starts-with(@id, 'treeview')]//td[contains(@id,'mit')]/div");

    //Закрыть вкладку
    By aCloseTab = By.xpath("//a[@class='x-tab-close-btn']");

    public HeaderForm(WebDriver driver) {
        super(driver);
    }

    @Step("Logout")
    public HeaderForm logout(){
        waitFor(menuUser);
        click(menuUser);
        waitFor(buttonLogout);
        isElementPresent(buttonLogout);
        click(buttonLogout);
        return this;
    }

    @Step("Click tab 'Data'")
    public HeaderForm clickDataTab(){
        waitFor(buttonDataTab);
        click(buttonDataTab);
        return this;
    }

    @Step("Переход на вкладку 'Лимиты'")
    public HeaderForm clickLimitsTab(){
        waitFor(buttonLimitsTab);
        click(buttonLimitsTab);
        return this;
    }

    @Step("Переход на вкладку 'Администрирование'")
    public HeaderForm clickAdminTab(){
        waitFor(buttonAdminTab);
        click(buttonAdminTab);
        return this;
    }

    @Step("Проверка имени пользователя")
    public HeaderForm checkUsername(String username){
        waitFor(menuUser);
        System.out.println(getText(menuUser));
        Assert.assertEquals(username, getText(menuUser));
        return this;
    }

    @Step("Создание вкладки журнал сделок")
    public HeaderForm creatAndCkickTransactionLog(){
        String pressBoth = Keys.chord(Keys.ALT, "T");
        sendKeys(buttonDataTab,pressBoth);  // сменить паз на рабочий стол.
        return this;
    }

    @Step("Создание журнала сделок")
    public IPage addTradesBlotter(/*String journalName*/){
        waitFor(buttonReportsMenu);
        click(buttonReportsMenu);
        waitFor(listDivTabMenu);
        getElementFromList(listDivTabMenu, "Журнал сделок").click();
        return this;
    }

    @Step("Закрытие вкладки")
    public HeaderForm closeTab(){
        waitFor(aCloseTab);
        click(aCloseTab);
        return this;
    }

}
