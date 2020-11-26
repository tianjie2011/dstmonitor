package com.example.dstmonitor.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataSource {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid") // application.properteis中对应属性的前缀
    public DruidDataSource dataSource1() {
        //注意这里
        return DruidDataSourceBuilder.create().build();
    }
//    @Bean
//    @Primary
//    public PlatformTransactionManager prodTransactionManager(@Qualifier("dataSource") DataSource prodDataSource) {
//        logger.info("dataSource : {}",prodDataSource);
//        return new DataSourceTransactionManager((javax.sql.DataSource) prodDataSource);
//    }
}
