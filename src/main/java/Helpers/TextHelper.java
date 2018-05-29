package Helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHelper {

    public static String getNumberFromString(String text){
        String number = null;
        Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
        {
            number = matcher.group();
        }

        return number;
    }

}
