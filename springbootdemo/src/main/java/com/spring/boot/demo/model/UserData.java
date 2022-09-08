package com.spring.boot.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="userdata")
@Data
public class UserData {
	
	@Id
	long id;	
	String username;	
	//String password;
	
	@Override  
	public String toString()   
	{  
	return "User [id=" + id + ", uname=" + username + "]";  
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}  
	
}
