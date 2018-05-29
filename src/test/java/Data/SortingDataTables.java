package Data;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 17.05.2017.
 */
@Title("Сортировка формы таблица")
@Test

public class SortingDataTables extends ITest {

    public void sortingData() throws IOException, InterruptedException {

        System.out.println("Проверка соритировке в меню данные");
        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/console/");

        // Вход в каабинет.
        loginPage.typeUsername("s.kviatkovsky");
        loginPage.typePassword("etpoN7VV");
        loginPage.submit();

        // Переход по закладке Данные
        headerForm.clickDataTab();

        // Создание Масссива таблицы и проверка значений.
        dataPage.sortAseertion();

        // Нажатие на кнопку сортировки таблиц.
        dataPage.sort();

        // Создание Масссива таблицы и проверка значени. Проверка после сортировки.
        dataPage.sortAseertion();


    }
}