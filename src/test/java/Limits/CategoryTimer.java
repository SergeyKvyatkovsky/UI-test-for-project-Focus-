package Limits;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class CategoryTimer extends ITest{

    @Title("Добавление таймера к категории")
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

        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.clickRecalcTab();
        limitsCategoryWindow.clickTimerField();
        mainFrame.waitForHideLoading();

        limitsCategoryWindow.selectTimer("ATest Timer");
        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление таймера у категории")
    @Test(priority = 2)
    public void deleteTimer(){
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();
        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.clickRecalcTab();
        limitsCategoryWindow.deleteTimer();
        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
    }

}
