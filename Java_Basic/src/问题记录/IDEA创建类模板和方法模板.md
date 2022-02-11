写代码是少不了注释的，但是自带的注释就几个，所以使用注释模板添加自定义的注释是个非常好用的功能

### 创建[类模板](https://so.csdn.net/so/search?q=类模板&spm=1001.2101.3001.7020)

1. 按照顺序打开**File–>settings–>Editor–>File and Code Templates–>Includes**
2. 输入类注释模板

```
/**
 * @Classname ${NAME}
 * @Description TODO
 * @Date ${DATE} ${TIME}
 * @Created by ${USER}
 */123456
```

![这里写图片描述](https://img-blog.csdn.net/20180816224225785?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
\3. 结果：
![这里写图片描述](https://img-blog.csdn.net/20180816224329154?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

### 创建方法模板

1. 按照顺序打开**File–>Settings–>Editor–>Live Templates**
2. 点击右边的”**+**“号,选择**Template Group**
   ![这里写图片描述](https://img-blog.csdn.net/20180816224702293?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
3. 创建自己的组名
   ![这里写图片描述](https://img-blog.csdn.net/20180816224810638?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
4. 选择自己的组名，点击”+”号，选择Live Template
   ![这里写图片描述](https://img-blog.csdn.net/20180816224923385?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
5. 填写Abbreviation，Description，Template text
   ![这里写图片描述](https://img-blog.csdn.net/20180816225511122?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
   点击 Define 选择java，也可以选择everywhere
   ![这里写图片描述](https://img-blog.csdn.net/20180816225859234?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
6. 设置Edit variables
   ![这里写图片描述](https://img-blog.csdn.net/20180816230033906?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
   选择相对应的方法就可以了，点击ok，ok
   ***注意这里使用的是tab 的方式使用注释模板\***
   ![这里写图片描述](https://img-blog.csdn.net/20180816230227437?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
7. 示例
   ![这里写图片描述](https://img-blog.csdn.net/20180816230535964?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
   ![这里写图片描述](https://img-blog.csdn.net/20180816230603950?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

###### 优化参数显示方式

这种数组显示很别扭，所以执行一下这个操作就可以了
![这里写图片描述](https://img-blog.csdn.net/20180816235350148?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

```
groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {if(params[i] == '') return result;if(i==0) result += '\\n'; result+=' * @param ' + params[i] + ((i < params.size() - 1) ? '\\n' : '')}; return result", methodParameters()) 1
```

![这里写图片描述](https://img-blog.csdn.net/20180816235418435?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NkdXQ0MDY=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



```
**建议换成这个，不然第一行会多出来一个空白的* 
@param 
groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {if(params[i] == '') continue;if(i==0) result += params[0]+((params.size()==1)?'':'\\n');else{ result+=' * @param ' + params[i] + ((i < params.size() - 1) ? '\\n' : '')}}; return result", methodParameters())
```





---



# [Idea使用方式——创建类模板 ](https://www.cnblogs.com/jason0529/p/13606595.html)

> 问题：创建类或接口时，要添加自定义的默认注释，比如版本，时间等。每个类修改显然不符合程序员的思路，有没有办法通过定义模板来实现？

## 使用Idea模板

Idea可听过创建类模板来实现。
功能路径：Setting -> Editor -> File and Code Template -> Class 修改，右侧文件内容
![img](https://img2020.cnblogs.com/blog/465508/202009/465508-20200903110904085-1708698254.png)

## 模板内容

**${}变量标识变量注入**

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")
package ${PACKAGE_NAME};   // 解决package
#end
#parse("File Header.java")
// 默认导入lombok，方便日志打印
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**  
    * @Title: ${NAME}      // 默认是类名称 
    * @Description:        // 类实现的介绍
    * @author: libo        //  作者
    * @date: ${DATE} ${TIME} // 创建时间，${DATE} 自动注入系统日期，${TIME}自动注入当天时间，分钟
    * @Version: 1.0         //版本
    */
@Slf4j
public class ${NAME} {
}
```

### 系统变量类型

|                     |                                                              |
| ------------------- | ------------------------------------------------------------ |
| ${PACKAGE_NAME}     | name of the package in which the new class is created        |
| ${NAME}             | name of the new class specified by you in the Create New Class dialog |
| ${USER}             | current user system login name                               |
| ${DATE}             | current system date                                          |
| ${TIME}             | current system time                                          |
| ${YEAR}             | current year                                                 |
| ${MONTH}            | current month                                                |
| ${MONTH_NAME_SHORT} | first 3 letters of the current month name. Example: Jan, Feb, etc. |
| ${MONTH_NAME_FULL}  | full name of the current month. Example: January, February, etc. |
| ${DAY}              | current day of the month                                     |
| ${HOUR}             | current hour                                                 |
| ${MINUTE}           | current minute                                               |
| ${PROJECT_NAME}     | the name of the current project                              |

## 效果

新建一个类，Test
![img](https://img2020.cnblogs.com/blog/465508/202009/465508-20200903111124210-1539180625.png)

> 通过定义模板，可以完全自定义自己的类注释

