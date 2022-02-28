package heima_Java基础.动态代理.V2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version v1.0
 * @ClassName: ProxyUtil
 * @Description: 生成业务对象的代理对象，以后所有功能先走代理
 * @Author: Orange
 **/
public class ProxyUtil {
    public static UserService getProxy(UserServiceImpl userService) {
        //传入的参数分别是类加载器，实现的接口，核心处理
        return (UserService) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTimer = System.currentTimeMillis();

                        //马上触发真正代码的执行
                        Object result = method.invoke(userService, args);
                        long endTimer = System.currentTimeMillis();
                        System.out.println(method.getName()+"方法耗时"+(endTimer-startTimer)/1+"s");
                        return null;
                    }
                }
        );
    }
}
