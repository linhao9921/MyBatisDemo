package com.hg.entity;

/**
 * 
 * ÊµÌåÀà
 * 
 * @author Mr.Lin
 *
 */
public class User {
    private String user_name;
    
    private Integer status;
   
    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User(String user_name, Integer status) {
        super();
        this.user_name = user_name;
        this.status = status;
    }

    public User() {
        super();
    }
}
