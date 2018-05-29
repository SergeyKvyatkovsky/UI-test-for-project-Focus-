package Pages.TradesBlotter;

import Core.IPage;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static Core.ITest.mainFrame;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class TradeWindow extends IPage{

    //Поле Ид-р / Тип
    By inputIdentifier = By.xpath("//input[starts-with(@id, 'textfield')]");

    //button[starts-with(@id, '')]
    //Кнопка Купить
    By buttonSideBuy = By.xpath("//button[starts-with(@id, 'btnSideBuy-button')]");

    //Кнопка Продать
    By buttonSideSell = By.xpath("//button[starts-with(@id, 'btnSideSell-button')]");

    //Поле поиска
    By inputSearch = By.xpath("//input[starts-with(@id, 'fldSearch-lssearchfield')]");

    //Выбор branch
    By divTrgBranch = By.xpath("//div[@id='trgBranch1']");

    //Поле подразделение
    By inputBranch = By.xpath("//input[@name='BranchId']");

    //Строка таблицы
    //By spanSearchItem = By.xpath("//div[starts-with(@id, 'blstBranch-boundlist')]//div[@class='ls-search-item']");

    By spanSearchItem = By.xpath("//div[contains(@id, 'boundlist')]//div[@class='ls-search-item']");

    //Поле Портфель
    By liPortfolio = By.xpath("//div[contains(@id, 'blstPortfolio-boundlist')]//li[1]");

    //Трейдер
    By liTrader = By.xpath("//div[contains(@id, 'blstTrader-boundlist')]//li[1]");

    //Инструмент
    By liInstrument = By.xpath("//div[contains(@id, 'blstInstrument-boundlist')]//li[1]");

    //Условия расчетоа
    By liSettlementType = By.xpath("//div[contains(@id, 'blstSettlementType-boundlist')]//li[1]");

    //Поле клиент
    By inputClient = By.xpath("//input[@name='CustomerId']");

    //Поле Контрагент
    By inputCounterparty = By.xpath("//input[@name='CounterpartyId']");

    //Поле Портфель
    By inputPortfolio = By.xpath("//input[@name='PortfolioId']");

    //Поле Трейдер
    By inputTrader = By.xpath("//input[@name='TraderId']");

    //Поле Инструмент
    By inputInstrument = By.xpath("//input[@name='InstrumentId']");

    //Поле Количество
    By inputQuantity = By.xpath("//input[@name='Quantity']");

    //Поле Цена
    By inputPrice = By.xpath("//input[@name='Price']");

    //Поле Платеж
    By inputPayment = By.xpath("//input[@name='Payment']");

    //Поле НКД
    By inputAccruedInterest = By.xpath("//input[@name='AccruedInterest']");

    //Поле Условия расчетов
    By inputSettlementType = By.xpath("//input[@name='SettlementType']");

    //Поле валюты цены
    By inputPriceCurrencyCode = By.xpath("//input[@name='PriceCurrencyCode']");

    //Поле валюты платежа
    By inputPaymentCurrencyCode = By.xpath("//input[@name='PaymentCurrencyCode']");

    //Список валют цены
    By listLiPriceCcy = By.xpath("//div[starts-with(@id, 'blstPriceCurrCode-boundlist')]/ul/li");

    //Список валют платежа
    By listLiPaymentCcy = By.xpath("//div[starts-with(@id, 'blstPaymentCurrCode-boundlist')]/ul/li");

    //Кнопка Сохранить
    By buttonSave = By.xpath("//button[starts-with(@id, 'btnSave-button')]");

    //Чекбокс Форвард
    By checkboxForward = By.xpath("//input[starts-with(@id, 'chkForward-checkboxfield')]");

    //Сумма
    By summMarginCall = By.xpath(".//*[@name='Quantity']");

    //Поле дата окончания
    By date = By.xpath(".//*[@name='ExpirationDate']");

    //Кнопка ОК в алерте при ошибке.
    By buttonOkInError = By.xpath(".//button[@id='ok-button-1005-btnEl']");

    //Кнопка сторооны "Зачисление"
    By tapeEnrollment = By.xpath(".//span[text()='Зачисление']");

    //Кнопка сторооны "Взять"
    By tapeGet = By.xpath(".//span[text()='Взять']");

    //Поле Продукт
    By product = By.xpath(".//*[@name='ProductCode']");

    //Поле возврат
    By backing = By.xpath(".//*[@name='ExpirationDate']");

    //Поле возврат
    By rate = By.xpath(".//*[@name='InterestRate']");

    //Кнопка сторооны Прямое
    By tapeDirect = By.xpath(".//span[text()='Прямое']");

    //Поле торг площадка
    By sellPlace = By.xpath(".//*[@name='TradingFloorId']");

    //Поле Количество
    By count = By.xpath(".//*[@name='Quantity']");

    //Поле подт. дисконт
    By approvedDiscount = By.xpath(".//*[@name='ApprovedDiscount']");

    //Поле Цена для REPO НОГА 1
    By cost = By.xpath(".//*[@name='_Price1']");

    //Выпадающий список выбора валюты для Цены НОГА 1
    By costDropList = By.xpath(".//input[@name='_PriceCurrencyCode1']");

    //Платёж для REPO НОГА 1
    By payment = By.xpath(".//*[@name='_Payment1']");

    //Выпадающий список выбора валюты для платежа НОГА 1
    By paymentDropList = By.xpath("//*[@name='_PaymentCurrencyCode1']");

    //Условие расчета для REPO НОГА 1
    By settlementType = By.xpath(".//*[@name='_SettlementType1']");

    //Поле Цена для REPO НОГА 2
    By costTwo = By.xpath(".//*[@name='_Price2']");

    //Выпадающий список выбора валюты для Цены НОГА 2
    By costDropListTwo = By.xpath(".//input[@name='_PriceCurrencyCode2']");

    //Платёж для REPO НОГА 2
    By paymentTwo = By.xpath(".//*[@name='_Payment2']");

    //Выпадающий список выбора валюты для платежа НОГА 2
    By paymentDropListTwo = By.xpath(".//*[@name='_PaymentCurrencyCode2']");

    //Условие расчета для REPO НОГА 2
    By settlementTypeTwo = By.xpath(".//*[@name='_SettlementType2']");

    //Ставка REPO
    By interestRate = By.xpath(".//*[@name='InterestRate']");

    //Дисконт REPO
    By discount = By.xpath(".//*[@name='Haircut']");

    //Период платежа IRC/CCS
    By periodPayment = By.xpath(".//*[@name='_PaymentP']");

    //Ставка IRC/CCS
    By rateIrcCcs = By.xpath(".//*[@name='_RateP']");

    //Сумма ставки (Рефактор есть такой же локатор)
    By summRateIrcCcs = By.xpath(".//*[@name='Quantity']");

    //Валюта суммы
    By currencySummRateIrcCcs = By.xpath(".//*[@name='_CurrencyP']");

    //Период получения IRC/CCS
    By periodReceiving = By.xpath(".//*[@name='_PaymentR']");

    //Кривая доходности IRC/CCS
    By yieldCurves = By.xpath(".//*[@name='_YieldCurvesR']");

    //Период доходности IRC/CCS
    By periodYieldCurves = By.xpath(".//*[@name='_UnitR']");

    //Смещение IRC/CCS
    By spread = By.xpath(".//*[@name='_SpreadR']");

    //Смещение IRC/CCS
    By currencySpread = By.xpath(".//*[@name='_CurrencyR']");

    //Кнопка сторооны Прямое Fx Swap
    By tapeSellBuy = By.xpath(".//span[text()='Покупка/Продажа']");

    //Кнопкакурс Fx Swap первая нога
    By course = By.xpath(".//*[@name='_Rate1']");

       //Кнопка условия Fx Swap вторая нога
    By courseTwo = By.xpath(".//*[@name='_Rate2']");



    public TradeWindow(WebDriver driver) {
        super(driver);
    }

    @Step("Выбор стороны")
    public TradeWindow selectSide(String side){
        switch (side){
            case "buy":
                click(buttonSideBuy);
                break;
            case "sell":
                click(buttonSideSell);
                break;
            default:
                break;
        }
        return this;
    }

    private void typeInputField(By locator, String text){
        waitFor(locator);
        clear(locator);
        sendKeys(locator, text);
    }

    @Step("Ввод ид-ра")
    public TradeWindow typeIdentifier(String text){
        typeInputField(inputIdentifier, text);
        return this;
    }

    @Step("Ввод подразделения")
    public TradeWindow typeBranch(String branch){
        typeInputField(inputBranch, branch);
        click(inputBranch);
        mainFrame.waitForHideLoading();
        sendKeys(inputBranch, Keys.DOWN);
        sendKeys(inputBranch, Keys.DOWN);
        sendKeys(inputBranch, Keys.TAB);
        return this;
    }

    @Step("Ввод клиента")
    public TradeWindow typeClient(String client){
        typeInputField(inputClient, client);
        click(inputClient);
        mainFrame.waitForHideLoading();
        sendKeys(inputClient, Keys.DOWN);
        sendKeys(inputClient, Keys.DOWN);
        sendKeys(inputClient, Keys.TAB);
        return this;
    }

    @Step("Ввод контрагента")
    public TradeWindow typeCounterparty(String counterparty){
        typeInputField(inputCounterparty, counterparty);
        click(inputCounterparty);
        mainFrame.waitForHideLoading();
        waitForPresence(inputCounterparty);
        sendKeys(inputCounterparty, Keys.DOWN);
        sendKeys(inputCounterparty, Keys.DOWN);
        sendKeys(inputCounterparty, Keys.TAB);
        return this;
    }

    @Step("Прожимается кнопка зачислить")  //рефактор названия
    public TradeWindow enrollmentWriteOff(){
        click(tapeEnrollment);
        return this;
    }

    @Step("Прожимается кнопка Взять")
    public TradeWindow pressTapeGet(){
        click(tapeGet);
        return this;
    }

    @Step("Ввод портфеля")
    public TradeWindow typePortfolio(String portfolio){
        typeInputField(inputPortfolio, portfolio);
        click(inputPortfolio);
        mainFrame.waitForHideLoading();
        waitForPresence(inputPortfolio);
        sendKeys(inputPortfolio, Keys.DOWN);
        sendKeys(inputPortfolio, Keys.TAB);
        return this;
    }

    @Step("Ввод трейдера")
    public TradeWindow typeTrader(String text){
        typeInputField(inputTrader, text);
        click(inputTrader);
        mainFrame.waitForHideLoading();
        sendKeys(inputTrader, Keys.DOWN);
        sendKeys(inputTrader, Keys.TAB);
        return this;
    }

    @Step("Ввод инструмента")
    public TradeWindow typeInstrument(String text){
        typeInputField(inputInstrument, text);
        click(inputInstrument);
        mainFrame.waitForHideLoading();
        sendKeys(inputInstrument, Keys.DOWN);
        sendKeys(inputInstrument, Keys.TAB);
        return this;
    }

    @Step("Ввод количества")
    public TradeWindow typeQuantity(String text){
        typeInputField(inputQuantity, text);
           return this;
    }

    @Step("Ввод цены")
    public TradeWindow typePrice(String text){
        typeInputField(inputPrice, text);
        return this;
    }

    @Step("Ввод платежа")
    public TradeWindow typePayment(String text){
        typeInputField(inputPayment, text);
        return this;
    }

    @Step("Ввод нкд")
    public TradeWindow typeAccruedInterest(String text){
        typeInputField(inputAccruedInterest, text);
        return this;
    }

    @Step("Ввод условий расчета")
    public TradeWindow typeSettlementType(String text){
        typeInputField(inputSettlementType, text);
        return this;
    }

    public TradeWindow selectItem(){
        getElement(spanSearchItem, getSizeOfElements(spanSearchItem)-1).click();
        waitForHide(spanSearchItem);
        return this;
    }

    public TradeWindow selectItem(String itemName){
        By item = null;
        switch (itemName){
            case "Portfolio":
                item = liPortfolio;
                break;
            case "Trader":
                item = liTrader;
                break;
            case "Instrument":
                item = liInstrument;
                break;
            case "SettlementType":
                item = liSettlementType;
                break;
            default:
                break;
        }
        click(item);
        waitForHide(item);
        return this;
    }

    public TradeWindow selectPriceCurrency(String ccy){
        click(inputPriceCurrencyCode);
        waitFor(listLiPriceCcy);
        getElementFromList(listLiPriceCcy, ccy).click();
        waitForHide(listLiPriceCcy);
        return this;
    }

    public TradeWindow selectPaymentCurrency(String ccy){
        click(inputPaymentCurrencyCode);
        waitFor(listLiPaymentCcy);
        getElementFromList(listLiPaymentCcy, ccy).click();
        waitForHide(listLiPaymentCcy);
        return this;
    }

    @Step("Сохранение сделки")
    public TradeWindow saveTrade(){
            waitForPresence(buttonSave);
            try{
                click(buttonSave);
            } catch (Exception ex){
                saveTrade();
            }
            return this;
    }
    @Step("Ввод суммы")
    public TradeWindow inputSumm(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(inputQuantity,randomInt);
        return this;
    }

    @Step("Ввод даты")
    public TradeWindow inputDateEnd(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");
        mainFrame.waitForHideLoading();
        String formateedDate = simpleDateFormat.format(new Date());
        sendKeys(date,formateedDate);
        return this;
    }

    @Step("Нажатие кнопки ОК")
    public TradeWindow pressButtonOk(){
        click(buttonOkInError);
        return this;
    }

    @Step("Ввод в поле продукт")
    public TradeWindow inputProduct(){
        sendKeys(product,"AutoQA prodduct1");
        click(product);
        mainFrame.waitForHideLoading();
        sendKeys(product, Keys.DOWN);
        sendKeys(product, Keys.TAB);
        return this;
    }

    @Step("Ввод даты возврата")
    public TradeWindow backData(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.YYYY");
        mainFrame.waitForHideLoading();
        String formateedDate = simpleDateFormat.format(new Date());
        sendKeys(backing,formateedDate);
        return this;
    }

    @Step("Ввод ставки")
    public TradeWindow inputRate(int rateValue){
        String textRateValue = String.valueOf(rateValue);
        sendKeys(rate,textRateValue);

        return this;
    }

    @Step("Ввод в поле торг площадка")
    public TradeWindow inputSellpalace(){
        sendKeys(sellPlace,"9900009");
        click(sellPlace);
        mainFrame.waitForHideLoading();
        sendKeys(sellPlace, Keys.DOWN);
        sendKeys(sellPlace, Keys.TAB);
        return this;
    }

    @Step("Ввод в поле количество")
    public TradeWindow inputCount(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(inputQuantity,randomInt);
        return this;
    }

    @Step("Ввод в поле подтверджедние дисконта")
    public TradeWindow inputApprovedDiscount(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(approvedDiscount,randomInt);
        return this;
    }

    @Step("Ввод в поле цена первая нога")
    public TradeWindow inputCost(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(cost,randomInt);
        return this;
    }

    @Step("Выбор валюты цены первая нога")
    public TradeWindow chooseCurrencyCoast(){
        click(costDropList);
        mainFrame.waitForHideLoading();
        sendKeys(costDropList,Keys.DOWN);
        sendKeys(costDropList,Keys.TAB);
        return this;
    }

    @Step("Ввод в поле платёж первая нога")
    public TradeWindow inputPayment(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(payment,randomInt);
        return this;
    }

    @Step("Выбор валюты платежа первая нога")
    public TradeWindow chooseInputPayment(){
        click(paymentDropList);
        mainFrame.waitForHideLoading();
        sendKeys(paymentDropList,Keys.DOWN);
        sendKeys(paymentDropList,Keys.TAB);

        return this;
    }

    @Step("Ввод в поле условия расчета первая нога")
    public TradeWindow inputSettlementType() {
        sendKeys(settlementType, "AutoQA Setltype");
        click(settlementType);
        mainFrame.waitForHideLoading();
        sendKeys(settlementType, Keys.DOWN);
        sendKeys(settlementType, Keys.TAB);
        return this;
    }

    @Step("Ввод в поле цена вторая нога")
    public TradeWindow inputCostTwo(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(costTwo,randomInt);
        return this;
    }

    @Step("Выбор валюты цены вторая нога")
    public TradeWindow chooseCurrencyCoastTwo(){
        click(costDropListTwo);
        mainFrame.waitForHideLoading();
        sendKeys(costDropListTwo,Keys.DOWN);
        sendKeys(costDropListTwo,Keys.TAB);
        return this;
    }

    @Step("Ввод в поле платёж вторая нога")
    public TradeWindow inputPaymentTwo(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(paymentTwo,randomInt);
        return this;
    }

    @Step("Выбор валюты платежа первая нога")
    public TradeWindow chooseInputPaymentTwo(){
        click(paymentDropListTwo);
        mainFrame.waitForHideLoading();
        sendKeys(paymentDropListTwo,Keys.DOWN);
        sendKeys(paymentDropListTwo,Keys.TAB);
        return this;
    }

    @Step("Ввод в поле условия расчета вторая нога")
    public TradeWindow inputSettlementTypeTwo() {
        sendKeys(settlementTypeTwo, "AutoQA Setltype");
        click(settlementTypeTwo);
        mainFrame.waitForHideLoading();
        sendKeys(settlementTypeTwo, Keys.DOWN);
        sendKeys(settlementTypeTwo, Keys.TAB);
        return this;
    }

    @Step("Ввод в поле ставка")
    public TradeWindow inputInterestRate(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(interestRate,randomInt);
        return this;
    }

    @Step("Ввод в поле дисконт")
    public TradeWindow inputDiscount(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(discount,randomInt);
        return this;
    }

    @Step("Период платежа")
    public TradeWindow inputPeriodPayment(){
        click(periodPayment);
        mainFrame.waitForHideLoading();
        sendKeys(periodPayment, Keys.DOWN);
        sendKeys(periodPayment, Keys.TAB);
        return this;
    }

    @Step("Cумма ставки")
    public TradeWindow rateIrcCcs(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(rateIrcCcs,randomInt);

        return this;
    }

    @Step("Cумма ставки")
    public TradeWindow inputSummRateIrcCcs(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(inputQuantity,randomInt);

        return this;
    }

    @Step("Период платежа")
    public TradeWindow inputPeriodReceiving(){
        click(periodReceiving);
        mainFrame.waitForHideLoading();
        sendKeys(periodReceiving, Keys.DOWN);
        sendKeys(periodReceiving, Keys.TAB);
        return this;
    }

    @Step("Кривая доходности")
    public TradeWindow inputYeldCurves(){
        sendKeys(yieldCurves,"YC(test)");
        click(yieldCurves);
        mainFrame.waitForHideLoading();
        sendKeys(yieldCurves, Keys.DOWN);
        sendKeys(yieldCurves, Keys.TAB);
        return this;
    }

    @Step("Период доходности")
    public TradeWindow inputPeriodYieldCurves(){
        click(periodYieldCurves);
        mainFrame.waitForHideLoading();
        sendKeys(periodYieldCurves, Keys.DOWN);
        sendKeys(periodYieldCurves, Keys.TAB);
        return this;
    }

    @Step("Cумма")
    public TradeWindow inputSpread(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(spread,randomInt);

        return this;
    }

    @Step("Валюта суммы")
    public TradeWindow inputCurrencySummRateIrcCcs(){
        click(currencySummRateIrcCcs);
        mainFrame.waitForHideLoading();
        sendKeys(currencySummRateIrcCcs, Keys.DOWN);
        sendKeys(currencySummRateIrcCcs, Keys.TAB);
        return this;
    }

    @Step("Период доходности")
    public TradeWindow inputCurrencySpread(){
        click(currencySpread);
        mainFrame.waitForHideLoading();
        sendKeys(currencySpread, Keys.DOWN);
        sendKeys(currencySpread, Keys.TAB);
        return this;
    }

    @Step
    public TradeWindow chooseTapeSellBuy() {
        click(tapeSellBuy);
        return this;
    }

    @Step
    public TradeWindow chooseTapeDirect(){
        click(tapeDirect);
        return this;
    }

    @Step("Курс первая нога")
    public TradeWindow inputCourse(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(course,randomInt);

        return this;
    }

    @Step("Курс вторая нога")
    public TradeWindow inputCourseTwo(){
        final Random random = new Random(1);
        String randomInt = String.valueOf(random.nextInt());
        sendKeys(courseTwo,randomInt);

        return this;
    }

    public TradeWindow checkForward(String check){
        if (check.equals("1"))
            click(checkboxForward);
        return this;
    }
}
