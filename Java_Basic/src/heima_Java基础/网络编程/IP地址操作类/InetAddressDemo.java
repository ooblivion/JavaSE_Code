package heima_Java基础.网络编程.IP地址操作类;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version v1.0
 * @ClassName: InetAddressDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class InetAddressDemo {
    public static void main(String[] args) throws IOException {
        //1. 获取本机地址对象
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostName());//DESKTOP-0C4LKHU
        System.out.println(ip1.getHostAddress());//169.254.43.138

        //2. 获取域名ip对象
        InetAddress ip2 = InetAddress.getByName("www.github.com");
        System.out.println(ip2.getHostName());//www.github.com
        System.out.println(ip2.getHostAddress());//20.205.243.166

        //3. 获取公网ip对象
        InetAddress ip3 = InetAddress.getByName("20.205.243.166");
        System.out.println(ip3.getHostName());//20.205.243.166
        System.out.println(ip3.getHostAddress());//20.205.243.166

        //4. 判断在规定时间内是否能联通 ping 20s
        System.out.println(ip3.isReachable(20000));//false
    }
}
