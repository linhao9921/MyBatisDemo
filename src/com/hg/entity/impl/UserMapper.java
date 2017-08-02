package com.hg.entity.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.hg.entity.User;

/**
 * 访问数据表的接口
 * 
 * @author Mr.Lin
 *
 */
public interface UserMapper {
	/**
	 * 插入一条数据
	 * @param name
	 * @return
	 */
	public void insertUser(User user);

	/**
	 * 通过用户名获取用户信息
	 * @param name
	 * @return
	 */
	public User getUser(String name);
	
	/**
	 * 获取用户列表
	 * @param status
	 * @return
	 */
	public ArrayList<User> getUserList(Integer status);
	
	/**
	 * 获取用户列表
	 * <p style="color:red;">
	 * 	说明：注解方式
	 * </p>
	 * 
	 * @return
	 */
	@Select("select * from t_users")
	public ArrayList<User> getUserListByAnnotation();
}
