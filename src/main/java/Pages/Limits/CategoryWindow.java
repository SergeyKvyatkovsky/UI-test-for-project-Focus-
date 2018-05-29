package Pages.Limits;

import Core.IPage;
import Helpers.ParamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.Map;

import static Helpers.ParameterFiles.TIMERS;

public class CategoryWindow extends IPage{

    //Заголовок окна
    By spanHeaderText = By.xpath("//span[starts-with(@id, 'limitcategorywindow')]");

    //Наименование
    By inputCategoryName = By.xpath("//input[starts-with(@id, 'txtName-textfield')]");

    //Кнопка "Добавить общий фильтр"
    By buttonAddCommonFilter = By.xpath("//button[starts-with(@id, 'btnAddCommonFilter')]");

    //Кнопка "Добавить произвольный фильтр"
    By buttonAddCustomFilter = By.xpath("//button[starts-with(@id, 'btnAddCustomFilter')]");

    ////Добавить условие...
    By spanExprAddCondition = By.xpath("//span[starts-with(@id, 'exprAddCond')]");

    //////Комбобокс "Поле" (стрелка)
    By inputField = By.xpath("//input[starts-with(@id, 'field-combobox')]");
    By liAgreementType = By.xpath("//li[text()='Agreement Type']");

    //////Значение
    By inputDictValue = By.xpath("//input[starts-with(@id, 'dictValue')]");

    ////////Поле поиска
    By inputSearch = By.xpath("//input[starts-with(@id, 'fldSearch')]");
    By divDictValue = By.xpath("//div[text()='ALFA_DIRECT']");

    //Сохранить
    By buttonSave = By.xpath("//div[starts-with(@id, 'limitcategorywindow')]//button[starts-with(@id, 'btnSave-button')]");

    //Удалить
    By buttonDelete = By.xpath("//div[starts-with(@id, 'limitcategorywindow')]//button[starts-with(@id, 'btnDelete-button')]");

    //Редактировать
    By buttonEdit = By.xpath("//div[starts-with(@id, 'limitcategorywindow')]//button[starts-with(@id, 'btnEdit-button')]");

    //Выбрать
    By buttonSelect = By.xpath("//button[starts-with(@id, 'btnSelect-button')]");

    By buttonOkInCondition = By.xpath("//button[starts-with(@id, 'btnOk-button')]");

    By buttonOkInFilter = By.xpath("//div[starts-with(@id, 'filterwindow')]//button[starts-with(@id, 'btnSave-button')]");

    //
    By buttonYes = By.xpath("//button[starts-with(@id, 'yes-button')]");

    //Вкладка Пересчет
    By buttonRecalcTab = By.xpath("//button[starts-with(@id, 'tbRecalc-tab')]");

    //Поле таймера
    By inputRecalcTimer = By.xpath("//input[starts-with(@id, 'dctRecalcTimerId-lsdictionaryfield')]");

    //Значок удаления таймера
    By divDeleteTimer = By.xpath("//table[contains(@id, 'dctRecalcTimerId-lsdictionaryfield')]//div[contains(@class, 'clear-trigger')]");

    String timerName = "ATest Timer";
    By divTimer = By.xpath("//div[text()='"+timerName+"']");
    String parameterTimerName = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='edit']/name/text()");
    By divTestTimer = By.xpath("//div[text()='"+parameterTimerName+"']");
    //Таймеры
    By listDivTimers = By.xpath("//div[starts-with(@id, 'grData')]//td[contains(@class, 'cell-last')]/div");

    //Значок просмотра поля фильтра
    By divViewFilter = By.xpath("//table[starts-with(@id, 'triggerfield')]//div[contains(@class, 'x-form-search-trigger')]");

    //Значок удаления фильтра
    By divClearFilter = By.xpath("//table[starts-with(@id, 'triggerfield')]//div[contains(@class, 'x-form-clear-trigger')]");

    //Поле наименования фильтра
    By inputFilterName = By.xpath("//table[starts-with(@id, 'triggerfield')]//input[contains(@class, 'x-form-text')]");

    //Элементы выражения
    By listSpanExpessions = By.xpath("//*[starts-with(@id, 'filter')]//span[starts-with(@id, 'exprFunc')]/span");

    //Кнопка Закрыть фильтр
    By buttonClose = By.xpath("//*[starts-with(@id, 'filterwindow')]//button[starts-with(@id, 'btnClose-button')]");

    //Кнопка Отмена
    By buttonCancel = By.xpath("//button[starts-with(@id, 'btnClose-button')]");

    //Чекбокс Использовать расписание пересчета родительской категории
    By checkboxUseParentRecalcTimer = By.xpath("//input[starts-with(@id, 'chkUseParentRecalcTimer-checkboxfield')]");

    public CategoryWindow(WebDriver driver) {
        super(driver);
    }

    public CategoryWindow waitForHeaderText(){
        waitFor(spanHeaderText);
        return this;
    }

    public CategoryWindow typeCategoryName(String categoryName){
        waitFor(inputCategoryName);
        clear(inputCategoryName);
        sendKeys(inputCategoryName, categoryName);
        return this;
    }

    @Step("Сохранение категории")
    public CategoryWindow clickSaveButton(){
        waitFor(buttonSave);
        click(buttonSave);
        return this;
    }

    @Step("Редактирование категории")
    public CategoryWindow clickEditButton(){
        waitFor(buttonEdit);
        click(buttonEdit);
        waitFor(buttonSave);
        return this;
    }

    public CategoryWindow clickAddCustomFilterButton(){
        waitFor(buttonAddCustomFilter);
        click(buttonAddCustomFilter);
        return this;
    }

    public CategoryWindow clickExprAddCond(){
        waitFor(spanExprAddCondition);
        click(spanExprAddCondition);
        return this;
    }

    //
    public CategoryWindow clickFieldInput(){
        waitFor(inputField);
        click(inputField);
        return this;
    }

    public CategoryWindow selectAgreementType(){
        clickFieldInput();
        waitFor(liAgreementType);
        click(liAgreementType);
        waitFor(inputDictValue);
        return this;
    }

    //
    public CategoryWindow clickValueInput(){
        waitFor(inputDictValue);
        click(inputDictValue);
        return this;
    }

    public CategoryWindow selectAlfaDirect(){
        waitFor(inputSearch);
        //sendKeys(inputSearch, "Bloomberg");
        waitFor(divDictValue);
        click(divDictValue);
        click(buttonSelect);
        waitForHide(buttonSelect);
        return this;
    }

    public CategoryWindow clickOkInConditions(){
        click(buttonOkInCondition);
        waitForHide(buttonOkInCondition);
        return this;
    }

    public CategoryWindow clickOkInFilter(){
        click(buttonOkInFilter);
        waitForHide(buttonOkInFilter);
        return this;
    }

    public CategoryWindow deleteCategory(){
        waitFor(buttonDelete);
        click(buttonDelete);
        waitFor(buttonYes);
        click(buttonYes);
        return this;
    }

    //Нажатие на вкладку Пересчет
    public CategoryWindow clickRecalcTab(){
        waitFor(buttonRecalcTab);
        click(buttonRecalcTab);
        return this;
    }

    //Нажатие на поле таймера
    public CategoryWindow clickTimerField(){
        waitFor(inputRecalcTimer);
        click(inputRecalcTimer);
        return this;
    }

    @Step("Выбор таймера")
    public CategoryWindow selectTimer(String timerName){
        waitFor(listDivTimers);
//        Map<String, WebElement> timers = new HashMap<String, WebElement>();
//        WebElement timer;
//        for(int i=0; i<getSizeOfElements(listDivTimers); i++)
//        {
//            timer = getElement(listDivTimers, i);
//            timers.put(timer.getText(), timer);
//        }
//        timer = timers.get(timerName);
        doubleClick(getElementFromList(listDivTimers, timerName));
        waitForHide(listDivTimers);
        return this;
    }

    public CategoryWindow deleteTimer(){
        waitFor(divDeleteTimer);
        click(divDeleteTimer);
        return this;
    }

    public CategoryWindow viewFilter(){
        waitFor(divViewFilter);
        click(divViewFilter);
        return this;
    }

    public String getFilterName(){
        waitFor(inputFilterName);
        return getValue(inputFilterName);
    }

    @Step("Получение элементов выражения")
    public String getExpressionElementText(int index){
        waitFor(listSpanExpessions);
        return getElement(listSpanExpessions, index).getText();
    }

    public CategoryWindow closeViewFilter(){
        waitFor(buttonClose);
        click(buttonClose);
        waitForHide(buttonClose);
        return this;
    }

    public CategoryWindow clickCancel(){
        waitFor(buttonCancel);
        click(buttonCancel);
        waitFor(buttonYes);
        click(buttonYes);
        waitForHide(buttonYes);
        return this;
    }

    @Step("Удаление фильтра из категории")
    public CategoryWindow  clearFilter(){
        waitFor(divClearFilter);
        click(divClearFilter);
        waitForHide(divClearFilter);
        return this;
    }

    public CategoryWindow clickCheckboxUseParentRecalcTimer(){
        waitFor(checkboxUseParentRecalcTimer);
        click(checkboxUseParentRecalcTimer);
        return this;
    }
}
