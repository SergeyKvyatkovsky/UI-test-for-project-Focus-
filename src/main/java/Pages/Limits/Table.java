package Pages.Limits;

import Core.IPage;
import Helpers.ParamReader;
import Helpers.ParameterFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static Helpers.ParamReader.getParameterByXpath;
import static Helpers.ParameterFiles.LIMITS;

public class Table extends IPage{

    String limitNameNew = getParameterByXpath(ParameterFiles.LIMITS, "//limit[@name='new']/name/text()");
    String limitNameEdit = getParameterByXpath(ParameterFiles.LIMITS, "//limit[@name='edit']/name/text()");
    String limitNameChild = getParameterByXpath(LIMITS, "//limit[@name='child']/name/text()");

    By divLimitNew = By.xpath("//div[text()='"+limitNameNew+"']");
    By divLimitEdit = By.xpath("//div[text()='"+limitNameEdit+"']");
    By divLimitChild = By.xpath("//div[text()='"+limitNameChild+"']");

    By divLimitParent = By.xpath("//div[text()='ATest BAL Limit']");

    //Пункт "Удалить лимит"
    // /html/body/div[20]/div/div[2]/div[2]/div[3]/a/span
    By spanDeleteLimit = By.xpath("//span[text()='Delete Limit' or text()='Удалить лимит']");

    public Table(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие нового лимита")
    public Table openLimit(){
        waitFor(divLimitNew);
        doubleClick(divLimitNew);
        return this;
    }

    @Step("Открытие редактированного лимита")
    public Table openEditedLimit(){
        waitFor(divLimitEdit);
        doubleClick(divLimitEdit);
        return this;
    }

    @Step("Выбор лимита-шаблона")
    public Table clickLimitParent(){
        waitFor(divLimitParent);
        click(divLimitParent);
        return this;
    }

    @Step("Открытие лимита")
    public Table openLimitParent(){
        waitFor(divLimitParent);
        doubleClick(divLimitParent);
        return this;
    }

    @Step("Удаление дочернего лимита")
    public Table deleteChildLimit(){
        waitFor(divLimitChild);
        rightClick(divLimitChild);
        waitFor(spanDeleteLimit);
        click(spanDeleteLimit);
        return this;
    }

}
