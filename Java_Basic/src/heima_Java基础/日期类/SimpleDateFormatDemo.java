package heima_Java基础.日期类;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version v1.0
 * @ClassName: SimpleDateFormatDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        //构造器1
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        //将日期对象转换为规定的字符串形式
        String s1 = sdf1.format(d1);
        System.out.println(s1);

        //格式化为时间毫秒值，获取121秒后的时间
        long time1 = System.currentTimeMillis() + 121*1000;
        String s2 = sdf1.format(time1);
        System.out.println(s2);

        //SimpleDateFormat解析字符串时间为日期对象


        //构造器2

        //格式化方法1 将日期格式化成日期/时间字符串

        //格式化方法2 将时间毫秒值格式化成日期/时间字符串
    }
}
/*
* y 年
* M 月
* d 日
* H 时
* m 分
* s 秒
* EEE 星期几
* a 上午or下午
* 2022-11-11 13:12:09 -> yyyy-MM-dd HH:mm:ss
* */