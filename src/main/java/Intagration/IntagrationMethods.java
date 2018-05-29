package Intagration;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntagrationMethods {
    URL myUrl = new URL("http://alfa-limits.egar.egartech.com/limitsmanager/auth.do;jsessionid=3477792021E851E6188A8C247EDCD604");
    HttpURLConnection myUrlCon =
            (HttpURLConnection) myUrl.openConnection();

    public IntagrationMethods() throws IOException {
    }


    public String logout(HttpURLConnection myUrlCon) throws IOException {

        String s = null;
        String e = null;

        CookieManager manager = new CookieManager();
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(manager);


        myUrlCon.setRequestMethod("GET");
        myUrlCon.setInstanceFollowRedirects(true);
        myUrlCon.setDefaultUseCaches(true);
        myUrlCon.getContent();
        CookieStore cookieJar =  manager.getCookieStore();
        List <HttpCookie> cookies =
                cookieJar.getCookies();
        for (HttpCookie cookie: cookies) {
            System.out.println("CookieHandler retrieved cookie: " + cookie);
        }
        // Вывести метод запроса


        System.out.println("Метод запроса: " +
                myUrlCon.getRequestMethod());

        // Вывести код ответа

        System.out.println("Ответное сообщение: " +
                myUrlCon.getResponseMessage());

        // Получить список полей и множество ключей из заголовка

        Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
        Set<String> myField = myMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        // Вывести все ключи и значения из заголовка
        for(String k : myField) {
            System.out.println("Ключ: " + k + " Значение: "
                    + myMap.get(k));
        }


        String[] buff = myUrlCon.getHeaderField(2).split("=",2);
        String[] buffstepTwo = buff[1].split(";",2);
        s = buffstepTwo[0];

        return s;
    }


    public void login(String s) throws IOException, URISyntaxException {

        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        CookieStore cookieJar =  manager.getCookieStore();

        // create cookie
        HttpCookie cookie = new HttpCookie("JSESSIONID", s);


        String url = "http://alfa-limits.egar.egartech.com/limitsmanager/auth.do=" + s;
        System.out.println(url);
        URL myUrl = new URL(url);

        cookieJar.add(myUrl.toURI(), cookie);
        System.out.println("Added cookie using cookie handler");

        HttpURLConnection myUrlCon =
                (HttpURLConnection) myUrl.openConnection();
      //      myUrlCon = (HttpURLConnection) myUrl.openConnection();
        System.out.println("Значение которое передалось в метод: " + s);

        myUrlCon.setRequestMethod("POST");
        myUrlCon.setDoOutput(true);
        myUrlCon.setInstanceFollowRedirects(true);
        myUrlCon.setDefaultUseCaches(true);
        // Вывести метод запроса


        myUrlCon.setRequestProperty("JSESSIONID",s);
      //  myUrlCon.setRequestProperty("Path","/limitsmanager");


        JSONObject maint = new JSONObject();
        maint.put("username", "s.kviatkovsky");
        maint.put("password","etpoN7VV");

      //  System.out.println(maint);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(myUrlCon.getOutputStream(), "utf-8");
        System.out.println("Json который передаётся в методе с логином и паролем:" + maint.toString());
        outputStreamWriter.write(maint.toString());



        System.out.println("Метод запроса: " +
                myUrlCon.getRequestMethod());

        // Вывести код ответа
        System.out.println("Сравни "+ myUrlCon.getHeaderField(2));
        System.out.println("Ответное сообщение: " +
                myUrlCon.getResponseMessage());

        // Получить список полей и множество ключей из заголовка

        Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
        Set<String> myField = myMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        // Вывести все ключи и значения из заголовка
        for(String k : myField) {
            System.out.println("Ключ: " + k + " Значение: "
                    + myMap.get(k));
        }
        System.out.println(myUrlCon.getHeaderField(2));
        System.out.println(myUrlCon.getResponseCode());
        System.out.println(myUrlCon.getResponseMessage());
        StringBuilder stringBuilder = new StringBuilder();

        if (HttpURLConnection.HTTP_OK == myUrlCon.getResponseCode()) {
            BufferedReader in = new BufferedReader(new InputStreamReader(myUrlCon.getInputStream()));
            String answer;

            while ((answer = in.readLine()) != null) {
                stringBuilder.append(answer);
                stringBuilder.append("/n");

            }

        } else {
            System.out.println("fail" + "/" + myUrlCon.getResponseCode() + "/" + myUrlCon.getResponseMessage());
        }
        System.out.println(stringBuilder);
    }


    public String httprequestTest () {
        String urlt = "http://alfa-limits.egar.egartech.com/limitsmanager/console/"; //;jsessionid=7348ED965850C606A946E0B0A012B791
        HttpURLConnection connection = null;
        String tokenID = null;
        try {
            connection = (HttpURLConnection) new URL(urlt).openConnection();
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
                //    System.out.println(stringBuilder.toString());
                }

            } else {
                System.out.println("fail" + "/" + connection.getResponseCode() + "/" + connection.getResponseMessage());
            }
            String responsMessageSplit = String.valueOf(stringBuilder);
          //  System.out.println(responsMessageSplit);
            String[] s = responsMessageSplit.split("jsessionid=");
            String[] sTwo = s[1].split("\"", 2);
      //      System.out.println(s[1]);
      //      System.out.println(sTwo[0]);
            tokenID = String.valueOf(sTwo[0]);

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

            return tokenID;

        }




    }

    public String HttpRequestPartTwo(String TokinID) {
        String s = null;
        String url = "http://alfa-limits.egar.egartech.com/limitsmanager/console/data/method"; //;jsessionid=7348ED965850C606A946E0B0A012B791
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setUseCaches(true);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            JSONObject params_one = new JSONObject();
            params_one.put("name", "useRiskFactors");
            params_one.put("value","false");
            params_one.put("name", "includeReverseRepo");
            params_one.put("value","true");
            params_one.put("name", "includeAI");
            params_one.put("value","true");

          //  JSONObject params_two = new JSONObject();
          //  params_two.put("name", "includeReverseRepo");
          //  params_two.put("value","true");

          //  JSONObject params_three = new JSONObject();
          //  params_three.put("name", "includeAI");
          //  params_three.put("value","true");


            JSONObject limit_data_params = new JSONObject();
            limit_data_params.put("id", "0");
            limit_data_params.put("type","OPA");
            limit_data_params.put("name", "TestCat2");
            limit_data_params.put("own_value","3");
            limit_data_params.put("value", " ");
            limit_data_params.put("condition", "LE");
            limit_data_params.put("value_currency_code","USD");
            limit_data_params.put("kind", "R");
            limit_data_params.put("is_required", "true");
            limit_data_params.put("is_enabled", "true");
            limit_data_params.put("status", "U");
            limit_data_params.put("is_recalculate_on_trades", "true");
            limit_data_params.put("is_recalculate_on_bod", "false");
            limit_data_params.put("recalculation_timer_id", "null");
            limit_data_params.put("is_use_parent_recalculation_timer", "true");
            limit_data_params.put("current_own_value", "");
            limit_data_params.put("current_value", "");
            limit_data_params.put("comment", "");
            limit_data_params.put("category_id", "41");
            limit_data_params.put("is_deleted", "false");
            limit_data_params.put("auto_reauthorization_policy", "A");
            limit_data_params.put("has_right", "true");
            limit_data_params.put("message", "null");
            limit_data_params.put("recalculation_timer_name", "");
            limit_data_params.put("category_name", "TestCat2");
            limit_data_params.put("category_path", "/37/41");
            limit_data_params.put("category_display_path", "/ Auto QA / TestCat2");
            limit_data_params.put("category_is_recalculate_on_bod", "false");
            limit_data_params.put("category_recalculation_timer_name", "Раз в 10 минут по будням");
            limit_data_params.put("life_state", "A");
            limit_data_params.put("start_date", "2017-11-15T00:00:00");
            limit_data_params.put("end_date", "null");
            limit_data_params.put("last_recalculation_datetime", "null");
            limit_data_params.put("filters","" );
            limit_data_params.put("master_limit_links","" );
            limit_data_params.put("slave_limit_links","" );
            limit_data_params.put("chkIncludeReverseRepo-checkboxfield-1525-inputEl", "true");
            limit_data_params.put("chkIncludeAI-checkboxfield-1526-inputEl", "true");
            limit_data_params.put("parameters",params_one);



            JSONObject data_params = new JSONObject();
            data_params.put("limit_data",limit_data_params);

            JSONObject main = new JSONObject();
            main.put("action", "LimitServer");
            main.put("method","saveLimit");
            main.put("data", data_params);
            main.put("type", "rpc");
            main.put("tid", "1");


            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
            System.out.println(main.toString());
            outputStreamWriter.write(main.toString());

            int responseCode = connection.getResponseCode();

            connection.connect();


            StringBuilder stringBuilder = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String answer;
                System.out.println(responseCode);

                while ((answer = in.readLine()) != null) {
                    stringBuilder.append(answer);
                    stringBuilder.append("/n");

                }

            } else {
                System.out.println("fail" + "/" + connection.getResponseCode() + "/" + connection.getResponseMessage());
            }

        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

            return s;
        }


    }
}
