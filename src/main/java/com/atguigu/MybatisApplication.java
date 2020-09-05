package com.atguigu;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.scheduling.annotation.EnableScheduling;
        import org.springframework.scheduling.annotation.Scheduled;

/**
 * @MapperScan(basePackages = "com.atguigu.dao")
 * 扫描指定包下的所有Mapper接口，将动态代理的实现类对象注入Spring容器中
 * basePackages属性：指定扫描的包路径地址
 * 作用相当于：
 * <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
 *     <property name="basePackage" value="com.atguigu.dao"/>
 * </bean>
 */
@SpringBootApplication
@MapperScan("com.atguigu.dao")
@EnableScheduling
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
