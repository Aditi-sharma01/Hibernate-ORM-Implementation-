package com.code.HibernateProject1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.OrderDetails;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;
import com.code.HibernateProject1.entity.Users;

public final class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private HibernateUtil() {
	}

	private static SessionFactory buildSessionFactory() {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Users.class)
				.addAnnotatedClass(Orders.class)
				.addAnnotatedClass(OrderDetails.class)
				.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	public static void shutdown() {
		SESSION_FACTORY.close();
	}
}