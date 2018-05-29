package Pages;

import Core.IPage;
import Helpers.TextHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class MainFrame extends IPage{

    //Сообщение запись сохранена
    //By messageSuccessSaving = By.xpath("//div[@class='msg-success']/p[contains(text(), 'сохранена')]");
    By messageSuccessMessage = By.xpath("//div[@class='msg-success']/p");
    By messageErrorMessage = By.xpath("//div[@class='msg-error']/p");

    //Загрузка
    By loader = By.xpath("//div[contains(@id, 'loadmask')]");

    public MainFrame(WebDriver driver) {
        super(driver);
    }

    public MainFrame waitForSuccessMessage(){
        waitFor(messageSuccessMessage);
        waitForHide(messageSuccessMessage);
        return this;
    }

    public String getTextFromErrorMessage(){
        waitFor(messageErrorMessage);
        return getText(messageErrorMessage);
    }

    public MainFrame clickErrorMessage(){
        waitFor(messageErrorMessage);
        click(messageErrorMessage);
        waitForHide(messageErrorMessage);
        return this;
    }

    public String getIdFromMessage(){
        //String id = getText(messageSuccessSaving);
        //String text = getText(messageSuccessSaving);
        //String id = text.split("\\D+").toString();

        String text = getText(messageSuccessMessage);
        String id = TextHelper.getNumberFromString(text);
        System.out.println("Record id : " + id);
        return id;
    }

    //@Step("Loading")
    public MainFrame waitForHideLoading(){
        try {
            //waitForPresence(loader);
            waitFor(loader);
        } catch (TimeoutException e) {
            System.out.println("[WARNING] Loadmask not found");
        }
        waitForHide(loader);
        return this;
    }

}