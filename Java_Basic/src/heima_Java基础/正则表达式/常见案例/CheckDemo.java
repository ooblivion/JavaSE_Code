package heima_Java基础.正则表达式.常见案例;

import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: CheckDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CheckDemo {
    public static void main(String[] args) {
        checkEmail();
    }

    public static void checkEmail(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入邮箱号码：");
            String email = scanner.next();
            //23432453@qq.com
            //214324532@163.com
            //4365243ds4325@pci.com.cn
            if(email.matches("\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("邮箱格式正确");
                break;
            }else {
                System.out.println("邮箱格式有误");
            }
        }
    }

    //判断手机号码
    public static void checkPhone(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("请输入手机号");
            String phone = scanner.next();
            //判断手机号是否正确
            if(phone.matches("1[3-9]\\d{9}")){
                System.out.println("手机号格式正确");
                break;
            }else {
                System.out.println("手机号格式错误");
            }
        }
    }
}
