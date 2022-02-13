在写文档的过程中，经常需要进行画图。最近发现 IDEA 有一款插件 PlantUML, 它本质上是也算一门可以快速画图的设计语言，学习起来也很方便，这篇文章主要向大家介绍IDEA 安装 PlantUML 试用体验，希望对大家有所帮助。

# PlantUML 简介

一门可以快速画图的设计语言：

http://plantuml.com/zh/state-diagram

PlantUML 是一个开源项目，支持快速绘制时序图、用例图、类图、活动图、组件图、状态图、对象图、部署图等。同时还支持非 UML 图的甘特图、架构图等。例如下面等用例图：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6L0dwY0g1WXFxajBuVlhZSG5YWXNmMzJtN01FaHlaUmppY2FZSU0yaWM4bTRZOHhnd2NacHl3b21ucDZRZXVxWnpMYW9HaDRUdXEzRVBvdmxyeWlhdjRQcldBLzY0MA?x-oss-process=image/format,png)

## PlantUml 是什么

PlantUml是一个支持快速绘制的开源项目。其定义了一套完整的语言用于实现UML关系图的描述，并基于强大的Graphviz图形渲染库进行UML图的生成。绘制的UML图还可以导出为图片,以及通用的矢量SVG格式文件。

## PlantUML 的优点

完全文本方式编辑，无需控件拖拽，自动调节图元距离，简单美观

1、与开发平台完全无关，不受平台限制，只要有PlantUML jar包就能生成UML图

2、支持多种文本编辑器、ide的集成，例如idea、eclipse、notepad++等

3、作为一个Java coder，通常使用idea作为首选开发工具，我们以idea中的使用为主作介绍

## 安装 Graphviz

IDEA 安装PlantUML插件还需要安装 Graphviz 才能正常显示，先上 Graphviz 安装包的资源分享链接

graphviz-2.38.msi

百度网盘链接：

https://pan.baidu.com/s/1aPWSoa8iIGa0iQogprsgdA
**提取码：1234**

Graphviz 下载之后，疯狂下一步，就安装完了

**如果不安装 Graphviz，画图的时候，会提示**

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWN3dUR0Q3lzRWt6T2x5c2VnUnpXU2tDWnVmUUp0ZXhscE9SdGhSSGw5eVV4bHg3TUx6eXE1N2cvNjQw?x-oss-process=image/format,png)

## IDEA 安装 PlantUML插件

IDEA 直接搜索安装：

File -> Settings -> Plugins 搜索 PlantUML ，搜索 PlantUML , 安装 PlantUML integration , 如下

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWNCMndMaWN5V3BsOUJndk9lZ21KSnVoMkh1ZVQxVFlsRGhYN3pYRXR5SEMwWnE4WjdkVUNsSGhRLzY0MA?x-oss-process=image/format,png)

或者你用，安装包，离线安装

下载插件包安装，地址

http://plugins.jetbrains.com/plugin/7017-plantuml-integration

对了，更多 IDEA 插件相关的文章我整理好了，关注微信公众号 Java后端，回复 666 下载。

## 使用 PlantUML 画流程图

File -> New -> PlantUML File -> 选择你要画的类型

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWM1OUw3bkhDR1ZpYjRVWGhyZUZ3MWo5Q25TVGcyNm1ZU29tc3d1QTJ2ZWREV1d4NllObEtpY0t5Zy82NDA?x-oss-process=image/format,png)

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWNXTTBOckpkNE5JRTBHS1o4d05qdkxJZ0RqQzJZUEl1ellpYjAwaWM1b1c2dXBoREhPWGlhUEdzSVEvNjQw?x-oss-process=image/format,png)

## 输入内容，先看看效果

```go
@startuml
skinparam rectangle {
    BackgroundColorDarkSeaGreen
    FontStyleBold
    FontColorDarkGreen
}
:User: as u
rectangle Toolas t
rectangle "Knowledge Base"as kb
(RobotFramework) as rf
(DUT) as dut
note as ts
    test script
end note
note as act
    query
    &
    action
end note
note as t_cmt
    - 执行测试脚本，
    - 按照知识库响应消息
    - 关注公众号：Java后端
    - 回复：面试题，得3625页大厂面试题
end note
note as kb_cmt
    - 根据当前消息确定响应方法
    - 根据上下文填充消息
    - 保存信息到相关上下文
end note
u --> rf
rf =right=> ts
ts =down=> t
kb <=left=> act
act <=up=> t
t = dut
t_cmt -- t
kb_cmt -left- kb
@enduml
```

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWNYVDhKd0lJd2YwVm9vdkk3WUp5ZHpNWnZWMU1kcVZCMzV4YUFlNEZIVkRNeTZpYWhxVUVYeTV3LzY0MA?x-oss-process=image/format,png)

### 时序图：

```go
@startuml
Alice-> Bob: AuthenticationRequest
Bob--> Alice: AuthenticationResponse
Alice-> Bob: Another authentication Request
Alice<-- Bob: another authentication Response
@enduml
```

### 效果如图：

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWM1Mk9raGJpY0V2WWJOd3lBT2tpYlltNDVMS1pDQkJQVWhmcnFXMjY4R0hmMWVnYXlETlFaM09SZy82NDA?x-oss-process=image/format,png)

### 导出文件 

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWNib0ozaFo3bXhxV2xmYkRxR0NucUxXRWYxOWVSOERwSDZ1U1dwZ0JNZllsRnR4NjNKWjluRHcvNjQw?x-oss-process=image/format,png)

## 设置不同的角色 

时序图角色可以分为: actor, boundary, control, entity, database，每种角色呈现的图形也是不一样的。

```go
@startuml
actor Foo1
boundary Foo2
control Foo3
entity Foo4
database Foo5
collections Foo6
Foo1-> Foo2: To boundary
Foo1-> Foo3: To control
Foo1-> Foo4: To entity
Foo1-> Foo5: To database
Foo1-> Foo6: To collections
@enduml
```

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWN3MEJ0SEp6c1BXVzZtOVg4NjdNbDc3TEVMZzNabWF0WXowd0Z2VzlKdXdIbm9CSTlRWEFvT1EvNjQw?x-oss-process=image/format,png)

```go
图例注脚等@startuml
header PageHeader
footer Page%page% of %lastpage%
title ExampleTitle
Alice-> Bob: message 1
note left: thisis a first note
Alice-> Bob: message 2
@enduml
```

### 其他

如果不想装 graphviz，想直接用，可以下载chrome插件PlantUML Viewer，安装之后直接编辑文本，可以在浏览器直接显示。

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy9HcGNINVlxcWowblZYWUhuWFlzZjMybTdNRWh5WlJqaWNOZ3NEZ3RrazVkbW5pY1ZoVURtaG11d2pxRDJCOFh6dTMwTDlDNWlhcUVJeXR5YnRLbXZNU29ZZy82NDA?x-oss-process=image/format,png)

## 最后

IDEA 上用 PlantUML 虽然不错，但是每次还需要打开IDEA，还是有点小麻烦。我在开发过程中用的更多的是用在线作图工具，如：ProcessOn, webchart ,等。