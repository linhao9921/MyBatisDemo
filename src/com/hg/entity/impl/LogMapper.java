package com.hg.entity.impl;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.hg.entity.Log;

/**
 * 访问数据表的接口
 * 
 * @author Mr.Lin
 *
 */
public interface LogMapper {
	
	/**
	 * 获取用户列表
	 * @param name
	 * @return
	 */
	public ArrayList<Log> getLogList(String userName);
	
	/**
	 * 获取用户列表
	 * <p style="color:red;">
	 * 	说明：注解方式
	 * </p>
	 * @param name
	 * @return
	 */
	@Select("select t_log.* from t_log left join t_users on t_log.userid=t_users.userid where t_users.user_name=#{userName}")
	public ArrayList<Log> getLogListByAnnotation(String userName);
}
