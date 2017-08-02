package com.hg.entity.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.hg.entity.Log;

/**
 * �������ݱ�Ľӿ�
 * 
 * @author Mr.Lin
 *
 */
public interface LogMapper {
	
	/**
	 * ��ȡ�û��б�
	 * @param name
	 * @return
	 */
	public ArrayList<Log> getLogList(String userName);
	
	/**
	 * ��ȡ�û��б�
	 * <p style="color:red;">
	 * 	˵����ע�ⷽʽ
	 * </p>
	 * @param name
	 * @return
	 */
	@Select("select t_log.* from t_log left join t_users on t_log.userid=t_users.userid where t_users.user_name=#{userName}")
	public ArrayList<Log> getLogListByAnnotation(String userName);
}
