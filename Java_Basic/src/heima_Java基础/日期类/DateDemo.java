package heima_Java基础.日期类;

import java.util.Date;

/**
 * @version v1.0
 * @ClassName: DateDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class DateDemo {
    public static void main(String[] args) {
        //1. date日期对象
        Date d = new Date();
        System.out.println(d);//Sat Feb 26 11:31:17 CST 2022

        //2. 获取时间毫秒值
        long time1 = d.getTime();
        System.out.println(time1);

        System.out.println("=========");

        //将当前时间进行输出
        Date d1 = new Date();
        System.out.println(d1);

        //3. 得到当前时间毫秒值，往后走1小时121秒
        long time2 = System.currentTimeMillis();
        time2 += (60*60+121)*1000;
        //将时间毫秒值转化为对应的日期对象
        Date d2 = new Date(time2);
        System.out.println(d2);

        //时间毫秒值回复为日期对象
        Date d3 = new Date();
        d3.setTime(time2);
        System.out.println(d3);
    }
}
