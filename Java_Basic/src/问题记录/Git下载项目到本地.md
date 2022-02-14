1. 新建一个目录，存放下载下来的项目，我在D盘新建了一个“gitspace”文件夹，用来存放下载下来的项目

2. 进入刚刚新建的文件夹，即进入“gitspace”，点击鼠标右键，选择"Git Bash Here"

3. 进行基础配置，作为 git 的基础配置，作用是告诉 git 你是谁，你输入的信息将出现在你创建的提交中，使用下面两条命令：

   ```java
   git config --global user.name "你的名字或昵称"
   git config --global user.email "你的邮箱"
   ```

4. 在gitspace文件夹中执行下面命令，完成初始化

   ```java
   git init
   git remote add origin <你的项目地址> //注:项目地址形式为:https://gitee.com/xxx/xxx.git或者 git@gitee.com:xxx/xxx.git
   ```

5. 如果你想克隆，只需要执行命令

   ```java
   git clone <项目地址>
   ```

6. 进入你已经初始化好的或者克隆项目的目录,然后执行：
   从服务器下更新项目，因为已经clone过，所以不需要再更新

   ```java
   git pull origin master 
   ```

7. 做一些修改，比如添加一个"说明.txt"文件
   执行下面命令，完成第一次提交

   ```java
   git add .
   git commit -m “安装教程测试”
   git push origin master
   ```

   注意：提交命令有两个，git push origin master（正常提交）和git push origin master -f（强制提交，强制提交可能会把之前的commit注释信息，不会改变修改的代码，慎用），都是提交到master分支

8. 其他常见git命令

   - 查看所有分支  ：git branch -a
   - 切换到某一分支：git checkout  分支名称
   - 合并分支：git merge 原分支  目标分支