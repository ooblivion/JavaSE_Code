package heima_Java基础.正则表达式.匹配规则;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Demo {
    public static void main(String[] args) {
        //四位数验证码
        String s1 = "1ws2";
        String s2 = "ss_1";
        String regex1 = "[a-zA-Z0-9]{4}";
        String regex2 = "[\\w && ^_]{4}";
        String regex3 = "[\\w && [^_]]{4}";
        System.out.println(s1.matches(regex1));//true
        System.out.println(s1.matches(regex2));//false ? 有问题 在[]中排除必须用[]
        System.out.println(s1.matches(regex3));//true
        System.out.println("===");
        System.out.println(s2.matches(regex1));//false
        System.out.println(s2.matches(regex2));//false
        System.out.println(s2.matches(regex3));//false
    }
}
