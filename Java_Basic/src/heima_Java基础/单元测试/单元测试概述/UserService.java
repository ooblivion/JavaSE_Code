package heima_Java基础.单元测试.单元测试概述;

/**
 * @version v1.0
 * @ClassName: UserService
 * @Description: 业务方法，用用户名和密码登录
 * @Author: Orange
 **/
public class UserService {
    public String loginNme(String loginName, String passwd) {
        if ("admina".equals(loginName) && "123456".equals(passwd))
            return "登录成功";
        else
            return "用户名或密码有问题";
    }

    public void selectNames(){
        System.out.println(10/1);
        System.out.println("查询全部用户名称成功");
    }
}
