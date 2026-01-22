package com.sunny.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Address;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

//		Employee emp = new Employee("sunny", "male", 79000);

		Employee emp = new Employee();
		emp.setName("Sunny");
		emp.setGender("Male");
		emp.setSalary(89000);

//		Address add = new Address("chakia", "Bihar");
		Address add = new Address();

		add.setCity("Chakia");
		add.setState("Bihar");
		add.setEmployee(emp);

		emp.setAddress(add);

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.persist(add);
		session.persist(emp);
		tx.commit();

		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		System.out.println(employee.getAddress());

		Address address = session.find(Address.class, 1);
		System.out.println(address);
		System.out.println(address.getEmployee());

	}

}
