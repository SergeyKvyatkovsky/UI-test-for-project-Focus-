package TradesBlotter;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReaquestHTTPTest {
    @Title("Создание журнала сделок")
    @Test(priority = 1)
 //   String tokinID = null;

    public String httprequestTest (String tokinID) {
        String url = "http://alfa-limits.egar.egartech.com/limitsmanager/"; //;jsessionid=7348ED965850C606A946E0B0A012B791
        HttpURLConnection connection = null;
        //   String tokenID = "";
        //    String urlParameters  = "param1=a&param2=b&param3=c";
        //     byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );

     //   String tokenID = null;
        String tokenID = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);


            connection.setUseCaches(true);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            JSONObject auth = new JSONObject();
            auth.put("username", "s.kviatkovsky");
            auth.put("password", "etpoN7VV");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
            outputStreamWriter.write(auth.toString());

            int responseCode = connection.getResponseCode();

            connection.connect();


            StringBuilder stringBuilder = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                System.out.println(responseCode);
                String answer;

                while ((answer = in.readLine()) != null) {
                    stringBuilder.append(answer);
                    stringBuilder.append("/n");
                    System.out.println(stringBuilder.toString());
                }

            } else {
                System.out.println("fail" + "/" + connection.getResponseCode() + "/" + connection.getResponseMessage());

            }
            String responsMessageSplit = String.valueOf(stringBuilder);
            System.out.println(responsMessageSplit);
            String[] s = responsMessageSplit.split("jsessionid=");
            String[] sTwo = s[1].split("\"", 2);
            System.out.println(s[1]);
            System.out.println(sTwo[0]);
            tokenID = String.valueOf(sTwo[0]);
         //   tokenIDBuff = tokenID;
         //   System.out.println(tokenIDBuff);
            System.out.println(tokenID);

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            return tokenID;
        }


    }





}
