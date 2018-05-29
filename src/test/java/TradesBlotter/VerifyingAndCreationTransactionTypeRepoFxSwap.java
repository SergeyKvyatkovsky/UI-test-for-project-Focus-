package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 05.06.2017.
 */
@Test(priority = 1)  //Дописать проверки в таблице.
@Title("Проверка создания новой сделки типа Fx Swap")
public class VerifyingAndCreationTransactionTypeRepoFxSwap extends ITest {
    public void verifyingAndCreationTransactionTypeRepoFxSwap() throws IOException, InterruptedException {
        System.out.println("Проверка создания новой сделки типа Fx Swap");

        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();
        //Прожимаем горячие клаваиши alt+t и попадаем в журнал сделок
        tradeToolbar.createNewTrade("FX Swap");
        // Как по тест кейсу прожимаем сэйв в пустые поля.
        tradeWindow.saveTrade();
        tradeWindow.pressButtonOk();

        //Идентификатор
        tradeWindow.typeIdentifier("Yellow");
        //Выбираем сторону
        tradeWindow.chooseTapeSellBuy();

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
        tradeWindow.typeInstrument("A33/AMD");
        //Кол-во
        tradeWindow.typeQuantity("123123");
        //курс
        tradeWindow.inputCourse();
        //Опдата
        tradeWindow.inputPayment();
        //Условия расчета
        tradeWindow.inputSettlementType();
        //курс вторая нога
        tradeWindow.inputCourseTwo();
        //Опдата
        tradeWindow.inputPaymentTwo();
        //Условия расчета вторая нога
        tradeWindow.inputSettlementTypeTwo();
        tradeWindow.saveTrade();

        tradeWindow.waitSeconds(15000);





    }
    @Test(priority = 2)
    @Title("Проверка новой сделки типа FX SWAP в списке.")
    public class CreatingTransactionAssertInTable extends ITest {
        public void creatingTransactionAssertInTableFxSwap() throws IOException, InterruptedException {
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            //Авторизация
            loginPage.authorization("s.kviatkovsky", "etpoN7VV");
            mainFrame.waitForHideLoading();
            headerForm.creatAndCkickTransactionLog();

            System.out.println("Проверка создания новой сделки типа Margin Call");

            // Прожимаем кнопку "Активировать журнал"
            tradeToolbar.pressButtonActiv();

            //Ввод в поиск ID и проверка поиска сделки.
            tradeToolbar.inputIDInForm("Yellow","FX Swap");
        }
    }
}