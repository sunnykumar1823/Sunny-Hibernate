package com.sunny.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

		Employee emp = new Employee("sunny", "Male", 69000);

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.persist(emp);
		tx.commit();

//		Employee employee = session.get(Employee.class, 2);
//		System.out.println(employee);

//		Employee employee = session.find(Employee.class, 3);
//		System.out.println(employee);

//		Employee employee = new Employee();
//		session.load(employee, 3);
//		System.out.println(employee);

	}

}
