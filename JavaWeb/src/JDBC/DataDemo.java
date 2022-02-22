package JDBC;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @version v1.0
 * @ClassName: DataDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class DataDemo {
    public static void main(String[] args) {
        DataDemo d = new DataDemo();
        d.testZoneDateTime();
    }
    public void testZoneDateTime() {
        //获取当前时间
        ZonedDateTime data1 = ZonedDateTime.parse("2022-12-02T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("data1: "+data1);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: "+id);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区："+currentZone);
    }
}
