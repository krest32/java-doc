# Spring Boot- Actuator

[`CSDN`页面1](https://blog.csdn.net/qq825478739/article/details/121444568?ops_request_misc=&request_id=&biz_id=102&utm_term=Spring%20boot%E2%80%94%E2%80%94Actuator&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-5-121444568.142^v35^pc_search_result_control_group&spm=1018.2226.3001.4187)

[`CSDN`页面2](https://blog.csdn.net/weixin_43823808/article/details/121268868?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165923584816781667846029%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=165923584816781667846029&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-3-121268868-null-null.142^v35^pc_search_result_control_group&utm_term=SpringBoot%20%7C%20%E5%9B%9B%E5%A4%A7%E6%A0%B8%E5%BF%83&spm=1018.2226.3001.4187)

[`CSDN`页面3-系统调优](https://blog.csdn.net/u014401141/article/details/84784422?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-84784422-blog-121268868.pc_relevant_aa&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-84784422-blog-121268868.pc_relevant_aa&utm_relevant_index=2)

### 性能优化

#### 组件自动扫描带来的问题

​		默认情况下，我们会使用 `@SpringBootApplication` 注解来自动获取应用的配置信息，但这样也会给应用带来一些副作用。使用这个注解后，会触发自动配置`auto-configuration`和 组件扫描 `component scanning` ，这跟使用 `@Configuration`、`@EnableAutoConfiguration` 和 `@ComponentScan` 三个注解的作用是一样的。这样做给开发带来方便的同时，也会有三方面的影响：

1. 会导致项目启动时间变长。当启动一个大的应用程序,或将做大量的集成测试启动应用程序时，影响会特别明显。
2. 会加载一些不需要的多余的实例（beans）。
3. 会增加 CPU 消耗。

​		针对以上三个情况，我们可以移除 `@SpringBootApplication` 和 `@ComponentScan` 两个注解来禁用组件自动扫描，然后在我们需要的 bean 上进行显式配置：