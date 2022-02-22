package heima_Java基础.异常.自定义异常.自定义编译时异常;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Demo extends Exception{
    public Demo(){}

    public Demo(String message) {
        super(message);
    }
}
