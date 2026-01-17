package com.sunny.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void delById(int id, Session session) {
//		HQL delete query
		MutationQuery query = session.createMutationQuery("delete from empp where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public static void main(String[] args) {

		Employee emp = new Employee("gita", "Female", 79000, "India");
		Employee emp1 = new Employee("karan", "Male", 89000, "India");
		Employee emp2 = new Employee("satyam", "Male", 79000, "India");
		Employee emp3 = new Employee("vishal", "Male", 69000, "India");
		Employee emp4 = new Employee("gunjan", "Female", 59000, "India");
		Employee emp5 = new Employee("anita", "Female", 49000, "India");

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

//		session.persist(emp);
//		session.persist(emp1);
//		session.persist(emp2);
//		session.persist(emp3);
//		session.persist(emp4);
//		session.persist(emp5);
//		tx.commit();

//		Example of HQL to get all the records
//		Query query1 = session.createQuery("from empp", Employee.class);
//		List list = query1.list();
//		System.out.println(list);

//		HQL to get records with pagination
//		query1.setFirstResult(6);
//		query1.setMaxResults(12);
//		System.out.println(query1.list());

//		Query q = session.createQuery("select max(name) from empp");
//		List list1 = q.list();
//		System.out.println(list1);

//		HQL update query Using Named Parameters
//		MutationQuery mutationQuery = session.createMutationQuery("update empp set name=:n where id=:i");
//		mutationQuery.setParameter("n", "dhiraj");
//		mutationQuery.setParameter("i", 5);
//		System.out.println("status: " + mutationQuery.executeUpdate());

//		HQL delete query
//		MutationQuery query = session.createMutationQuery("delete from empp where id = 13");
//		query.executeUpdate();

//		Query query1 = session.createQuery("from empp", Employee.class);
//		List list = query1.list();
//		System.out.println(list);

		delById(12, session);

		tx.commit();
		session.close();
	}

}
