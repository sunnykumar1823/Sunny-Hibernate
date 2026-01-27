package com.sunny.main;

import org.hibernate.Session;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

//		Employee emp = new Employee();
//		emp.setName("Sunny");
//		emp.setGender("Male");
//		emp.setSalary(89000);
//
//		Address add1 = new Address();
//		add1.setCity("Chakia");
//		add1.setState("Bihar");
//
//		Address add2 = new Address();
//		add2.setCity("Noida");
//		add2.setState("UP");
//
//		Address add3 = new Address();
//		add3.setCity("Raxul");
//		add3.setState("Bihar");
//
//		ArrayList<Address> listOfAddresses = new ArrayList<>();
//		listOfAddresses.add(add1);
//		listOfAddresses.add(add2);
//		listOfAddresses.add(add3);
//
//		emp.setAddresses(listOfAddresses);

		Session session = EmpConfiguration.getSessionFactory().openSession();
//		Transaction tx = session.beginTransaction();

//		session.persist(add1);
//		session.persist(add2);
//		session.persist(add3);
//		session.persist(emp);
//		tx.commit();

		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		System.out.println(employee.getAddresses());

	}

}
