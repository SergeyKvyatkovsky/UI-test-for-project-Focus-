package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 10.06.2017.
 */
@Test
@Title("Проверка удаления сделок")

public class DeletingDealChecking extends ITest{
    public void viewTransactionInformation() throws IOException, InterruptedException {
        System.out.println("Просмотр информации о сделке");
        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();
        tradeToolbar.pressButtonActiv();
        //Забираем АЙди до удаления
        String receivID = tradeToolbar.receivingID();
        //Жмём ПКМ
        tradeToolbar.chooseEditDeal();
        //Жмём удалить и да.
        tradeToolbar.alertEditDealPressDelet();
        //Сравниваем айди что брали вначале у первой строки с настоящей, тест проходит успешно если они не совпали.
        tradeToolbar.assertDeleteDeals(receivID);

    }
}
