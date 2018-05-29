package Administration;

import Core.ITest;
import Helpers.ParamReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.ArrayList;

import static Helpers.ParameterFiles.TIMERS;

public class Timer extends ITest{

    @Title("Создание таймера")
    @Test(priority = 1)
    public void createTimer() throws IOException, InterruptedException {
        String timerName = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='new']/name/text()");
        String timerPriority = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='new']/priority/text()");
        String timerComment = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='new']/comment/text()");
        ArrayList<String> timeList;
        timeList = ParamReader.getParameterListByXpath(TIMERS, "//timer[@name='new']/schedule/time");
        int timerScheduleCount = timeList.size();

        navigateTo(url);
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();
        headerForm.clickAdminTab();
        administrationGridPanel.selectTimers();
        administrationTimers.createNewTimer();
        administrationTimers.typeName(timerName);
        administrationTimers.typePriority(timerPriority);
        administrationTimers.typeComment(timerComment);
        for (int i=0; i<timerScheduleCount; i++)
            administrationTimers.addTimeToShedule(timeList.get(i));
        administrationTimers.saveTimer();
        mainFrame.waitForSuccessMessage();

        //Редактирование
        timerName = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='edit']/name/text()");
        timerPriority = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='edit']/priority/text()");
        timerComment = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='edit']/comment/text()");
        timeList.clear();
        timeList = ParamReader.getParameterListByXpath(TIMERS, "//timer[@name='edit']/schedule/time");
        timerScheduleCount = timeList.size();

        administrationTimers.editTimer();
        administrationTimers.typeName(timerName);
        administrationTimers.typePriority(timerPriority);
        administrationTimers.typeComment(timerComment);
        administrationTimers.deleteTimeFromSchedule();
        for (int i=0; i<timerScheduleCount; i++)
            administrationTimers.addTimeToShedule(timeList.get(i));
        administrationTimers.saveTimer();
        mainFrame.waitForSuccessMessage();
        Assert.assertEquals(administrationTimers.getTimerName(), timerName);
        Assert.assertEquals(administrationTimers.getPriority(), timerPriority);
        Assert.assertEquals(administrationTimers.getComment(), timerComment);
    }

    @Title("Добавление таймера в категорию")
    @Test(priority = 2)
    public void addTimerToCategory(){
        String timerName = ParamReader.getParameterByXpath(TIMERS, "//timer[@name='edit']/name/text()");

        headerForm.clickLimitsTab();
        limitsTreeTabPanel.doubleClickCatagory();
        limitsTreeTabPanel.clickSubcategory();
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();
        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.clickRecalcTab();
        limitsCategoryWindow.clickCheckboxUseParentRecalcTimer();
        limitsCategoryWindow.clickTimerField();
        limitsCategoryWindow.selectTimer(timerName);
        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Удаление таймера")
    @Test(priority = 3)
    public void deleteTimer(){
        headerForm.clickAdminTab();
        administrationTimers.deleteTimer();
        administrationTimers.clickOk();
        headerForm.clickLimitsTab();
        limitsToolbar.viewCategory();
        mainFrame.waitForHideLoading();
        limitsCategoryWindow.clickEditButton();
        limitsCategoryWindow.clickRecalcTab();
        limitsCategoryWindow.deleteTimer();
        limitsCategoryWindow.clickCheckboxUseParentRecalcTimer();
        limitsCategoryWindow.clickSaveButton();
        mainFrame.waitForSuccessMessage();
        headerForm.clickAdminTab();
        administrationTimers.deleteTimer();
        mainFrame.waitForSuccessMessage();
    }

}
