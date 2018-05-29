package Limits;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class LimitTimer extends ITest{

    @Title("Добавление таймера к лимиту")
    @Test(priority = 1)
    public void addTimer() throws IOException, InterruptedException {
        navigateTo(url);
        //Авторизация
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Нажатие на вкладку Лимиты
        headerForm.clickLimitsTab();
        limitsTreeTabPanel.clickCategory();
        limitsToolbar.checkCategoryHeader("ATest Category");

        limitsTable.openLimitParent();
        mainFrame.waitForHideLoading();
        limitWindow.clickEdit();

        limitWindow.clickRecalcTab();
        limitWindow.clickCheckboxUseParentRecalcTimer();

        limitsCategoryWindow.clickTimerField();
        mainFrame.waitForHideLoading();
        limitsCategoryWindow.selectTimer("ATest Timer");

        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление таймера у лимита")
    @Test(priority = 2)
    public void deleteTimer(){
        limitsTable.openLimitParent();
        mainFrame.waitForHideLoading();
        limitWindow.clickEdit();

        limitWindow.clickRecalcTab();

        limitsCategoryWindow.deleteTimer();

        limitWindow.clickCheckboxUseParentRecalcTimer();
        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();
    }

}
