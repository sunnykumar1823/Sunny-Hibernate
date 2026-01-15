package com.sunny.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

		Employee emp = new Employee("sunny", "Male", 69000);

		// first Approch
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();

		// Second Approch
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();

		// Third Approch
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
//		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
//		SessionFactory sessionFactory = metadata.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();

		SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
				.getMetadataBuilder().build().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

//		session.persist(emp);
//		tx.commit();

//		Employee employee = session.get(Employee.class, 2);
//		System.out.println(employee);

//		Employee employee = session.find(Employee.class, 3);
//		System.out.println(employee);

		Employee employee = new Employee();
		session.load(employee, 3);
		System.out.println(employee);

	}

}
