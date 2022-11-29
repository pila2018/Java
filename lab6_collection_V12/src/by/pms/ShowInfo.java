package by.pms;

import java.util.List;

public class ShowInfo {
    public static void showInfo(List<Object> list){
        for(var s : list){
            System.out.println(s.toString());
        }
        System.out.println("\n");
    }
}
