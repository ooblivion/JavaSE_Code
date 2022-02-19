package heima_Java基础.单元测试.单元测试概述;

import org.junit.Assert;
import org.junit.Test;

/**
 * @version v1.0
 * @ClassName: TestUserService
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class TestUserService {
    //测试方法
    //注意点
    //  1. 必须是公开，无参数，无返回值
    //  2. 测试方法必须用@Test注解标记
    @Test
    public void testLoinName(){
        UserService userService = new UserService();
        String rs = userService.loginNme("admin", "123456");

        //预期结果的正确性测试：断言
        Assert.assertEquals("您的功能业务数据可能出现问题", "登录成功", rs);
    }

    @Test
    public void testSelectNames(){
        UserService userService = new UserService();
        //该方法没有返回值，不需要断言
        userService.selectNames();
    }
}
