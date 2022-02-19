package JavaGuide.获取键盘输入;

import java.util.Scanner;

/**
 * @version v1.0
 * @ClassName: ScannerDemo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        input.close();
        System.out.println(s);
    }
}
