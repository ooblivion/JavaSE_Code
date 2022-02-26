package heima_Java基础.日期类.获取给定时间往后一段时间是多少;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version v1.0
 * @ClassName: Demo1
 * @Description:
 * @Author: Orange
 **/
public class Demo1 {
    public static void main(String[] args) throws ParseException {
        //需求：计算出2021年8月06日11时11分11秒，往后2天14小时49分06秒后的时间
        //目标：学会使用SimpleDateFormat解析字符串时间称为日期对象

        //1. 将字符串拿到程序中
        String dateStr = "2021年8月06日 11:11:11";

        //2. 将字符串时间解析为日期对象，形式必须与解析时间完全一样，否则会报错
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d1 = sdf.parse(dateStr);
        System.out.println(sdf.format(d1));

        //3. 往后走指定时间
        long time = d1.getTime() + (2L*24*60*60 + 14*60*60 +49*60 +9)*1000;

        //4. 格式化这个时间毫秒值
        System.out.println(sdf.format(time));
    }
}
