package heima_Java基础.动态代理.V1;

/**
 * @version v1.0
 * @ClassName: UserServiceImpl
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class UserServiceImpl implements UserService{
    public static int TIME = 1;
    @Override
    public String login(String loginName, String passWord) {
        long startTimer = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
            if("admin".equals(loginName) && "1234".equals(passWord)){
                return "登录成功";
            }
            return "登录名或密码可能错误";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        } finally {
            long endTimer = System.currentTimeMillis();
            System.out.println("login耗时："+(endTimer-startTimer)/TIME+"s");
        }
    }

    @Override
    public void selectUser() {
        long startTimer = System.currentTimeMillis();
        System.out.println("查询100个用户");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("查询耗时："+(endTimer-startTimer)/TIME+"s");
    }

    @Override
    public boolean deleteUsers() {
        long startTimer = System.currentTimeMillis();
        try {
            System.out.println("删除100个用户");
            Thread.sleep(500);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            long endTimer = System.currentTimeMillis();
            System.out.println("删除耗时："+(endTimer-startTimer)/TIME+"s");
        }
    }
}
