package com.sunny.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class EmpConfiguration {

	public static SessionFactory getSessionFactory() {

		Properties properties = new Properties();

		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost:3306/hibernate");
		properties.put(Environment.JAKARTA_JDBC_USER, "root");
		properties.put(Environment.JAKARTA_JDBC_PASSWORD, "sunny@123");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.FORMAT_SQL, "true");

//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(properties).build();
//		Metadata metaData = new MetadataSources(ssr).addAnnotatedClass(com.sunny.entity.Employee.class).getMetadataBuilder().build();
//		SessionFactory sessionFactory = metaData.buildSessionFactory();

//		return sessionFactory;

		return new MetadataSources(new StandardServiceRegistryBuilder().applySettings(properties).build())
				.addAnnotatedClass(com.sunny.entity.Employee.class).getMetadataBuilder().build().buildSessionFactory();

	}

}
