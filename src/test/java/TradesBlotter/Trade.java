package TradesBlotter;

import Core.ITest;
import Helpers.ParamReader;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.HashMap;

import static Helpers.ParameterFiles.TRADES;

public class Trade extends ITest{

    @Title("Создание новой сделки Security Spot/Forward")
    @Test (priority = 1)
    public void createSecuritySpotForward() throws IOException, InterruptedException {

        //Загружаем все параметры по сделке в мапу
        HashMap<String, String> trade = ParamReader.getMapByXpath(TRADES, "//trade[@name='SSF']/*");

        //Переходим по url
        navigateTo(url);
        //Авторизация
        loginPage.authorization("s.kviatkovsky", "etpoN7VV");
        //Колесико загрузки
        mainFrame.waitForHideLoading();
        //Добавляем журнал сделок
     //   headerForm.addTradesBlotter();
        //Создаем новую сделку
        tradeToolbar.createNewTrade(trade.get("type"));
        //Вводим ид-р
        tradeWindow.typeIdentifier(trade.get("identifier"));

        //Выбираем сторону сделки
        tradeWindow.selectSide(trade.get("side"));

        tradeWindow.typeBranch(trade.get("branch"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem();

        tradeWindow.typeClient(trade.get("client"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem();

        tradeWindow.typeCounterparty(trade.get("ctpt"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem();

        tradeWindow.typePortfolio(trade.get("portfolio"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("Portfolio");

        tradeWindow.typeTrader(trade.get("trader"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("Trader");

        tradeWindow.typeInstrument(trade.get("instrument"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("Instrument");

        tradeWindow.typeQuantity(trade.get("quantity"));

        tradeWindow.typePrice(trade.get("price"));

        tradeWindow.typePayment(trade.get("payment"));

        tradeWindow.typeAccruedInterest(trade.get("accruedInterest"));

        tradeWindow.typeSettlementType(trade.get("settlementType"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("SettlementType");

        tradeWindow.selectPriceCurrency(trade.get("priceCurrencyCode"));
        tradeWindow.selectPaymentCurrency(trade.get("paymentCurrencyCode"));
        tradeWindow.saveTrade();
        mainFrame.waitForSuccessMessage();
    }

    @Title("Создание новой сделки FX Spot/Forward")
    @Test(priority = 2)
    public void createFXSpotForwardTrade(){
        //Загружаем все параметры по сделке в мапу
        HashMap<String, String> trade = ParamReader.getMapByXpath(TRADES, "//trade[@name='FXSF']/*");

        //Создаем новую сделку
        tradeToolbar.createNewTrade(trade.get("type"));
        //Вводим ид-р
        tradeWindow.typeIdentifier(trade.get("identifier"));

        //Выбираем сторону сделки
        tradeWindow.selectSide(trade.get("side"));

        tradeWindow.typeBranch(trade.get("branch"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem();

        tradeWindow.typeClient(trade.get("client"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem();

        tradeWindow.typeCounterparty(trade.get("ctpt"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem();

        tradeWindow.typePortfolio(trade.get("portfolio"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("Portfolio");

        tradeWindow.typeTrader(trade.get("trader"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("Trader");

        tradeWindow.typeInstrument(trade.get("instrument"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("Instrument");
        tradeWindow.typeQuantity(trade.get("quantity"));
        tradeWindow.typePrice(trade.get("price"));
        tradeWindow.typePayment(trade.get("payment"));

        tradeWindow.typeSettlementType(trade.get("settlementType"));
        mainFrame.waitForHideLoading();
        tradeWindow.selectItem("SettlementType");

        tradeWindow.saveTrade();
        mainFrame.waitForSuccessMessage();
        mainFrame.waitSeconds(10000);
    }

}
