package com.test.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pojo.Department;
import com.test.pojo.Employee;

public class TestMain {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"servlet-context.xml");
		System.out.println("sdfs>>>> " + context);
		System.out.println(">"
				+ context.getBean("hibernate4AnnotatedSessionFactory"));
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("hibernate4AnnotatedSessionFactory");

		System.out.println("sessionFactory:" + sessionFactory);
		Session session = sessionFactory.openSession();
		System.out.println("session id:" + session);

		Department dept = new Department();
		// dept.setDeptId(1014);
		dept.setDeptName("ECE DEPARTMENT");
		dept.setLocationId("JNTU HYD");

		List<Employee> employees = session.createCriteria(Employee.class)
				.setProjection(Projections.property("empId"))
				.add(Restrictions.like("empId", "6%"))
				.add(Restrictions.like("empName", "x"))
				.addOrder(Order.asc("empId")).list();

		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(dept);
		transaction.commit();

	}

}
