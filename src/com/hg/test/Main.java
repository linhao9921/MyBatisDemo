package com.hg.test;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hg.entity.Log;
import com.hg.entity.User;
import com.hg.entity.impl.LogMapper;
import com.hg.entity.impl.UserMapper;
import com.hg.util.MyBatisUtil;

/**
 * 测试类
 * 
 * @author Mr.Lin
 *
 */
public class Main {

	static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }
    
    //主函数
    public static void main(String[] args) {
        //addUser();
        getUser();
        getUserList();
        getLogList();
    }

    public static void addUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
        	//实例化数据访问对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            
            User user = new User("lisi", new Integer(25));
            userMapper.insertUser(user);
            // 这里一定要提交，不然数据进不去数据库中
            sqlSession.commit();	
        } finally {
            sqlSession.close();
        }
    }

    public static void getUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
        	//实例化数据访问对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            
            //1.接口方式
            User user = userMapper.getUser("linhao");
            if(user != null){
                ///////////////////////////////////////////////////////
                System.out.println(
                		  "name: " + user.getUser_name() 
                		+ "|status: "+ user.getStatus()
                );
                ///////////////////////////////////////////////////////
            }else{
            	System.out.println("===================未找到数据");
            }
            
            //2.反射方法
            User user1 = sqlSession.selectOne("com.hg.entity.impl.UserMapper.getUser", "superadmin");
            if(user1 != null){
                ///////////////////////////////////////////////////////
                System.out.println(
                		  "name: " + user1.getUser_name() 
                		+ "|status: "+ user1.getStatus()
                );
                ///////////////////////////////////////////////////////
            }else{
            	System.out.println("===================未找到数据");
            }
        } finally {
            sqlSession.close();
        }
    }
    
    public static void getUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
        	//实例化数据访问对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            
            //1.接口方式
            ArrayList<User> users =  userMapper.getUserList(new Integer(1));
            if(users != null){
            	for (User user : users) {
                	System.out.println(user.getUser_name() + "\t" + user.getStatus());
				}
            }else{
            	System.out.println("===================未找到数据");
            }
            
            //2.注解方式
            ArrayList<User> users1 = userMapper.getUserListByAnnotation();
            if(users1 != null){
            	for (User user1 : users1) {
                	System.out.println(user1.getUser_name() + "\t" + user1.getStatus());
				}
            }else{
            	System.out.println("-----------未找到数据");
            }
        } finally {
            sqlSession.close();
        }
    }
    
    public static void getLogList(){
    	 SqlSession sqlSession = sqlSessionFactory.openSession();
    	 try {
         	//实例化数据访问对象
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
            //1.接口方式
            ArrayList<Log> logs = logMapper.getLogList("linhao");
            if(logs != null){
             	for (Log log : logs) {
                 	System.out.println(log.getName() + "\t" + log.getTarget());
 				}
            }else{
            	System.out.println("===================未找到数据");
            }
             
            //2.注解方式
            ArrayList<Log> logs1 = logMapper.getLogListByAnnotation("linhao");
            if(logs1 != null){
             	for (Log log : logs1) {
                 	System.out.println(log.getName() + "\t" + log.getTarget());
 				}
            }else{
            	System.out.println("===================未找到数据");
            }
             
         } finally {
             sqlSession.close();
         }
    }
}
