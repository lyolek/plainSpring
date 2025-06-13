package org.sav.plainspring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@EnableLoadTimeWeaving
@EnableTransactionManagement
@ComponentScan(basePackages = "org.sav.plainspring.service, org.sav.plainspring.common")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	BasicDataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("datasource.driver"));
		ds.setUrl(env.getProperty("datasource.url"));
		ds.setUsername(env.getProperty("datasource.username"));
		ds.setPassword(env.getProperty("datasource.password"));
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(BasicDataSource dataSource) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("org.sav.plainspring.pojo");

		Properties props = new Properties();
		props.put(AvailableSettings.DIALECT, env.getProperty("hibernate.dialect"));
		props.put(AvailableSettings.SHOW_SQL, env.getProperty("hibernate.show-sql"));
		props.put(AvailableSettings.FORMAT_SQL, env.getProperty("hibernate.format-sql"));
		props.put(AvailableSettings.HBM2DDL_AUTO, env.getProperty("hibernate.ddl-auto"));
//		props.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
//		props.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
//		props.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
//		props.put(AvailableSettings.PHYSICAL_NAMING_STRATEGY, new org.sav.plainspring.config.SnakeCasePhysicalNamingStrategy());
//		props.put(AvailableSettings.IMPLICIT_NAMING_STRATEGY, "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl");
		props.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
		props.put("hibernate.implicit_naming_strategy", "org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl");


		factoryBean.setHibernateProperties(props);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
