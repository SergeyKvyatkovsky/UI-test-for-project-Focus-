package Data;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 12.05.2017.
 */
@Title("Поиск через форму данные")
@Test
public class FindForm extends ITest {
        public void findForm() throws IOException, InterruptedException {

            System.out.println("Проверка формы для поиска в закладке данные");
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            // Login and Password
            loginPage.typeUsername("s.kviatkovsky");
            loginPage.typePassword("etpoN7VV");
            loginPage.submit();

            // Переход по закладке Данные
            headerForm.clickDataTab();

            // Выбор таблицы Books
            dataPage.chooseBookInTable();

            // Ввод в форму поиска и проверка.В параметрах строка.
            dataToolbar.findDataMenu("1184"); // Завести в системе данные и назвать ATest

            // Выбор таблицы Counterparties
            dataPage.clickCounterparties();

            // Ввод в форму поиска и проверка.В параметрах строка.
            dataToolbar.findDataMenu("marie_test_branch_pin_le");
        }
}
