package Data;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

public class Pagination extends ITest{

    @Title("Проверка пагинации")
    @Test
    public void navigatePages() throws IOException, InterruptedException {

        navigateTo(url);
        //Авторизация
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Открытие вкладки Данные
        headerForm.clickDataTab();
        dataToolbar.waitForContentTab();

        //Открытие таблицы Counterparties
        dataPage.clickCounterparties();
        mainFrame.waitForHideLoading();

        System.out.println("Page = " + dataTable.getNumberPage());
    }

}
