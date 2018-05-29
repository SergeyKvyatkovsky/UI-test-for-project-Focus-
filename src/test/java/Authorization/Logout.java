package Authorization;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;

@Title("Logout")
@Test
public class Logout extends ITest{

    public void logout() throws IOException, InterruptedException {
        navigateTo(url);

        loginPage.authorization(username, password);
        mainFrame.waitForHideLoading();

        headerForm.logout();
        loginPage.waitForSubmit();

    }

}
