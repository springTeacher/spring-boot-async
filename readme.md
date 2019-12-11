```
1.在@SpringBootApplication启动类 添加注解@EnableAsync
2.异步方法使用注解@Async ,返回值为void或者Future
3.切记一点 ,异步方法和调用方法一定要写在不同的类中,如果写在一个类中,
是没有效果的！！！



AsyncAnnotationBeanPostProcessor 后置处理器处理
```



