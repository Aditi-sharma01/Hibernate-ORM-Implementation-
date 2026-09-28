package com.code.HibernateProject1.entity;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="username", length=50, nullable=false, unique=true)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="email", length=50, nullable=false, unique=true)
	private String email;
	
	public enum Role{
		ADMIN,
		CUSTOMER
	}
	@Enumerated(EnumType.STRING)
	@Column(name="role",length=10,nullable=false)
	private Role role;

	@OneToMany(mappedBy = "users", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
	private List<Orders> orders = new ArrayList<>();
	
	//default constructor
	public Users() {
		this.id=0;
		this.username=null;
		this.password=null;
		this.email=null;
		this.role=Role.CUSTOMER;
	}

	//parameterized constructor
	public Users(String username, String password, String email, Role role) {
		super();
		this.username = username;
		this.password = hashPassword(password);
		this.email = email;
		this.role = role;
	}

	//Getter and Setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			StringBuilder result = new StringBuilder();
			for (byte value : hashedPassword) {
				result.append(String.format("%02x", value));
			}
			return result.toString();
		} catch (NoSuchAlgorithmException exception) {
			throw new IllegalStateException("SHA-256 is not available", exception);
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	//toString() method
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	
	
	
	
}
