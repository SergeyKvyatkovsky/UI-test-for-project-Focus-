package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 8.06.2017.
 */

@Test
@Title("Проверка редактирования сделок")
public class VerificationOfTransactionEditing  extends ITest {
    public void viewTransactionInformation() throws IOException, InterruptedException {
        System.out.println("Просмотр информации о сделке");
        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();
        tradeToolbar.pressButtonActiv();
        tradeToolbar.chooseEditDeal();
        //Подразделение
        tradeWindow.typeBranch("A");
        //Клиент
        tradeWindow.typeClient("A");

        //Контрагент
        tradeWindow.typeCounterparty("A");

        //Портфель
        tradeWindow.typePortfolio("18");

        //Тредер
        tradeWindow.typeTrader("abarsukov / abarsukov");
        //Прожимаем сохранить
        tradeToolbar.alertEditDealPressSave();
        //сравнение даты
        tradeToolbar.assertEditData();

    }
}
