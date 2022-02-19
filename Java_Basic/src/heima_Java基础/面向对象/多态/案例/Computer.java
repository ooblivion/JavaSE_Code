package heima_Java基础.面向对象.多态.案例;

/**
 * @version v1.0
 * @ClassName: Computer
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Computer {
    public void installUSB(USB u){
        if(u instanceof KeyBoard){
            KeyBoard k = (KeyBoard) u;
            k.input();
            k.write();
            k.output();
        }else if (u instanceof Mouse){
            Mouse m = (Mouse) u;
            m.input();
            m.click();
            m.output();
        }
    }
}
