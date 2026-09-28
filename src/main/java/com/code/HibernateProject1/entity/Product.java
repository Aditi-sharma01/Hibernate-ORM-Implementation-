package com.code.HibernateProject1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name", length=50, nullable=false)
	private String name;
	@Column(name="price", nullable=false)
	private double price;
	@Column(name="stockQuantity")
	private int stockQuantity;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	private Category category;
	
	//default constructor
	public Product() {
		this.id=0;
		this.name=null;
		this.price=0.0;
		this.stockQuantity=0;
		this.category=null;
	}

	//parameterized constructor
	public Product(String name, double price, int stockQuantity, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.category = category;
	}

	//Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//toString() method
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity
				+ ", category=" + category + "]";
	}
}
