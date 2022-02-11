package heima_DesignPattern.创建者模式.单例.JDK源码_Runtime类;

import java.io.IOException;
import java.io.InputStream;

/**
 * @version v1.0
 * @ClassName: RuntimeDemo
 * @Description: 测试Runtime
 * @Author: Orange
 **/
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        //获取Runtime对象，只能通过静态方法
        Runtime runtime = Runtime.getRuntime();

        //调用runtime方法exec，参数要的是一个命令
        Process process = runtime.exec("ipconfig");

        //调用process的获取输入流的方法
        InputStream is = process.getInputStream();
        byte[] arr = new byte[1024*1024*1024];

        //读取数据，返回值为读到的字节的个数
        int len = is.read(arr);

        //将字节数组转换为字符串然后输出到控制台
        System.out.println(new String(arr, 0,len,"GBK"));
    }
}
