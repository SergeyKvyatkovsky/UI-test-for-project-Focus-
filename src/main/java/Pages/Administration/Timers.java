package Pages.Administration;

import Core.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class Timers extends IPage{

    //Новый таймер
    By buttonNewTimer = By.xpath("//button[starts-with(@id, 'btnNewTimer-button')]");

    //Наименование таймера
    By inputTimerName = By.xpath("//input[starts-with(@id, 'txtName-textfield')]");

    //Приоритет
    By inputPriority = By.xpath("//input[@name='priority']");

    //Комментарий таймера
    By textareaComment = By.xpath("//textarea[starts-with(@id, 'txtComment-textareafield')]");

    //Кнопка Добавить...
    By buttonAddSchedule = By.xpath("//button[starts-with(@id, 'btnAddSchedule-button')]");

    //Время
    By inputTime = By.xpath("//input[starts-with(@id, 'fldTime-datefield')]");

    //Кнопка Ок (Сохранить время)
    By buttonSaveTime = By.xpath("//*[starts-with(@id, 'toolbar')]//button[starts-with(@id, 'btnSave-button')]");

    //Кнопка Удалить (расписание)
    By buttonRemoveSchedule = By.xpath("//button[starts-with(@id, 'btnRemoveSchedule-button')]");

    //Кнопка Редактировать
    By buttonEdit = By.xpath("//*[starts-with(@id, 'adminTimersTab')]//button[starts-with(@id, 'btnEdit-button')]");

    //Кнопка Сохранить
    By buttonSave = By.xpath("//*[starts-with(@id, 'adminTimersTab')]//button[starts-with(@id, 'btnSave-button')]");

    //Список Время
    By listDivSchedule = By.xpath("//table[starts-with(@id, 'fieldcontainer')]//div[starts-with(@id, 'gridview')]//td/div");

    //Кнопка Удалить
    By buttonDelete = By.xpath("//*[starts-with(@id, 'adminTimersTab')]//button[starts-with(@id, 'btnDelete-button')]");

    //Кнопка Да
    By buttonYes = By.xpath("//div[starts-with(@id, 'messagebox')]//button[starts-with(@id, 'yes-button')]");

    //Кнопка ОК на окне "Ошибка удаления таймера"
    By buttonOk = By.xpath("//div[starts-with(@id, 'messagebox')]//button[starts-with(@id, 'ok-button')]");

    public Timers(WebDriver driver) {
        super(driver);
    }

    @Step("Новый таймер")
    public Timers createNewTimer(){
        waitFor(buttonNewTimer);
        click(buttonNewTimer);
        return this;
    }

    public Timers typeName(String timerName){
        waitFor(inputTimerName);
        clear(inputTimerName);
        sendKeys(inputTimerName, timerName);
        return this;
    }

    public Timers typePriority(String text){
        waitFor(inputPriority);
        clear(inputPriority);
        sendKeys(inputPriority, text);
        return this;
    }

    public Timers typeComment(String text){
        waitFor(textareaComment);
        clear(textareaComment);
        sendKeys(textareaComment, text);
        return this;
    }

    @Step("Добавление времени в расписание")
    public Timers addTimeToShedule(String time){
        waitFor(buttonAddSchedule);
        click(buttonAddSchedule);
        waitFor(inputTime);
        sendKeys(inputTime, time);
        click(buttonSaveTime);
        waitForHide(inputTime);
        return this;
    }

    @Step("Сохранение таймера")
    public Timers saveTimer(){
        waitFor(buttonSave);
        click(buttonSave);
        return this;
    }

    @Step("Редактирование таймера")
    public Timers editTimer(){
        waitFor(buttonEdit);
        click(buttonEdit);
        waitFor(buttonSave);
        return this;
    }

    @Step("Удаление времени из расписания")
    public Timers deleteTimeFromSchedule(){
        waitFor(listDivSchedule);
        int count = getSizeOfElements(listDivSchedule);
        for (int i=0; i<count; i++)
        {
            getElement(listDivSchedule, 0).click();
            click(buttonRemoveSchedule);
        }
        return this;
    }

    public String getTimerName(){
        return getValue(inputTimerName);
    }

    public String getPriority(){
        return getValue(inputPriority);
    }

    public String getComment(){
        return getValue(textareaComment);
    }

    @Step("Удаление таймера")
    public Timers deleteTimer(){
        waitFor(buttonDelete);
        click(buttonDelete);
        waitFor(buttonYes);
        click(buttonYes);
        waitForHide(buttonYes);
        return this;
    }

    public Timers clickOk(){
        waitFor(buttonOk);
        click(buttonOk);
        waitFor(buttonDelete);
        return this;
    }

}
