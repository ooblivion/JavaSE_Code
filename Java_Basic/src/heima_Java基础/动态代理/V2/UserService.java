package heima_Java基础.动态代理.V2;

/**
 * @version v1.0
 * @InterfaceName: UserService
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public interface UserService {
    //用户登录
    String login(String loginName, String passWord);
    //选择用户
    void selectUser();
    //删除用户
    boolean deleteUsers();
}
