package Limits;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

import static Helpers.ParamReader.getParameterByXpath;
import static Helpers.ParameterFiles.LIMITS;

public class Limit extends ITest {

    @Title("Создание лимита")
    @Test(priority = 1)
    public void createLimit() throws IOException, InterruptedException {
        String limitName = getParameterByXpath(LIMITS, "//limit[@name='new']/name/text()");
        String limitValue = getParameterByXpath(LIMITS, "//limit[@name='new']/value/text()");
        String limitDate = getParameterByXpath(LIMITS, "//limit[@name='new']/endDate/text()");

        navigateTo(url);

        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Нажатие на вкладку Лимиты
        headerForm.clickLimitsTab();
        limitsTreeTabPanel.clickCategory();
        limitsToolbar.checkCategoryHeader("ATest Category");

        limitsToolbar.createNewLimit();
        limitsToolbar.selectOPA();
        mainFrame.waitForHideLoading();

        limitWindow.typeName(limitName);
        limitWindow.typeBoundaryValue(limitValue);
        limitWindow.typeEndDate(limitDate);

        limitWindow.clickAddCommonFilter();
        limitWindow.selectFilter();

        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Изменение лимита")
    @Test(priority = 2)
    public void editLimit() {
        String limitName = getParameterByXpath(LIMITS, "//limit[@name='edit']/name/text()");
        String limitValue = getParameterByXpath(LIMITS, "//limit[@name='edit']/value/text()");

        limitsTable.openLimit();
        mainFrame.waitForHideLoading();
        limitWindow.clickEdit();
        limitWindow.typeName(limitName);
        limitWindow.typeBoundaryValue(limitValue);
        limitWindow.clearFilterField();
        limitWindow.selectBoundaryCondition();

        limitWindow.clickParametersTab();
        limitWindow.clickCheckboxIncludeReverseRepo();
        limitWindow.clickCheckboxIncludeAI();

        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление лимита")
    @Test(priority = 3)
    public void deleteLimit() {
        limitsTable.openEditedLimit();
        mainFrame.waitForHideLoading();
        limitWindow.deleteLimit();
        mainFrame.waitForSuccessMessage();
    }
}