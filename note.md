
idea: failed to save the setting
导致有些包无法导入--> restart idea

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
  
   
--------test revert