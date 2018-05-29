package TradesBlotter;

import Core.ITest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHttp extends ITest {
    @Title("Создание журнала сделок")
    @Test(priority = 1)
    public void RequestXML() throws IOException, InterruptedException {

//        String url = "http://alfa-limits.egar.egartech.com/limitsmanager/auth.do";
        String url = "http://alfa-limits.egar.egartech.com/limitsmanager/console/";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
       // con.setRequestProperty(username, "s.kviatkovsky");
        //con.setRequestProperty(password, "etpoN7VV");
        //assertEquals(HttpURLConnection.HTTP_OK,con.getResponseCode());
        System.out.println(con.getResponseCode());
        String urlParameters = "username=s.kviatkovsky&password=etpoN7VV";
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
        con.connect();

        DataInputStream dataInputStream = new DataInputStream(con.getInputStream());
        char s = (dataInputStream.readChar());
        System.out.println(s);


        // Send post request
       // con.setDoOutput(true);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        //------------------------------------------------------------------------
        String urlTwo = "http://alfa-limits.egar.egartech.com/limitsmanager/console/data/method";
        URL objTwo = new URL(urlTwo);
        HttpURLConnection conTwo = (HttpURLConnection) objTwo.openConnection();
        conTwo.setRequestMethod("POST");
        conTwo.setDoOutput(true);
        conTwo.setDoInput(true);
        // con.setRequestProperty(username, "s.kviatkovsky");
        //con.setRequestProperty(password, "etpoN7VV");
        //assertEquals(HttpURLConnection.HTTP_OK,con.getResponseCode());
        System.out.println(conTwo.getResponseCode());
        String urlParametersTwo = "{\"action\":\"LimitServer\",\"method\":\"saveDictionaryRecord\",\"data\":{\"record_data\":{\"record_id\":null,\"dict_name\":\"CPGR\",\"fields\":{\"Id\":null,\"Name\":\"nafvdppmdtzifjgbwycaahgs\",\"ExternalId\":\"gaqbmstvatdkdkctqitdoyyt\"}}},\"type\":\"rpc\",\"tid\":1}";
//        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//        wr.writeBytes(urlParameters);
//        wr.flush();
//        wr.close();
        conTwo.connect();

        DataInputStream dataInputStreamTwo = new DataInputStream(conTwo.getInputStream());
//        char sTwo = (dataInputStreamTwo.readChar());
//        System.out.println(sTwo);


        // Send post request
        // con.setDoOutput(true);

        int responseCodeTwo = conTwo.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParametersTwo);
        System.out.println("Response Code : " + responseCode);

        BufferedReader inTwo = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLineTwo;
        StringBuffer responseTwo = new StringBuffer();

        while ((inputLineTwo = inTwo.readLine()) != null) {
            responseTwo.append(inputLineTwo);
        }
        inTwo.close();

        //print result
        System.out.println(responseTwo.toString());




    }






 /*       StringBuilder sb = new StringBuilder();
        sb.append("username=s.kviatkovsky&password=etpoN7VV");


        String body = sb.toString();
        byte[] buffer = new byte[body.length()];
        try {
            buffer = sb.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        URL u = new URL("http://alfa-limits.egar.egartech.com/limitsmanager/auth.do");
        URLConnection uc = u.openConnection();
        HttpURLConnection connection = (HttpURLConnection) uc;

        HttpPost.METHOD_NAME*/
    }


