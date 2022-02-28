package heima_Java基础.动态代理.V2;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {

    public static void main(String[] args) {
        UserService userService = ProxyUtil.getProxy(new UserServiceImpl());
        System.out.println(userService.login("admin","1234"));
        System.out.println(userService.deleteUsers());
        userService.selectUser();
    }

}
