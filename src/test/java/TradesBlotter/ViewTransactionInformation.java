package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Sergey on 08.06.2017.
 */

@Test
@Title("Просмотр информации о сделке")
public class ViewTransactionInformation extends ITest {
    public void viewTransactionInformation() throws IOException, InterruptedException {
            System.out.println("Просмотр информации о сделке");
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            //Авторизация
            loginPage.authorization("s.kviatkovsky", "etpoN7VV");
            mainFrame.waitForHideLoading();
            headerForm.creatAndCkickTransactionLog();
            tradeToolbar.pressButtonActiv();
            //Сохраняем первую строчку таблицы в массив для сравнения и наружу выкидываем
            List<String> listform = tradeToolbar.сheckingАieldsViewTransactionLog();
            //Ищем значения в массиве что выкинули выше.
            tradeToolbar.сheckingTransactionLogAutorization(listform);



        }

}
