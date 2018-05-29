package Limits;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

import static Helpers.ParamReader.getParameterByXpath;
import static Helpers.ParameterFiles.LIMITS;

public class Clone extends ITest{

    @Title("Клонирование лимита")
    @Test
    public void cloneLimit() throws IOException, InterruptedException {
        String text = getParameterByXpath(LIMITS, "//limit[@name='child']/name/text()");

        navigateTo(url);
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Нажатие на вкладку Лимиты
        headerForm.clickLimitsTab();
        limitsTreeTabPanel.clickCategory();
        limitsToolbar.checkCategoryHeader("ATest Category");

        limitsTable.clickLimitParent();
        limitsToolbar.createNewLimit();
        limitsToolbar.clickClone();
        mainFrame.waitForHideLoading();

        //limitWindow.clickEdit();
        limitWindow.addTextToName(text);
        limitWindow.saveLimit();
        mainFrame.waitForSuccessMessage();

        limitsTable.deleteChildLimit();
        limitWindow.clickYes();
        mainFrame.waitForSuccessMessage();


    }

}
