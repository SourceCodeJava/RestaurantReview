package com.sample.restaurantreview.dtos;

import java.util.UUID;

import com.sample.restaurantreview.model.User;

public class UserDTO {

	private UUID userid;
	private String userName;
	private String password;
	private String userStatus;

	public UserDTO() {
	}

	public UserDTO(User user) {
		userid = user.getUserid();
		userName = user.getUserName();
		password = user.getPassword();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UUID getUserid() {
		return userid;
	}

	public void setUserid(UUID userid) {
		this.userid = userid;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
