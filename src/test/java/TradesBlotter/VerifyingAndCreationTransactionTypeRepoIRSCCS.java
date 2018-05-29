package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 04.06.2017.
 */
    @Test(priority = 1)  //Дописать проверки в таблице.
    @Title("Проверка создания новой сделки типа IRS/CCS")
    public class VerifyingAndCreationTransactionTypeRepoIRSCCS extends ITest {
        public void verifyingAndCreationTransactionTypeRepoIRSCCS() throws IOException, InterruptedException {
            System.out.println("Проверка создания новой сделки типа IRS/CCS");
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            //Авторизация
            loginPage.authorization("s.kviatkovsky", "etpoN7VV");
            mainFrame.waitForHideLoading();
            headerForm.creatAndCkickTransactionLog();

            //Прожимаем горячие клаваиши alt+t и попадаем в журнал сделок
            tradeToolbar.createNewTrade("IRS / CCS");

            // Как по тест кейсу прожимаем сэйв в пустые поля.
            tradeWindow.saveTrade();
            tradeWindow.pressButtonOk();

            //Заполняем поля и выбираем некторые выпадающие списки.
            //Идентификатор
            tradeWindow.typeIdentifier("pink");

            //Подразделение
            tradeWindow.typeBranch("Atest");
            //Клиент
            tradeWindow.typeClient("ATB");
            //Контрагент
            tradeWindow.typeCounterparty("ATest Counterparty");
            //Портфель
            tradeWindow.typePortfolio("1865");
            //Трэйдер
            tradeWindow.typeTrader("abarsukov / abarsukov");
            //Период олплаты
            tradeWindow.inputPeriodPayment();
            //Ставка
            tradeWindow.rateIrcCcs();
            //Сумма
            tradeWindow.inputSummRateIrcCcs();
            //Период возврата
            tradeWindow.inputPeriodReceiving();
            //Кривая дох-ти
            tradeWindow.inputYeldCurves();
            //Период кривой
            tradeWindow.inputPeriodYieldCurves();
            //Валюта суммы
            tradeWindow.inputCurrencySummRateIrcCcs();
            //
            tradeWindow.inputSpread();
            //Валюта
            tradeWindow.inputCurrencySpread();
            //Тип оплаты
            tradeWindow.typePayment("1232133");

            tradeWindow.saveTrade();

            tradeWindow.waitSeconds(15000);
        }
@Test(priority = 2)
@Title("Проверка новой сделки типа IRC/CSS в списке.")
    public class CreatingTransactionAssertInTable extends ITest {
        public void creatingTransactionAssertInTableIrcCss() throws IOException, InterruptedException {
            navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
            //Авторизация
            loginPage.authorization("s.kviatkovsky", "etpoN7VV");
            mainFrame.waitForHideLoading();
            headerForm.creatAndCkickTransactionLog();

            System.out.println("Проверка создания новой сделки типа IRC/CSS");

            // Прожимаем кнопку "Активировать журнал"
            tradeToolbar.pressButtonActiv();

            //Ввод в поиск ID и проверка поиска сделки.
            tradeToolbar.inputIDInForm("pink","IRS / CCS");
        }
    }
}
