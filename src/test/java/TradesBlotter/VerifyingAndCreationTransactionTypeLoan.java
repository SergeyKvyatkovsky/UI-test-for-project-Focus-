package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

import static Core.ITest.headerForm;
import static Core.ITest.mainFrame;
import static Core.ITest.tradeToolbar;

/**
 * Created by Sergey on 02.06.2017.
 */
public class VerifyingAndCreationTransactionTypeLoan extends ITest{
    @Test(priority = 1)
    @Title("Проверка создания новой сделки типа Loan")
            public void verifyingAndCreationTransactionTypeLoan() throws IOException, InterruptedException {
        System.out.println("Проверка создания новой сделки типа Loan");
        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");

        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();

        //Прожимаем горячие клаваиши alt+t и попадаем в журнал сделок
        tradeToolbar.createNewTrade("Loan");

        // Как по тест кейсу прожимаем сэйв в пустые поля.
        tradeWindow.saveTrade();
        tradeWindow.pressButtonOk();

        //Идентификатор
        tradeWindow.typeIdentifier("Green");
        //Выбираем сторону
        tradeWindow.pressTapeGet();
        //Подразделение
        tradeWindow.typeBranch("Atest");
        //Клиент
        tradeWindow.typeClient("ATB");
        //Контрагент
        tradeWindow.typeCounterparty("ATest Counterparty");
        //Портфель
        tradeWindow.typePortfolio("1865");
        //Тредер
        tradeWindow.typeTrader("abarsukov / abarsukov");
        //Инструмент
        tradeWindow.typeInstrument("BRITISH POUND STERLING CASH");
        //Продукт
        tradeWindow.inputProduct();
        // Сумма
        tradeWindow.inputSumm();
        //Дата окончания
        tradeWindow.backData();
        // Ставка
        tradeWindow.inputRate(2);

        tradeWindow.saveTrade();
        tradeWindow.waitSeconds(10000);
    }
    @Test(priority = 2)
    @Title("Проверка новой сделки типа Loan в списке.")
    public class CreatingTransactionAssertInTable extends ITest {
        public void creatingTransactionAssertInTableLoan() throws IOException, InterruptedException {
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            //Авторизация
            loginPage.authorization("s.kviatkovsky", "etpoN7VV");
            mainFrame.waitForHideLoading();
            headerForm.creatAndCkickTransactionLog();

            System.out.println("Проверка создания новой сделки типа loan");

            // Прожимаем кнопку "Активировать журнал"
            tradeToolbar.pressButtonActiv();

            //Ввод в поиск ID и проверка поиска сделки.
            tradeToolbar.inputIDInForm("Green","Loan");
        }
    }
}



