package Limits;

import Core.ITest;
import Pages.Limits.Toolbar;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

/**
 * Created by Sergey on 24.05.2017.
 */
@Test
@Title("Поиск лимитов и категорий")
public class LimitFindForm extends ITest {
       public void limitFindForm() throws IOException, InterruptedException{
        System.out.println("Поиск лимитов и категорий");


           navigateTo("http://alfa-limits.egar.egartech.com/limitsmanager/login.do");
           //Авторизация
           loginPage.authorization("s.kviatkovsky", "etpoN7VV");
           mainFrame.waitForHideLoading();
           headerForm.clickLimitsTab();
           limitsToolbar.inputFindFormLimits("TestCat1");
           limitsToolbar.checkCategoryHeader("TestCat1");
    }

}
