package Limits;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class CategoryFilter extends ITest{

    @Title("Добавление фильтров для категории")
    @Test(priority = 1)
    public void addFilters() throws IOException, InterruptedException {
        navigateTo(url);
        //Авторизация
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Нажатие на вкладку Лимиты
        headerForm.clickLimitsTab();
        limitsTreeTabPanel.clickCategory();
        limitsToolbar.checkCategoryHeader("ATest Category");

        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.clickEditButton();

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

        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление фильтров у категории")
    @Test(priority = 2)
    public void deleteFilters(){
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.clickEditButton();
        limitWindow.clearFilterField();
        limitWindow.clearFilterField();
        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
    }


}
