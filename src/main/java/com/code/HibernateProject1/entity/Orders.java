package com.code.HibernateProject1.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="orderDate", nullable=false)
	private LocalDateTime orderDate;
	@Column(name="totalAmount", nullable=false)
	private double totalAmount;
	
	@ManyToOne
	@JoinColumn(name="users_id", nullable=false)
	private Users users;

	@OneToMany(mappedBy = "orders", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetails> orderDetails = new ArrayList<>();
	
	//default constructor
	public Orders() {
		this.id=0;
		this.orderDate=null;
		this.totalAmount=0.0;
		this.users=null;
	}

	//parameterized constructor
	public Orders(LocalDateTime orderDate, double totalAmount, Users users) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.users = users;
	}

	//Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	//toString() method
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", users=" + users
				+ "]";
	}

}
