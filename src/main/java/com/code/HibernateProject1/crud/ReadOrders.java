package com.code.HibernateProject1.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;

public class ReadOrders {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	
	//create constructor with arg SessionFactory
	public ReadOrders(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		
		//start the transaction to work with the session object
		session.beginTransaction();
		
		//show all the object from the Product
		List<Orders> orderss = session.createQuery("from Orders").getResultList();
		for(Orders orders:orderss) {
			System.out.println(orders.toString());
		}
		
		//close the session
		session.close(); //detached
	}
}
