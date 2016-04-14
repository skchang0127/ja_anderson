package com.sk.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource(value={"classpath:jdbc.properties"},ignoreResourceNotFound = true)
@MapperScan(basePackages = "com.sk.**.dao")
public class DaoConfig {
    private static final Logger logger = Logger.getLogger(DaoConfig.class);

    @Value("${driver}")
    String driverClass;
    @Value("${url}")
    String url;
    @Value("${username}")
    String userName;
    @Value("${password}")
    String passWord;
    @Value("${initialSize}")
    int initialSize;
    @Value("${maxActive}")
    int maxActive;
    @Value("${maxIdle}")
    int maxIdle;
    @Value("${minIdle}")
    int minIdle;
    @Value("${maxWait}")
    int maxWait;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        logger.info("DataSource");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        return sqlSessionFactory.getObject();
    }

}
