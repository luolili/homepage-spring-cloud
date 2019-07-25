1. 删除父项目的src
2. 对于一个模块，可以把他作为一个父模块，在里面建子模块，
删除父模块的src

3. @EntityListeners(AuditingEntityListener.class) 
自动填充创建时间和修改时间

4.一个模块不能同时又2个被@SpringBootApplication注解的类


5.在查询多个对象的时候： @PostMapping