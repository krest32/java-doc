**在本地项目文件中使用bash**

$ git config --global user.name "你的名字"

$ git config --global user.email "你的邮箱"



**1. 初始化** 

$ git init 

$ git remote add origin https://gitee.com/xxx/xxx.git (你的远程项目地址)

**2.克隆一下**

$ git clone https://****.git (你的远程项目地址)

**3. 提交**

$ git pull origin master

$ git add .

$ git commit -m "你的第一次提交"

$ git push origin master

![img](img/20210106235520.png)

完成了第一次提交



## IDEA整合git完成代码提交到远程仓库

前提：电脑安装了git
IDEA会自动识别安装路径，如果没有识别，自己选择安装路径配置就好
![在这里插入图片描述](img/20201116144024977.png)
IDEA安装git插件
![在这里插入图片描述](img/20201226100450631.png)

## 一、创建本地仓库

点击VCS – lmport into Version Control – Create Git Repository…
选择项目文件地址，创建本地仓库
![img](img/20201116112655200.png)

## 二、将代码提交到本地仓库

VCS – Git – Add
![在这里插入图片描述](img/20201116113854224.png)

## 三、选择远程仓库地址（以gitee为例）

VCS – Git – Remote
![在这里插入图片描述](img/2020111611434422.png)
添加远程仓库地址
![在这里插入图片描述](img/20201116115130139.png)
此时需要远程仓库的地址，登录gitee创建仓库、复制地址URL，填入即可

## 四、创建远程仓库、填入地址

![在这里插入图片描述](img/20201116114100284.png)
把地址填入第三步URL中，Name默认的就行
![在这里插入图片描述](img/20201116115444659.png)
点击ok，进行密码校验（第一次需要）
![在这里插入图片描述](img/20201116115614637.png)

## 五、提交代码

VCS – Git – Commit Directory…
![在这里插入图片描述](img/20201116115704110.png)

![在这里插入图片描述](img/20201116115905782.png)

## 六、Push

VSC – Git – Push
![在这里插入图片描述](img/20201116120144539.png)
![在这里插入图片描述](img/20201116123849826.png)
回到仓库查看，代码已经上传成功
![在这里插入图片描述](img/20201116123954282.png)
为什么写这个？
原因：记不住git命令



