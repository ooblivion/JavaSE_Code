package heima_Java基础.动态代理.V2;
/**
 * @version v1.0
 * @ClassName: UserServiceImpl
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class UserServiceImpl implements UserService {
    @Override
    public String login(String loginName, String passWord) {
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }
        if("admin".equals(loginName) && "1234".equals(passWord)){
            return "登录成功";
        }
        return "登录名或密码可能错误";

    }

    @Override
    public void selectUser() {
        System.out.println("查询100个用户");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteUsers() {
        try {
            System.out.println("删除100个用户");
            Thread.sleep(500);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
