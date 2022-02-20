package heima_Java基础.常用API.Objects;

import java.util.Objects;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = new String("heima");
        //System.out.println(s1.equals(s2));//留下了隐患，可能发生空指针异常
        System.out.println(Objects.equals(s1,s2));//false

        System.out.println(Objects.isNull(s1));//true
        System.out.println(Objects.isNull(s2));//false
    }
}
