package com.sunny.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Address;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

		Employee emp1 = new Employee();
		emp1.setName("Sunny");
		emp1.setGender("Male");
		emp1.setSalary(89000);

		Employee emp2 = new Employee();
		emp2.setName("Ram");
		emp2.setGender("Male");
		emp2.setSalary(99000);

		Address add1 = new Address();
		add1.setCity("Chakia");
		add1.setState("Bihar");

		Address add2 = new Address();
		add2.setCity("Noida");
		add2.setState("UP");

		emp1.setAddresses(List.of(add1, add2));
		emp2.setAddresses(List.of(add1));

//
//		ArrayList<Address> listOfAddresses = new ArrayList<>();
//		listOfAddresses.add(add1);
//		listOfAddresses.add(add2);
//		listOfAddresses.add(add3);
//
//		emp.setAddresses(listOfAddresses);

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.persist(add1);
		session.persist(add2);
		session.persist(emp1);
		session.persist(emp2);
		tx.commit();

//		Employee employee = session.find(Employee.class, 1);
//		System.out.println(employee);
//		System.out.println(employee.getAddresses());

//		Address address = session.find(Address.class, 1);
//		System.out.println(address);
//		System.out.println(address.getEmployee());

		Address address = session.find(Address.class, 1);
		System.out.println(address);
		System.out.println(address.getEmployees());

		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		System.out.println(employee.getAddresses());

	}

}
