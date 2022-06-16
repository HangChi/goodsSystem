package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Orders;
import com.bhu.shc.util.BaseDao;

public class OrderMapper {
	
	BaseDao baseDao = new BaseDao();
	
	//查询全部Orders信息
	public List<Orders> selectAll(){
		String sql = "select * from orders";
		ResultSet rs = baseDao.query(sql, null);
		List<Orders> list = new ArrayList<Orders>();
		
		try {
			//处理结果集
			while(rs.next()) {
				int orderId = rs.getInt(1);
				String orderName = rs.getString(2);
				int orderNum = rs.getInt(3);
				String remark = rs.getString(4);
				double orderSum = rs.getDouble(5);
				String orderDate = rs.getString(6);
				String orderStmt = rs.getString(7);
				int buyerId = rs.getInt(8);
				int goodId = rs.getInt(9);
				int deliveryId = rs.getInt(10);
				
				Orders order = new Orders(orderId, orderName, orderNum, remark, orderSum, orderDate, orderStmt, buyerId, goodId, deliveryId);
				list.add(order);
			}
			//关闭rs资源
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭所有资源
			baseDao.closeAll();
		}
		return list;
	}
	
	//新增Orders信息
	public int insert(Orders order) {
		String sql = "insert into orders values(?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)";
		Object[] params = {order.getOrderId(),order.getOrderName(),order.getOrderNum(),
				order.getRemark(),order.getOrderSum(),order.getOrderDate(),order.getOrderStmt(),
				order.getBuyerId(),order.getGoodId(),order.getDeliveryId()};
		return baseDao.update(sql, params);
	}
	
	//修改Orders信息
	public int update(String remark,String orderStmt,int deliveryId,int orderId) {
		String sql = "update orders set remark=?,statement=?,delivery_id=? where order_id = ?";
		Object[] params = {remark,orderStmt,deliveryId,orderId};
		return baseDao.update(sql, params);
	}
	
	//删除Orders信息
	public int delete(int orderId) {
		String sql = "delete from orders where order_id = ?";
		Object[] params = {orderId};
		return baseDao.update(sql, params);
	}
	
	//按指定条件查询
	public List<Orders> selectById(int id) {
		String sql = "select * from orders where order_id = ?";
		Object[] params = {id};
		List<Orders> list = new ArrayList<Orders>();
		ResultSet rs = baseDao.query(sql, params);
		
		try {
			while(rs.next()) {
				int orderId = rs.getInt(1);
				String orderName = rs.getString(2);
				int orderNum = rs.getInt(3);
				String remark = rs.getString(4);
				double orderSum = rs.getDouble(5);
				String orderDate = rs.getString(6);
				String orderStmt = rs.getString(7);
				int buyerId = rs.getInt(8);
				int goodId = rs.getInt(9);
				int deliveryId = rs.getInt(10);
				
				Orders order = new Orders(orderId, orderName, orderNum, remark, orderSum, orderDate, orderStmt, buyerId, goodId, deliveryId);
				list.add(order);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return list;
	}
}
