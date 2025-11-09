package com.firoz.sms.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.firoz.sms")
public class AppConfig {
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.h2.Driver");
    ds.setUrl("jdbc:h2:~/smsdb;AUTO_SERVER=TRUE");
    ds.setUsername("sa");
    ds.setPassword("");
    return ds;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(dataSource);
    factory.setPackagesToScan("com.firoz.sms.model");
    Properties props = new Properties();
    props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    props.put("hibernate.hbm2ddl.auto", "update");
    props.put("hibernate.show_sql", "true");
    props.put("hibernate.format_sql", "true");
    factory.setHibernateProperties(props);
    return factory;
  }

  @Bean
  public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager tx = new HibernateTransactionManager();
    tx.setSessionFactory(sessionFactory);
    return tx;
  }
}
