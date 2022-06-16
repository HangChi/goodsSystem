package com.bhu.shc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2.准备好 二次封装工具
 * BaseDao 用于简单封装 jdbc中 重复代码
 * 
 * 注册驱动
 * 建立连接
 * 定义sql语句
 * 执行sql语句【查询executeQuery/增删改executeUpdate】
 * 处理结果集【查询】
 * 关闭资源【查询 --conn,ps,rs/增删改 --conn,ps】
 * 
 * 将重复相同的功能封装成方法
 * 1.注册驱动，建立连接
 * 2.关闭资源 conn,ps
 * 3.将增删改封装为一个方法
 * 4.查询
 * 
 * 将所有功能都需要使用的对象封装为属性
 * Connection
 * PreparedStatement
 * 
 * 将连接数据库需要的配置信息 封装为 静态常量属性 final
 * 驱动类名
 * url
 * 用户名
 * 密码
 * 
 * @author songh
 *
 */
public class BaseDao {
	//声明连接数据库的配置信息
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "orcl";
	//多个方法均用到的对象定义为属性
	Connection conn = null;
	PreparedStatement ps = null;
	
	//-----------------------------定义方法-------------------------------------
	//1.注册驱动，获取连接
	public Connection getConn() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//2.关闭资源 conn,ps
	public void closeAll() {
		//为了防止连接失败产生的空指针异常 需要做空值判断
		try {
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 3.将增删改封装为1个方法
	 * 【方法体分析】
	 * 1.获取连接getConn方法
	 * 2.通过sql语句 获取ps对象
	 * 3.通过ps对象 和 传进来的参数列表 对sql就行拼接
	 * 4.执行最终的sql语句
	 * 5.关闭资源
	 * 
	 * @param sql sql语句
	 * 		Object[] params 若干个类型未知的参数
	 * 		java为 基本数据类型提供对应的包装器类型   int<-可自动转化->Integer
	 * @return 返回数据变化的条数
	 */
	public int update(String sql,Object[] params) {
		//定义code存放编辑数据的数量 初始值为0
		int code = 0;
		//1.获取连接getConn()方法 this表示当前对象 可以省略
		conn = this.getConn();
		
		try {
			//2.通过sql语句 获取ps对象
			ps = conn.prepareStatement(sql);
			
			//3.通过ps对象和传进来的参数列表对 sql进行拼接
			//通过遍历传进来的数组参数 实现sql的拼接
			for(int i = 0; i < params.length; i++) {
				//将下标为0的元素放到第1个?上  下标为1的元素放到第2个?上...
				ps.setObject(i+1, params[i]);
			}
			
			//4.执行最终的sql语句
			code = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//无论如何都会执行的代码块
			//5.关闭资源
			this.closeAll();
		}
		
		return code;
	}
	
	
	/**
	 * 4.查询
	 * @param String sql sql语句
	 * 		Object[] params 若干个类型未知的参数
	 * @return 待处理结果集
	 */
	public ResultSet query(String sql, Object[] params) {
		//1.获取连接
		conn = this.getConn();
		
		//声明定义结果集变量rs
		ResultSet rs = null;
		
		try {
			//2.通过conn和sql获取ps对象
			ps = conn.prepareStatement(sql);
			//3.由于查询不一定有参数【有可能查询全部】，故参数可能为空-->需要对params参数做空值判断
			if(params != null) {
				//对参数数组进行遍历
				for(int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			//4.执行组装好的sql语句
			rs = ps.executeQuery();
			
			//5.若rs被使用 则关闭rs资源
//			rs.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		finally {
//			//无论如何都会执行的代码块
//			//5.关闭资源
//			this.closeAll();
//		}
		
		//返回获取到的结果集
		return rs;
	}
	
}
