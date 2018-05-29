package TradesBlotter;

import Core.ITest;
import Intagration.IntagrationMethods;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class TestMethod  extends ITest {
    @Title("Создание журнала сделок")
    @Test(priority = 1)
    public void createTradesBlotter() throws IOException, InterruptedException, URISyntaxException {

   //     String urlt = "http://alfa-limits.egar.egartech.com/limitsmanager"; //;jsessionid=7348ED965850C606A946E0B0A012B791    --http://alfa-limits.egar.egartech.com/limitsmanager/console/
   //     HttpURLConnection connection = (HttpURLConnection) new URL(urlt).openConnection();

        IntagrationMethods intagrationMethods = new IntagrationMethods();

        URL myUrl = new URL("http://alfa-limits.egar.egartech.com/limitsmanager/auth.do;jsessionid=3477792021E851E6188A8C247EDCD604");
        HttpURLConnection myUrlCon =
                (HttpURLConnection) myUrl.openConnection();

        String s = intagrationMethods.logout(myUrlCon);
        intagrationMethods.login(s);

        //intagrationMethods.logout(connection);
       // String s = intagrationMethods.httprequestTest(connection);
      //  System.out.println(s + ": Tokin для передачи");
      //  System.out.println("Всё");
       // intagrationMethods.HttpRequestPartTwo(s,connection);
        //connection.disconnect();
    }
}
