package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 03.06.2017.
 */
@Test(priority = 1)  //Дописать проверки в таблице.
@Title("Проверка создания новой сделки типа REPO")
public class VerifyingAndCreationTransactionTypeRepo extends ITest {
    public void verifyingAndCreationTransactionTypeRepo() throws IOException, InterruptedException {
        System.out.println("Проверка создания новой сделки типа REPO");


        navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        mainFrame.waitForHideLoading();
        headerForm.creatAndCkickTransactionLog();

        //Прожимаем горячие клаваиши alt+t и попадаем в журнал сделок
        tradeToolbar.createNewTrade("Repo");

        // Как по тест кейсу прожимаем сэйв в пустые поля.
        tradeWindow.saveTrade();
        tradeWindow.pressButtonOk();

        //Заполняем поля и выбираем некторые выпадающие списки.
        //Идентификатор
        tradeWindow.typeIdentifier("silver");
        //Выбираем сторону
        tradeWindow.chooseTapeDirect();

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
        tradeWindow.typeInstrument("0605CJCE5010");
        //Торговая площадка
        tradeWindow.inputSellpalace();
        //Кол-во
        tradeWindow.inputCount();
        //Подтв дисконт
        tradeWindow.inputApprovedDiscount();
        //Цена
        tradeWindow.inputCost();
        //Платёж
        tradeWindow.inputPayment();
        //Валюта цены
        tradeWindow.chooseCurrencyCoast();
        //Валюта оплаты
        tradeWindow.chooseInputPayment();
        //Условаия расчета
        tradeWindow.inputSettlementType();
        //Цена вторая нога
        tradeWindow.inputCostTwo();
        //Валюта вторая нога
        tradeWindow.chooseInputPaymentTwo();
        //Валюта вторая нога
        tradeWindow.chooseCurrencyCoastTwo();
        //Опдата вторая нога
        tradeWindow.inputPaymentTwo();
        //Условия расчета вторая нога
        tradeWindow.inputSettlementTypeTwo();
        //Ставка
        tradeWindow.inputInterestRate();
        //Дисконт
        tradeWindow.inputDiscount();

        tradeWindow.saveTrade();

        tradeWindow.waitSeconds(15000);

    }
@Test(priority = 2)
@Title("Проверка новой сделки типа REPO в списке.")
    public class CreatingTransactionAssertInTable extends ITest {
        public void creatingTransactionAssertInTableREPO() throws IOException, InterruptedException {
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            //Авторизация
            loginPage.authorization("s.kviatkovsky", "etpoN7VV");
            mainFrame.waitForHideLoading();
            headerForm.creatAndCkickTransactionLog();

            System.out.println("Проверка создания новой сделки типа Margin Call");

            // Прожимаем кнопку "Активировать журнал"
            tradeToolbar.pressButtonActiv();

            //Ввод в поиск ID и проверка поиска сделки.
            tradeToolbar.inputIDInForm("silver","Repo");
        }
    }
}

