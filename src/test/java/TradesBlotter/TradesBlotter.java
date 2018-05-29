package TradesBlotter;

import Core.ITest;
import Helpers.DecodeHelper;
import Helpers.SortHelper;
import Helpers.UserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class TradesBlotter extends ITest{

    @Title("Создание журнала сделок")
    @Test(priority = 1)
    public void createTradesBlotter() throws IOException, InterruptedException {
        navigateTo(url);
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        //    headerForm.addTradesBlotter();
        //headerForm.closeTab();
    }

    @Test(priority = 2)
    public void sort() {
        headerForm.addTradesBlotter();
        tradeParametersPanel.startStopBlotter();
        mainFrame.waitForHideLoading();
        tradeGridPanel.sortColumn();
        mainFrame.waitForHideLoading();
        Assert.assertEquals(SortHelper.sortListDesc(tradeGridPanel.getTextFromColumns()), tradeGridPanel.getTextFromColumns());

        tradeGridPanel.sortColumn();
        mainFrame.waitForHideLoading();
        Assert.assertEquals(SortHelper.sortListAsc(tradeGridPanel.getTextFromColumns()), tradeGridPanel.getTextFromColumns());
    }

}
