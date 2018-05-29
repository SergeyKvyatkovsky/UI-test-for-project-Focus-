package Data;

import Core.ITest;
import Helpers.ParamReader;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;


public class NewRecord extends ITest{

    String idRecord = null;
    //Файл с данными
    final String parameters = ".//Parameters//Data//record.xml";

    @Title("Создание контрагента")
    @Test(priority = 1)
    public void createNewRecord() throws IOException, InterruptedException {
        navigateTo(url);
        //Авторизация
        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        //Открытие вкладки Данные
        headerForm.clickDataTab();
        dataToolbar.waitForContentTab();

        //Открытие таблицы Counterparties
        dataPage.clickCounterparties();
        mainFrame.waitForHideLoading();

        //Нажатие на кнопку 'Новая запись'
        dataToolbar.clickNewRecord();
        dataDictionaryRecord.waitForHeader();

        //Заполение полей
        dataDictionaryRecord.typeName(ParamReader.getParameterByXpath(parameters, "//record[@name='counterpartyNew']/Name/text()"));
        dataDictionaryRecord.typeShortName(ParamReader.getParameterByXpath(parameters, "//record[@name='counterpartyNew']/ShortName/text()"));
        dataDictionaryRecord.clickIsClient();
        dataDictionaryRecord.clickType();

        mainFrame.waitForHideLoading();
        //Выбор типа

        //Костыль
        //mainFrame.waitSeconds(3000);
        dataDictionaryRecord.selectTypeIndividual();
        dataDictionaryRecord.checkTypeField();

        //Нажатие на кнопку Сохранить
        dataDictionaryRecord.saveRecord();

        //
        mainFrame.waitForSuccessMessage();
        idRecord = mainFrame.getIdFromMessage();
    }

    @Title("Изменение контрагента")
    @Test(priority = 2)
    public void editRecord(){
        dataToolbar.typeInSearchInput(ParamReader.getParameterByXpath(parameters, "//record[@name='counterpartyNew']/Name/text()"));


        mainFrame.waitForHideLoading();

        //dataTable.clickRow(0);
      //  dataTable.clickNewRecordRow();
        mainFrame.waitForHideLoading();


        //Наать кнопку Редактировать
        dataDictionaryRecord.clickEdit();

        //dataDictionaryRecord.assertId(idRecord);

        dataDictionaryRecord.typeName(ParamReader.getParameterByXpath(parameters, "//record[@name='counterpartyEdit']/Name/text()"));
        dataDictionaryRecord.typeShortName(ParamReader.getParameterByXpath(parameters, "//record[@name='counterpartyEdit']/ShortName/text()"));

        dataDictionaryRecord.clickType();
        mainFrame.waitForHideLoading();



        dataDictionaryRecord.selectTypeCorporate();

        dataDictionaryRecord.clickIsIssuer();

        dataDictionaryRecord.saveRecord();
        mainFrame.waitForHideLoading();
        mainFrame.waitForSuccessMessage();

    }

    @Title("Удаление контрагента")
    @Test(priority = 3)
    public void deleteRecord(){
        dataToolbar.typeInSearchInput(ParamReader.getParameterByXpath(parameters, "//record[@name='counterpartyNew']/Name/text()"));
        mainFrame.waitForHideLoading();

        //dataTable.clickRow(0);
       // dataTable.clickEditRecordRow();
        mainFrame.waitForHideLoading();

        dataDictionaryRecord.clickDeleteButton();
        dataDictionaryRecord.clickYesInMessageBox();

        mainFrame.waitForHideLoading();

        mainFrame.waitForSuccessMessage();

    }

}
