package heima_Java基础.正则表达式.入门案例;

/**
 * @version v1.0
 * @ClassName: RegQQDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class RegQQDemo {
    //校验QQ号码，必须全部数字6~20个
    public static void main(String[] args) {
        System.out.println(checkQQ("3255dwf332"));//false
        System.out.println(checkQQ("325332432"));//true

        System.out.println("===");

        System.out.println(regCheckQQ("3255dwf332"));//false
        System.out.println(regCheckQQ("325332432"));//true
    }

    public static boolean regCheckQQ(String qq){
        return qq != null && qq.matches("\\d{6,20}");
    }

    public static boolean checkQQ(String qq){
        //1. 判断qq号码的长度是否满足要求
        if(qq == null || qq.length() < 6 || qq.length() >20){
            return false;
        }
        //判断qq中是否全是数字，不是返回false
        //3243215we12
        for (int i = 0; i < qq.length(); i++) {
            //获取每个字符
            char ch = qq.charAt(i);
            //判断这个字符是否不是数字，不是数字直接返回false
            if(ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}
