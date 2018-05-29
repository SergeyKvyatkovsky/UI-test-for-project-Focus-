package Pages.Limits;

import Core.IPage;
import Helpers.ParamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static Helpers.ParameterFiles.COMMON_FILTER;
import static Helpers.ParameterFiles.COMMON_FILTER_GROUPS;

public class LimitWindow extends IPage{

    //Наименование
    By inputName = By.xpath("//input[starts-with(@id, 'txtName-textfield')]");

    //Граничное значение
    By inputBoundaryValue = By.xpath("//input[starts-with(@id, 'numOwnValue-lsnumberfield')]");

    //Дата по
    By inputEndDate = By.xpath("//input[starts-with(@id, 'datEndDate-lsdateclear')]");

    //Добавить общий фильтр
    By buttonAddCommonFilter = By.xpath("//button[starts-with(@id, 'btnAddCommonFilter-button')]");

    //Группа фильтров ATest
    By divGroup = By.xpath("//div[starts-with(@id, 'treeselectionwindow')]//div[text()='ATest Group']");

    //фильтр ATest
    By divFilter = By.xpath("//div[starts-with(@id, 'treeselectionwindow')]//div[text()='ATest Filter']");

    //Группа фильтров из тестов
    String groupName = ParamReader.getParameterByXpath(COMMON_FILTER_GROUPS, "//group[@name='new']/name/text()");
    By divTestGroup = By.xpath("//div[starts-with(@id, 'treeselectionwindow')]//div[text()='"+ groupName +"']");

    //Фильтры из тестов
    String filterName = ParamReader.getParameterByXpath(COMMON_FILTER, "//filter[@name='new']/name/text()");
    By divTestFilter = By.xpath("//div[starts-with(@id, 'treeselectionwindow')]//div[text()='"+filterName+"']");

    //Кнопка Выбрать
    By buttonSelect = By.xpath("//button[starts-with(@id, 'btnSelect-button')]");

    //Кнопка Сохранить
    By buttonSave = By.xpath("//button[starts-with(@id, 'btnSave-button')]");

    //Кнопка Редактировать
    By buttonEdit = By.xpath("//button[starts-with(@id, 'btnEdit-button')]");

    //Значок очистки поля фильтра
    By divClearFilterField = By.xpath("//table[starts-with(@id, 'triggerfield')]//div[contains(@class, 'clear-trigger')][1]");

    //Условие ограничения
    By inputBoundaryCondition = By.xpath("//input[starts-with(@id, 'cmbCondition-combobox')]");

    //Значение условия ограничения (=)
    By liBoundaryOption = By.xpath("//li[starts-with(@class, 'x-boundlist-item') and text()='=']");

    //Вкладка Параметры
    By buttonParametersTab = By.xpath("//button[starts-with(@id, 'tbParameters-tab')]");

    //Чекбокс "Учитывать обратное репо"
    By checkboxIncludeReverseRepo = By.xpath("//input[starts-with(@id, 'chkIncludeReverseRepo-checkboxfield')]");

    //Чекбокс "Учитывать НКД"
    By checkboxIncludeAI = By.xpath("//input[starts-with(@id, 'chkIncludeAI-checkboxfield')]");

    //Кнопка Удалить
    By buttonDelete = By.xpath("//button[starts-with(@id, 'btnDelete-button')]");

    //Кнопка "Да" в диалоговом окне удаления лимита
    By buttonYes = By.xpath("//button[starts-with(@id, 'yes-button')]");

    //Чекбокс "использовать расписание пересчета категории"
    By checkboxUseParentRecalcTimer = By.xpath("//input[starts-with(@id, 'chkUseParentRecalcTimer-checkboxfield')]");

    //Вкладка Пересчет
    By buttonRecalcTab = By.xpath("//button[starts-with(@id, 'tbRecalc-tab')]");

    public LimitWindow(WebDriver driver) {
        super(driver);
    }

    //Ввод наименования
    public LimitWindow typeName(String text){
        waitFor(inputName);
        clear(inputName);
        sendKeys(inputName, text);
        return this;
    }

    //Дополнить наименование
    public LimitWindow addTextToName(String text){
        waitFor(inputName);
        sendKeys(inputName, text);
        return this;
    }

    //Ввод граничного значения
    public LimitWindow typeBoundaryValue(String value){
        waitFor(inputBoundaryValue);
        clear(inputBoundaryValue);
        sendKeys(inputBoundaryValue, value);
        return this;
    }


    //Ввод даты конца действия лимита
    public LimitWindow typeEndDate(String date){
        waitFor(inputEndDate);
        sendKeys(inputEndDate, date);
        return this;
    }

    //Нажатие на кнопку "Добавить общий..."
    public LimitWindow clickAddCommonFilter(){
        waitFor(buttonAddCommonFilter);
        click(buttonAddCommonFilter);
        return this;
    }

    @Step("Выбор фильтра")
    public LimitWindow selectFilter(){
        waitFor(divGroup);
        doubleClick(divGroup);
        waitFor(divFilter);
        click(divFilter);
        waitFor(buttonSelect);
        click(buttonSelect);
        waitForHide(buttonSelect);
        return this;
    }

    //Метод такой же как и selectFilter, но имена группы и фильтра берутся из параметров
    @Step("Выбор общего фильтра")
    public LimitWindow selectCommonFilter(){
        waitFor(divTestGroup);
        //doubleClick(divTestGroup);
        waitFor(divTestFilter);
        click(divTestFilter);
        waitFor(buttonSelect);
        click(buttonSelect);
        waitForHide(buttonSelect);
        return this;
    }

    @Step("Сохранение лимита")
    public LimitWindow saveLimit(){
        waitFor(buttonSave);
        click(buttonSave);
        return this;
    }

    //Нажатие на кнопку Редактировать
    public LimitWindow clickEdit(){
        waitFor(buttonEdit);
        click(buttonEdit);
        waitFor(buttonSave);
        return this;
    }

    //Очистить поле фильтра
    public LimitWindow clearFilterField(){
        waitFor(divClearFilterField);
        click(divClearFilterField);
        //Ожидание исчезновения значка очистки
        //waitForHide(divClearFilterField);
        return this;
    }

    //Выбор условия ограничения
    public LimitWindow selectBoundaryCondition(){
        waitFor(inputBoundaryCondition);
        click(inputBoundaryCondition);
        waitFor(liBoundaryOption);
        click(liBoundaryOption);
        waitForHide(liBoundaryOption);
        return this;
    }

    //Переход на вкладку Параметры
    public LimitWindow clickParametersTab(){
        waitFor(buttonParametersTab);
        click(buttonParametersTab);
        return this;
    }

    //Нажатие на чекбокс "Учитывать обратное репо"
    public LimitWindow clickCheckboxIncludeReverseRepo(){
        waitFor(checkboxIncludeReverseRepo);
        click(checkboxIncludeReverseRepo);
        return this;
    }

    //Нажатие на чекбокс "Учитывать НКД"
    public LimitWindow clickCheckboxIncludeAI(){
        waitFor(checkboxIncludeAI);
        click(checkboxIncludeAI);
        return this;
    }

    //Удаление лимита
    @Step("Удаление лимита")
    public LimitWindow deleteLimit(){
        waitFor(buttonDelete);
        click(buttonDelete);
        waitFor(buttonYes);
        click(buttonYes);
        return this;
    }

    public LimitWindow clickYes(){
        waitFor(buttonYes);
        click(buttonYes);
        return this;
    }

    public LimitWindow clickCheckboxUseParentRecalcTimer(){
        waitFor(checkboxUseParentRecalcTimer);
        click(checkboxUseParentRecalcTimer);
        return this;
    }

    public LimitWindow clickRecalcTab(){
        waitFor(buttonRecalcTab);
        click(buttonRecalcTab);
        return this;
    }

}
