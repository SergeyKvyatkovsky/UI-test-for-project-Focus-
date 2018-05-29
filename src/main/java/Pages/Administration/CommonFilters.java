package Pages.Administration;

import Core.IPage;
import Helpers.ParamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static Helpers.ParameterFiles.COMMON_FILTER;
import static Helpers.ParameterFiles.COMMON_FILTER_GROUPS;

public class CommonFilters extends IPage{

    //Новая группа
    By buttonNewGroup = By.xpath("//button[starts-with(@id, 'btnNewGroup-button')]");

    //Новый фильтр
    By buttonNewFilter = By.xpath("//button[starts-with(@id, 'btnNewFilter-button')]");

    //Поле ввода "Наименование"
    By inputName = By.xpath("//input[starts-with(@id, 'name-textfield')]");

    //Кнопка Сохранить
    By buttonSave = By.xpath("//button[starts-with(@id, 'btnSave-button')]");

    //Кнопка Удалить
    By buttonDelete = By.xpath("//button[starts-with(@id, 'btnDelete-button')]");

    //Кнопка Редактировать
    By buttonEdit = By.xpath("//button[starts-with(@id, 'btnEdit-button')]");

    //Добавить условие...
    By spanExprAddCond = By.xpath("//span[starts-with(@id, 'exprAddCond')]");

    //Конструктор условий -> Поле
    By inputField = By.xpath("//input[starts-with(@id, 'field-combobox')]");
    By liBranch = By.xpath("//li[text()='Branch']");
    By liInstrumentIssuer = By.xpath("//li[text()='InstrumentIssuer']");

    //Конструктор условий -> Selection -> Условие
    By inputCondition = By.xpath("//input[starts-with(@id, 'condition-combobox')]");
    By liNotEqual = By.xpath("//li[text()='≠']");

    //Список значений поля Условие
    //By optionsBound = By.xpath("//div[starts-with(@id, 'boundlist')]/ul/li");
    By optionsBound = By.xpath("//div[starts-with(@id, 'boundlist')]/ul/li[contains(@class, 'boundlist-item')]");


    By inputValue =  By.xpath("//input[starts-with(@id, 'dictValue-lsdictionaryfield')]");

    //Конструктор условий -> Selection -> Поле поиска
    By inputSearch = By.xpath("//input[starts-with(@id, 'fldSearch-lssearchfield')]");

    String branchName = ParamReader.getParameterByXpath(COMMON_FILTER, "//filter[@name='new']/branch/text()");
    By divBranch = By.xpath("//div[text()='"+branchName+"']");



    //Конструктор условий -> Selection -> Выбрать
    By buttonSelect = By.xpath("//button[starts-with(@id, 'btnSelect-button')]");

    //Конструктор условий -> Ok
    By buttonOk = By.xpath("//button[starts-with(@id, 'btnOk-button')]");

    //Поле выражения
    By spanExpression = By.xpath("//span[starts-with(@id, 'exprFunc')]");

    //Контекстное меню -> Изменить...
    By spanExprMenuEdit = By.xpath("//span[starts-with(@id, 'exprMenuEdit-menuitem')]");

    //Кнопка Да
    By buttonYes = By.xpath("//button[starts-with(@id, 'yes-button')]");

    String filterGroupName = ParamReader.getParameterByXpath(COMMON_FILTER_GROUPS, "//group[@name='new']/name/text()");
    By divGroupCell = By.xpath("//div[starts-with(@id, 'filtersTree-treepanel')]//div[text()='"+ filterGroupName +"']");
    String filterName = ParamReader.getParameterByXpath(COMMON_FILTER, "//filter[@name='edit']/name/text()");
    By divFilterCell = By.xpath("//div[starts-with(@id, 'filtersTree-treepanel')]//div[text()='"+ filterName +"']");

    public CommonFilters(WebDriver driver) {
        super(driver);
    }

    @Step("Новая группа")
    public CommonFilters newGroup(){
        waitFor(buttonNewGroup);
        click(buttonNewGroup);
        return this;
    }

    @Step("Новый фильтр")
    public CommonFilters newFilter(){
        waitFor(buttonNewFilter);
        click(buttonNewFilter);
        return this;
    }

    public CommonFilters typeName(String text){
        waitForPresence(inputName);
        moveTo(inputName);
        waitFor(inputName);
        clear(inputName);
        sendKeys(inputName, text);
        return this;
    }

    @Step("Сохранение")
    public CommonFilters save(){
        waitFor(buttonSave);
        click(buttonSave);
        return this;
    }

    @Step("Редактирование")
    public CommonFilters edit(){
        waitFor(buttonEdit);
        click(buttonEdit);
        return this;
    }

    public CommonFilters clickAddCondition(){
        waitFor(spanExprAddCond);
        click(spanExprAddCond);
        return this;
    }

    public CommonFilters selectField(String fieldName){
        By option = null;

        switch (fieldName) {
            case "Branch":
                option = liBranch;
                break;
            case "InstrumentIssuer":
                option = liInstrumentIssuer;
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
        waitFor(inputField);
        click(inputField);
//        waitFor(liBranch);
//        click(liBranch);
        moveTo(option);
        waitFor(option);
        click(option);
        return this;
    }

    public CommonFilters selectFieldIssuer(){
        waitFor(inputField);
        click(inputField);
        moveTo(liInstrumentIssuer);
        waitFor(liInstrumentIssuer);
        click(liInstrumentIssuer);
        return this;
    }

    public CommonFilters clickValue(){
        waitFor(inputValue);
        click(inputValue);
        return this;
    }

    public CommonFilters typeDictValueInSearch(String value){
        waitFor(inputSearch);
        sendKeys(inputSearch, value);
        return this;
    }

    public CommonFilters selectValueFromBranchDict(){
        waitFor(divBranch);
        click(divBranch);
        waitFor(buttonSelect);
        click(buttonSelect);
        return this;
    }

    public CommonFilters clickOk(){
        waitFor(buttonOk);
        click(buttonOk);
        return this;
    }

    public CommonFilters clickExpression(){
        waitFor(spanExpression);
        click(spanExpression);
        return this;
    }

    public CommonFilters clickEditOnContextMenu(){
        waitFor(spanExprMenuEdit);
        click(spanExprMenuEdit);
        return this;
    }

    //Метод выбирает элемент из списка Условие. Нумерация с 0. Некорректно возвращал элементы
//    public CommonFilters selectCondition(int optionNumber){
//        waitFor(inputCondition);
//        click(inputCondition);
//        //waitFor(optionsBound);
//        waitSeconds(5000);
//        //getElement(optionsBound, optionNumber);
//        System.out.println("Size of bound options ="+getSizeOfElements(optionsBound));
//        return this;
//    }

    public CommonFilters selectCondition(){
        waitFor(inputCondition);
        click(inputCondition);
        waitFor(liNotEqual);
        getSizeOfElements(liNotEqual);
        click(liNotEqual);
        return this;
    }

    @Step("Удаление")
    public CommonFilters delete(){
        waitFor(buttonDelete);
        click(buttonDelete);
        waitFor(buttonYes);
        click(buttonYes);
        return this;
    }

    public CommonFilters selectFilterGroup(){
        waitFor(divGroupCell);
        click(divGroupCell);
        return this;
    }

    public boolean isDeleteButtonDisabled(){
        waitFor(buttonDelete);
        return isAttributeExist(buttonDelete, "disabled");
    }

    public CommonFilters selectFilter(){
        waitFor(divFilterCell);
        click(divFilterCell);
        return this;
    }

}
