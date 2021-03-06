## 1. 引言

  团队开发时，业务模块分配的越清晰，代码注释管理越完善，越有利于后面维护，后面再管理也方便不少。另外也起着"文字砖"的作用，你懂的。注释不需要很详细，把代码块方法块功能简述一下就行。不然三月后回头看就要骂人了，骂完发现是自己写的，啧啧啧...

  三种常用的 Java 注释方式

```java
    // 声明常量
    int number;
    /*
     * 类主函数
     */
    public static void main(String[] args) {
    }
    /**
     * @param masterId    品牌商Id
     * @param shopId    店铺Id
     * @param skuId        商品skuId
     * @description: 校验商品标识码与店铺的所属关系
     * @return: net.jdcloud.APIECRM.model.ValidateSkuUsingGETResponse
     * @author: niaonao
     * @date: 2020/01/13
     */
    public static ValidateSkuUsingGETResponse validateSkuUsing(String masterId, String shopId, String skuId){
        return null;
    }
```

## 2. 自定义注释模板

### 2.1 类注释模板

#### 2.1.1 配置模板

  菜单路径 File-Settings-Editor-File and Code Templates-Incudes-File Header 下添加注释模板，配置模板后点击 Apply OK 应用。

![img](https://segmentfault.com/img/remote/1460000021575639)

  自定义注释模板

```java
/**
 * @className: ${NAME}
 * @description: TODO 类描述 
 * @author: niaonao
 * @date:  ${DATE}
 **/
```

  新建接口文件自动生成注释，效果如下

```java
/**
 * @className: CrowdService
 * @description: 人群对象业务
 * @author: niaonao
 * @date: 2020/1/13
 **/
public interface CrowdService {
}
```

#### 2.1.2 自定义注释模板不完全变量参考表

| 预定义变量          | 描述信息                                                     |
| ------------------- | ------------------------------------------------------------ |
| ${NAME}             | the name of the current file                                 |
| ${PACKAGE_NAME}     | name of the package in which the new file is created         |
| ${USER}             | current user system login name                               |
| ${DATE}             | current system date                                          |
| ${TIME}             | current system time                                          |
| ${YEAR}             | current year                                                 |
| ${MONTH}            | current month                                                |
| ${MONTH_NAME_SHORT} | first 3 letters of the current month name. Example: Jan, Feb, etc. |
| ${MONTH_NAME_FULL}  | full name of the current month. Example: January, February, etc. |
| ${DAY}              | current day of the month                                     |
| ${DAY_NAME_SHORT}   | first 3 letters of the current day name. Example: Mon, Tue, etc. |
| ${DAY_NAME_FULL}    | full name of the current day. Example: Monday, Tuesday, etc. |
| ${HOUR}             | current hour                                                 |
| ${MINUTE}           | current minute                                               |
| ${PROJECT_NAME}     | the name of the current project                              |

### 2.2 方法注释模板

#### 2.2.1 配置模板

  菜单路径 File-Settings-Editor-Live Templates 下添加一个新模板组，名字自定义 JavaTemplateGroup。选中模板组，右侧点击新增按钮，创建新模板。

- Abbreviation 配置为* 。
- Description 自定义描述信息。
- Template Text 自定义模板

```java
*
 $param$
 * @description: TODO
 * @return: $return$
 * @author: niaonao
 * @date: $date$
 */
```

![img](https://segmentfault.com/img/remote/1460000021575638)

![img](https://segmentfault.com/img/remote/1460000021575640)

  Edit variables 编辑变量

- 变量 return 表达式为 methodReturnType()
- 变量 date 表达式为 date()
- 变量 param 表达式为

```java
groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {result+='* @param: ' + params[i] + ((i < params.size() - 1) ? '\\n ' : '')};return result", methodParameters()) 
```

![img](https://segmentfault.com/img/remote/1460000021575642)

  若有警告信息 No Applicable contexts，点击 Define 选中 Java 即可。

![img](https://segmentfault.com/img/remote/1460000021575641)

  此处 Expend With 配置为 Enter 回车键，注释生成快捷方式，看个人习惯，也可以时 Tab 键。

  点击 Apply OK 应用配置即可。效果如下

```java
    /**
     * @param: masterId
     * @param: shopId
     * @param: skuId
     * @description: TODO
     * @return: net.jdcloud.APIECRM.model.ValidateSkuUsingGETResponse
     * @author: niaonao
     * @date: 2020/1/13
     */
    public static ValidateSkuUsingGETResponse validateSkuUsing(String masterId, String shopId, String skuId) {
        return null;
    }
```

#### 2.2.2 补充说明

  方法注释模板不可用在，方法外，若用在方法外 @param 获取不到，注释为 @param null;

  类注释模板在文件创建时生成，已创建文件不会触发该模板，会触发方法注释模板。