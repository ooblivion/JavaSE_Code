package heima_Java基础.String案例;

import java.util.Random;

/**
 * @version v1.0
 * @ClassName: StringDemo1
 * @Description: 模拟随机验证码
 * @Author: Orange
 **/
public class StringDemo1 {
    public static void main(String[] args) {
        //定义可能出现的字符信息
        String data = "a...A...0...";

        //循环5次，每次生成一个随机索引，提取对应的字符串连接起来即可
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(data.length());
            char c = data.charAt(index);
            code+=c;
        }

        //输出字符串变量即可
        System.out.println(code);
    }
}
