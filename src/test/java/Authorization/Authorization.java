package Authorization;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

@Title("Авторизация")
@Test
public class Authorization extends ITest{

    public void authorization() throws Exception {

        //final String user = "e.uvarov";

        //Переход по URL
        System.out.println(url);
        navigateTo(url);

        //Ввод догина
        //loginPage.typeUsername(username);
        loginPage.typeUsername("s.kviatkovsky");

        //Ввод пароля
        //loginPage.typePassword(password);
        loginPage.typePassword(password);

        //Нажатие кнопки "Авторизация"
        loginPage.submit();

        //Ожидание завершения загрузки
        mainFrame.waitForHideLoading();

        //Проверка имени пользователя
        headerForm.checkUsername(username);
    }
}
