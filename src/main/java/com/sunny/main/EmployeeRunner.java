package com.sunny.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import com.sunny.config.EmpConfiguration;
import com.sunny.entity.Employee;

public class EmployeeRunner {

	public static void main(String[] args) {

		Session session = EmpConfiguration.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

//		MutationQuery namedQuery = session.createNamedMutationQuery("updateAnEmployee");
//		namedQuery.setParameter("n", "Karan");
//		namedQuery.setParameter("i", 11);
//		namedQuery.executeUpdate();

		MutationQuery namedQuery = session.createNamedMutationQuery("deleteEmployeeById");
		namedQuery.setParameter("i", 11);
		namedQuery.executeUpdate();
		tx.commit();

		Query query1 = session.createQuery("from empp", Employee.class);
		List list = query1.list();
		System.out.println(list);
		session.close();
	}

}
