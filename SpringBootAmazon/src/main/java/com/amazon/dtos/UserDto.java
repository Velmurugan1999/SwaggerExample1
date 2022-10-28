package com.amazon.dtos;

import com.amazon.models.Address;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User DTO")
public class UserDto {
	@Schema(description = "User ID")
	private int userid;
	@Schema(description = "User Name")
	private String uname;
	@Schema(description = "Should be Starts with +91")
	private String mobile;
	@Schema(description = "Email Id")
	private String emailid;
	@Schema(description = "Address of user")
	private Address  address;
	
	public UserDto() {
		
	}

	public UserDto(int userid, String uname, String mobile, String emailid, Address address) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.mobile = mobile;
		this.emailid = emailid;
		this.address = address;
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
	
	
}
