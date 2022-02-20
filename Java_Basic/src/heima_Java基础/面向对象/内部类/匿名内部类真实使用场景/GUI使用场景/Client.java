package heima_Java基础.面向对象.内部类.匿名内部类真实使用场景.GUI使用场景;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //1. 创建窗口
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();
        win.add(panel);

        //2. 创建一个按钮对象
        JButton btn = new JButton("登录");

        //注意：匿名内部类使用
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(win, "点你一下");
//            }
//        });
        //lambda表达式简化
        btn.addActionListener(e -> JOptionPane.showMessageDialog(win,"哈哈"));

        //3. 把按钮对象添加到桌布展示
        panel.add(btn);

        //4. 展示窗口
        win.setSize(400, 300);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
    }
}
