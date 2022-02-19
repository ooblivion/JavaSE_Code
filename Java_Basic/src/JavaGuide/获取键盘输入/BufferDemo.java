package JavaGuide.获取键盘输入;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @version v1.0
 * @ClassName: BufferDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class BufferDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        System.out.println(s);
    }
}
