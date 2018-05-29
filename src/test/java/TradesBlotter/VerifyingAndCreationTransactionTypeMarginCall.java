package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 26.05.2017.
 */
@Test(priority = 1)
@Title("Проверка создания новой сделки типа Margin Call")
public class VerifyingAndCreationTransactionTypeMarginCall extends ITest {
    public void verifyingAndCreationTransactionTypeMarginCall() throws IOException, InterruptedException{
        System.out.println("Проверка создания новой сделки типа Margin Call");



        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
        //Авторизация
       loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();

        //Прожимаем горячие клаваиши alt+t и попадаем в журнал сделок
        tradeToolbar.createNewTrade("Margin Call");

        // Как по тест кейсу прожимаем сэйв в пустые поля.
        tradeWindow.saveTrade();
        // Кнопка OK в алерете.
        tradeWindow.pressButtonOk();

        //Заполняем поля и выбираем некторые выпадающие списки.
        //Идентификатор
        tradeWindow.typeIdentifier("RED");
        //Выбираем сторону
        tradeWindow.enrollmentWriteOff();
        //Вводим подразделение
        tradeWindow.typeBranch("Atest");
        //Клиент
        tradeWindow.typeClient("ATC");
        //Контрагент
        tradeWindow.typeCounterparty("ATest Counterparty");
        //Портфель
        tradeWindow.typePortfolio("1865");
        //Тредер
        tradeWindow.typeTrader("abarsukov / abarsukov");
        //Инструмент
        tradeWindow.typeInstrument("0605CJCE5010");
        // Сумма
        tradeWindow.inputSumm();
        //Дата окончания
        tradeWindow.inputDateEnd();
        //Прожимаем кнопку сохранить.
        tradeWindow.saveTrade();
        tradeWindow.waitSeconds(10000);



    }
@Test(priority = 2)
@Title("Проверка новой сделки типа Margin Call в списке.")
public class CreatingTransactionAssertInTable extends ITest {
    public void creatingTransactionAssertInTableMarginCall() throws IOException, InterruptedException {
        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();

        System.out.println("Проверка создания новой сделки типа Margin Call");

        // Прожимаем кнопку "Активировать журнал"
        tradeToolbar.pressButtonActiv();

        //Ввод в поиск ID и проверка поиска сделки.
        tradeToolbar.inputIDInForm("RED","Margin Call");
        }
    }
}
