package com.amazon.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="role")
@Schema(description = "User Role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Role_id Auto generated")
	private int roleid;
	
	@Column(nullable=false, unique = true)
	@Schema(description = "Role Name")
	private String rolename;
	
	
	@JsonBackReference
	@OneToMany(mappedBy = "role")
	private List<User> user;
	public Role() {
		
	}
	public Role(int roleid, String rolename, List<User> user) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.user = user;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
}
