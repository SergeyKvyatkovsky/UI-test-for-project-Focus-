package Helpers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Класс для сортировки
public class SortHelper {

    //Сортировка листа по возрастанию
    public static List<String> sortListAsc(List<String> list){
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    //Сортировка листа по убыванию
    public static List<String> sortListDesc(List<String> list){
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return list;
    }

}
