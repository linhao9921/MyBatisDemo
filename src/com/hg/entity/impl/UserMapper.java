package com.hg.entity.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.hg.entity.User;

/**
 * �������ݱ�Ľӿ�
 * 
 * @author Mr.Lin
 *
 */
public interface UserMapper {
	/**
	 * ����һ������
	 * @param name
	 * @return
	 */
	public void insertUser(User user);

	/**
	 * ͨ���û�����ȡ�û���Ϣ
	 * @param name
	 * @return
	 */
	public User getUser(String name);
	
	/**
	 * ��ȡ�û��б�
	 * @param status
	 * @return
	 */
	public ArrayList<User> getUserList(Integer status);
	
	/**
	 * ��ȡ�û��б�
	 * <p style="color:red;">
	 * 	˵����ע�ⷽʽ
	 * </p>
	 * 
	 * @return
	 */
	@Select("select * from t_users")
	public ArrayList<User> getUserListByAnnotation();
}
