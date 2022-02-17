package heima_Java基础.面向对象.枚举.枚举的使用;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
//用枚举做信息标识和分类，可读性好，约束强，严谨
public class Demo {
    public static void main(String[] args) {
        move(Flag.UP);
    }

    public static void move(Flag f){
        //控制移动
        switch (f){
            case UP:
                System.out.println("up");
                break;
            case DOWN:
                System.out.println("down");
                break;
            case LEFT:
                System.out.println("left");
                break;
            case RIGHT:
                System.out.println("right");
                break;
        }
    }
}

