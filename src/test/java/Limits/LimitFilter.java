package Limits;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class LimitFilter extends ITest{

    @Title("Добавление фильтров для лимита")
    @Test(priority = 1)
    public void addFilters() throws IOException, InterruptedException {
        navigateTo(url);
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Нажатие на вкладку Лимиты
        headerForm.clickLimitsTab();
        limitsTreeTabPanel.clickCategory();
        limitsToolbar.checkCategoryHeader("ATest Category");

        limitsTable.openLimitParent();
        mainFrame.waitForHideLoading();
        limitWindow.clickEdit();

        limitWindow.clickAddCommonFilter();
        limitWindow.selectFilter();

        //Нажатие на "Добавить произвольный"
        limitsCategoryWindow.clickAddCustomFilterButton();

        //Добавить условие
        limitsCategoryWindow.clickExprAddCond();

        limitsCategoryWindow.selectAgreementType();

        limitsCategoryWindow.clickValueInput();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.selectAlfaDirect();

        limitsCategoryWindow.clickOkInConditions();
        limitsCategoryWindow.clickOkInFilter();

        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление фильтров лимита")
    @Test(priority = 2)
    public void deleteFilters(){
        limitsTable.openLimitParent();
        mainFrame.waitForHideLoading();
        limitWindow.clickEdit();
        limitWindow.clearFilterField();
        limitWindow.clearFilterField();
        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();
    }

}
