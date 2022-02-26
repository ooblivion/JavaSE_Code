package heima_Java基础.日期类.案例之秒杀活动;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) throws ParseException {
        //1. 开始和结束时间
        String beginTime = "2022-11-11 00:00:00";
        String endTime = "2022-11-11 00:10:00";

        //2. 两位用户分别在不同时间购买

        String client1 = "2022-11-11 00:02:00";
        String client2 = "2022-11-11 00:12:00";

        //3. 解析客户的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin = sdf.parse(beginTime);
        Date end = sdf.parse(endTime);


    }
}
