package com.amazon.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="user")
@Schema(description = "All attributes of User data")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Auto Generated ID")
	private int userid;
	
	@Schema(description = "Username",required = true)
	@Column(nullable = false)
	private String uname;
	
	@Schema(description = "Mobile Should starts with +91",required = true)
	@Column(nullable = false, unique = true)
	private String mobile;
	
	@Schema(description="Email ",required = true)
	@Column(nullable = false, unique = true)
	private String emailid;
	
	@Embedded
	private Address  address;
	
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders=new ArrayList<Order>();
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="roleid")
	private Role role;
	
	public User() {
		
	}
	public User(int userid, String uname, String mobile, String emailid, Address address, List<Order> orders,
			Role role) {
		this.userid = userid;
		this.uname = uname;
		this.mobile = mobile;
		this.emailid = emailid;
		this.address = address;
		this.orders = orders;
		this.role = role;
	}
	
	public User(String uname, String mobile, String emailid, Address address, List<Order> orders, Role role) {
		super();
		this.uname = uname;
		this.mobile = mobile;
		this.emailid = emailid;
		this.address = address;
		this.orders = orders;
		this.role = role;
	}
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
