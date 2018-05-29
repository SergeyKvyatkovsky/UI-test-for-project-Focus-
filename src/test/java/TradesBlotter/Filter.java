package TradesBlotter;

import Core.ITest;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.List;

public class Filter extends ITest{

    @Title("Проверка фильтрации по идентификатору")
    @Test(priority =1)
    public void filterById() throws IOException, InterruptedException {
        //Переходим по url
        navigateTo(url);
        //Авторизация
        loginPage.authorization(username, password);
        //Колесико загрузки
        mainFrame.waitForHideLoading();
        //Добавляем журнал сделок
        headerForm.addTradesBlotter();

        tradeParametersPanel.typeTradeId("ATest/1");
        tradeParametersPanel.startStopBlotter();
        mainFrame.waitForHideLoading();
        List<String> list = tradeGridPanel.getValuesFromColumn("#");

        for (int i=0;i<list.size();i++)
            Assert.assertEquals("ATest/1", list.get(i));

    }
}
