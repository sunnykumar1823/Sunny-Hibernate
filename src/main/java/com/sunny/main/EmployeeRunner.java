package com.sunny.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

		Employee emp = new Employee("sita", "Female", 79000, "India");
		Employee emp1 = new Employee("ram", "Male", 89000, "India");
		Employee emp2 = new Employee("shyam", "Male", 79000, "India");
		Employee emp3 = new Employee("yash", "Male", 69000, "India");
		Employee emp4 = new Employee("santi", "Female", 59000, "India");
		Employee emp5 = new Employee("naina", "Female", 49000, "India");

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

//		session.persist(emp);
//		session.persist(emp1);
//		session.persist(emp2);
//		session.persist(emp3);
//		session.persist(emp4);
//		session.persist(emp5);
//		tx.commit();

		Query<Employee> query = session.createQuery("from empp", Employee.class);

		System.out.println(query.list());
//

	}

}
