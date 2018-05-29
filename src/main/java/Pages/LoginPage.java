package Pages;


import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends IPage {

    //Поле логина
    By inputUsername = By.id("username");

    //Поле пароля
    By inputPassword = By.id("psswrd");

    //Кнопка авторизации "Sign in"
    By buttonLoginSubmit = By.id("submit");

    //Поле поиска
    By inputFindForm = By.xpath(".//*[@id='cmbSearchItems-combobox-1059-inputEl']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username)
    {
        waitFor(inputUsername);
        sendKeys(inputUsername, username);
        return this;
    }

    public LoginPage typePassword(String password)
    {
        waitFor(inputPassword);
        sendKeys(inputPassword, password);
        return this;
    }

    public LoginPage submit()
    {
        waitFor(buttonLoginSubmit);
        click(buttonLoginSubmit);
        return this;
    }

    @Step("Авторизация")
    public LoginPage authorization(String username, String password)
    {
        waitForSubmit();
        typeUsername(username);
        typePassword(password);
        submit();

        return this;
    }

    public LoginPage waitForSubmit(){
        waitFor(buttonLoginSubmit);

        return this;
    }

}
