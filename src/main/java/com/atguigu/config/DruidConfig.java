package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidConfig {
    //将数据库连接信息直接封装到数据源对象中
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException{
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
