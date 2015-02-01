package com.bcsg.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bcsg.dao.BankCardDaoImpl;
import com.bcsg.dao.IBankCardDao;
import com.bcsg.model.BankCard;
import com.bcsg.service.BankCardServiceImpl;
import com.bcsg.service.IBankCardService;

@Configuration
@EnableTransactionManagement
public class ApplicationContextConfigTest {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bcsg");
		dataSource.setUsername("username");
		dataSource.setPassword("password");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(
				dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(BankCard.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name = "bankCardDao")
	public IBankCardDao getBankCardDao(SessionFactory sessionFactory) {
		return new BankCardDaoImpl();
	}

	@Autowired
	@Bean(name = "bankCardService")
	public IBankCardService getBankCardservice(IBankCardDao bankCardDao) {
		return new BankCardServiceImpl(bankCardDao);
	}

}