package com.sunny.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

		Employee emp = new Employee("Sunny", "male", 79000);

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.persist(emp);
		tx.commit();

//		Query<Employee> query = session.createQuery("from empp", Employee.class);
//		System.out.println(query.list());

	}

}
