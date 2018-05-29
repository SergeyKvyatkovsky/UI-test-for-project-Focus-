package Data;

import Core.ITest;
import Helpers.ParamReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

@Title("Check data")
@Test
public class ViewData extends ITest{

    public void checkCounterpartiesData() throws IOException, InterruptedException {
        navigateTo(url);

        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        headerForm.clickDataTab();
        dataToolbar.waitForContentTab();
        //dataPage.clickCounterparties();
        dataMenuGridPanel.clickCounterparties();

        mainFrame.waitForHideLoading();


//        if (!dataPage.checkColumnNames(ParamReader.getListWithTableColumnNames("Counterparties"))) {
//            Assert.fail("Columns is not valid");
//        }
        if (!dataTable.checkColumnNames(ParamReader.getListWithTableColumnNames("Counterparties"))) {
            Assert.fail("Columns is not valid");
        }

    }

}
