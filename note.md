1. 删除父项目的src
2. 对于一个模块，可以把他作为一个父模块，在里面建子模块，
删除父模块的src

3. @EntityListeners(AuditingEntityListener.class) 
自动填充创建时间和修改时间

4.一个模块不能同时又2个被@SpringBootApplication注解的类

5.在查询多个对象的时候： @PostMapping

切换web server:如从tomcat切换到jetty: 需要排除tomcat,因为tomcat的
加载优先于jetty.
切换web mvc--> web flux :2者是不可以共存的，同时存在；同时存在
的时候用web flux
#docker deploy and run the jar
1.在项目下面新建Dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/homepage-eureka-1.0-SNAPSHOT.jar /hp.jar
ENTRYPOINT ["java","-jar","/hp.jar"]

解释：
FROM 要下载的依赖； VOLUME /tmp 临时存放的目录
ADD target/homepage-eureka-1.0-SNAPSHOT.jar：jar包所在的项目路径
/hp.jar ：生成的 docker 镜像的名字

ENTRYPOINT ["java","-jar","/hp.jar"] ： 要执行的jar文件

2. docker build -t dalaoyang . 不能少了最后的 dot
3.docker images  查看生成的镜像是否存在
4. docker run -d -p 8002:8000 myorg/hp
如果配置文件指定了server.port ,:后面就是指定的port
  
5. 提交时：
Fatal: HttpRequestException encountered. 
unable to access 
'https://github.com/luolili/homepage-spring-cloud.git/': 
Operation timed out 
after 300000 milliseconds with 0 out of 0 bytes receive

到
https://github.com/Microsoft/Git-Credential-Manager-for-Windows/releases/tag/v1.14.0
下载 GCMW-1.14.0.exe即可

6. docker image与container区别

 #微信的消息模板
   先用服务号的账号和密码登陆，让管理员扫码；
   添加新的消息模板;
   获得消息模板id，id用AES加密
   把加密的模板id配置到MessageType里面
  
  #微服务
  1. 轻量级的通信：不同语言写的模块可以通信
  2. 围绕业务建模
 #mongodb使用？
#如何用idea进行版本回退？

1. 右击项目--> Git-->Show hisotry-->选中之前的某一个版本（你要回到
的版本）--> Copy reversion Number
2. 右击项目-->Git-->Repository--Branches-->choose Checkout for tag
or Reversion--paste-->ok
3. 此时你所处的分支名字叫你复制的那个字符串
checkout 到master分支-->smart choukout-->merge
#如何部署springboot项目到华为云
1. 登陆华为云，点击右上角的控制台
2. 配置弹性云服务器ip
3. 用软件登陆云服务器， 用XShell下载如docker等软件
