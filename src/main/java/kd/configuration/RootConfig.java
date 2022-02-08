package kd.configuration;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
//@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
@ComponentScans(value = { @ComponentScan("kd.service"), @ComponentScan("kd.dao") })
public class RootConfig {

 @Autowired
 private Environment env;

 @Bean
 public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

    Properties props = new Properties();

    // Setting Hibernate properties
    props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
    props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");

    // Setting C3P0 properties
//    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//    props.put(C3P0_ACQUIRE_INCREMENT, 
//          env.getProperty("hibernate.c3p0.acquire_increment"));
//    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

    factoryBean.setHibernateProperties(props);
    factoryBean.setPackagesToScan("kd.entity");
    factoryBean.setDataSource(getDataSource());

    return factoryBean;
 }

 
	/*
	 * @Bean public HibernateTransactionManager getTransactionManager() {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager();
	 * transactionManager.setSessionFactory(getSessionFactory().getObject()); return
	 * transactionManager; }
	 */   
 @Bean
 public DataSource getDataSource() {
     BasicDataSource dataSource = new BasicDataSource();
     dataSource.setDriverClassName(env.getProperty("mysql.driver"));
     dataSource.setUrl(env.getProperty("mysql.url"));
     dataSource.setUsername(env.getProperty("mysql.user"));
     dataSource.setPassword(env.getProperty("mysql.password"));
     return dataSource;
 }
}

