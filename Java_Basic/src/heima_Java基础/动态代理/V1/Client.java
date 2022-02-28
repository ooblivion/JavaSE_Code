package heima_Java基础.动态代理.V1;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.login("admin", "1234"));
        System.out.println(userService.deleteUsers());
        userService.selectUser();
        //有点像模板设计模式？存在大量重复代码

//        //将业务对象做成代理对象返回，代理对象的类型也是UserService
//        UserService userServiceProxy = ProxyUtil.getProxy(new UserServiceImpl());

    }
}
