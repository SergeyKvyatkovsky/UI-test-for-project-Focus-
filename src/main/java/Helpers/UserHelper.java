package Helpers;

import Helpers.ParamReader;

public class UserHelper {

    public static String getUsername(String user){
        System.out.println(ParamReader.getParameterByXpath(ParamReader.users, "//user[@name='"+ user +"'][1]/username[1]/text()"));
        return ParamReader.getParameterByXpath(ParamReader.users, "//user[@name='"+ user +"'][1]/username[1]/text()");
    }

    public static String getPassword(String user){
        return ParamReader.getParameterByXpath(ParamReader.users, "//user[@name='"+ user +"']/password/text()");
    }

}
