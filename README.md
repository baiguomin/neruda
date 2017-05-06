# neruda
ioc aop dao mvc framework

1.模仿spring的ioc功能
第一步，读取配置文件，主要代码在BaseProperty.java类中
  目前读取配置文件在类加载阶段，后期应该是做到当项目启动时才读取配置文件（√）
第二步，在application.properties中配置基础包
新建@Bean 注解类，然后扫描项目中被@Bean注解的类，用一个HashMap管理这些类（ing）
