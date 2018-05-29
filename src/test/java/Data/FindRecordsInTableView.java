package Data;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 22.05.2017.
 */
@Test
@Title("Поиск записей в табличном представлении")
public class FindRecordsInTableView extends ITest {
    public void findRecordsInTableView() throws IOException, InterruptedException{

        System.out.println("Начало проверки поиска записей в табличного представлении.");

        // Переход на страницу
        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");

        // ввод логина и пароля
        loginPage.typeUsername("s.kviatkovsky");
        loginPage.typePassword("etpoN7VV");
        loginPage.submit();

        // Переход по вкладке Данные.
        headerForm.clickDataTab();

        // Выбор таблицы "book"
        dataPage.chooseBookInTable();

        //Создаём массив1 , прожимаем кнопку , создаём массив2 и сравниваем.
        dataTable.sizeHeaderRows();




    }

}
