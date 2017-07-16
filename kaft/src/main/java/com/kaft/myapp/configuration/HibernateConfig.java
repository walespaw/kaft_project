package com.kaft.myapp.configuration;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.kaft.myapp.dao") //springdata
@PropertySource(value={"classpath:application.properties"})
//@ComponentScan(value={"com.kaft.myapp"})
public class HibernateConfig {
	@Autowired
	private Environment env;
	
	private DataSource dataSource;
	
		
	@Bean
	public DataSource getDataSource() {
		//dziala z contextu tomcata
		try {
			Context cxt = new InitialContext();

			dataSource = (DataSource) cxt.lookup("java:/comp/env/jdbc/postgres");

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("datasource.driver"));
		dataSource.setUrl(env.getRequiredProperty("datasource.url"));
		dataSource.setUsername(env.getRequiredProperty("datasource.username"));
		dataSource.setPassword(env.getRequiredProperty("datasource.password"));*/
		return dataSource;
	}
	
	
	@Bean
	public EntityManagerFactory entityManagerFactory() throws Exception{
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getDataSource());
		em.setPackagesToScan("com.kaft.myapp");
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(getHibernateProperties());
		em.afterPropertiesSet();
	
		return em.getObject();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception{
		JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, env.getRequiredProperty("hibernate.dialect"));
		properties.put(AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.show_sql"));
		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, env.getRequiredProperty("hibernate.batch.size"));
		properties.put(AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, env.getRequiredProperty("hibernate.current.session.context.class"));
		properties.put(AvailableSettings.DEFAULT_SCHEMA, env.getRequiredProperty("hibernate.default_schema"));
		return properties;
	}
	
		
	/*@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}*/
	
	
	/*@Bean
	public
	/*@Bean
	public JpaTransactionManager jpaTransactionManager(){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource(getDataSource());
		jpaTransactionManager.set
		return jpaTransactionManager;
	}
	
*/	
}
