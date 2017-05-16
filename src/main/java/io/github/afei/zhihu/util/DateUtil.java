package io.github.afei.zhihu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by afei on 2016/10/8.
 */
public class DateUtil {

    public static String parse(String date){
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            return formater2.format(formater.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
