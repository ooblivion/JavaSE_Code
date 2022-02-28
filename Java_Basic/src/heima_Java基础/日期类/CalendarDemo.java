package heima_Java基础.日期类;

import java.util.Calendar;

/**
 * @version v1.0
 * @ClassName: CalendarDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CalendarDemo {
    public static void main(String[] args) {
        //1. 拿到系统子类对象
        Calendar rightNow = Calendar.getInstance();//内部返回子类对象
        System.out.println(rightNow.get(12));

        //2. 获取日历信息

        //3. set(int field, int amount) 修改日历的某个字段信息

        //4. add(int field, int amount) 为某个字段增加/减少指定的值
    }
}
