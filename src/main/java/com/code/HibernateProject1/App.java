package com.code.HibernateProject1;

import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("Hibernate started successfully.");
		sessionFactory.close();
	}
}
