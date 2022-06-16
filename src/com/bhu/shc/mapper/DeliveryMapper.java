package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Delivery;
import com.bhu.shc.util.BaseDao;

public class DeliveryMapper {
	
	BaseDao baseDao = new BaseDao();
	
	//查询全部delivery信息
	public List<Delivery> selectAll(){
		String sql = "select * from delivery";
		ResultSet rs = baseDao.query(sql, null);
		List<Delivery> list = new ArrayList<Delivery>();
		
		try {
			while(rs.next()) {
				int deliveryId = rs.getInt(1);
				String deliveryName = rs.getString(2);
				String orign = rs.getString(3);
				String destination = rs.getString(4);
				double deliveryPrice = rs.getDouble(5);
				
				Delivery delivery = new Delivery(deliveryId, deliveryName, orign, destination, deliveryPrice);
				list.add(delivery);
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
	
	//新增delivery信息
	public int insert(Delivery delivery) {
		String sql = "insert into delivery values(?,?,?,?,?)";
		Object[] params = {delivery.getDeliveryId(),delivery.getDeliveryName(),
				delivery.getOrign(),delivery.getDestination(),delivery.getDeliveryPrice()};
		return baseDao.update(sql, params);
	}
	
	//修改delivery信息
	public int update(String deliveryName,String orign,String destination,double deliveryPrice, int deliveryId) {
		String sql = "update delivery set delivery_name=?,orign=?,destination=?,delivery_price=? where delivery_id = ?";
		Object[] params = {deliveryName,orign,destination,deliveryPrice,deliveryId};
		return baseDao.update(sql, params);
	}

	//删除delivery信息
	public int delete(int deliveryId) {
		String sql = "delete from delivery where delivery_id = ?";
		Object[] params = {deliveryId};
		return baseDao.update(sql, params);
	}
	
	//按条件查询delivery信息
	public List<Delivery> selectById(int id) {
		String sql = "select * from delivery where delivery_id = ?";
		Object[] params = {id};
		ResultSet rs = baseDao.query(sql, params);
		List<Delivery> list = new ArrayList<Delivery>();
		
		try {
			while(rs.next()) {
				int deliveryId = rs.getInt(1);
				String deliveryName = rs.getString(2);
				String orign = rs.getString(3);
				String destination = rs.getString(4);
				double deliveryPrice = rs.getDouble(5);
				
				Delivery delivery = new Delivery(deliveryId, deliveryName, orign, destination, deliveryPrice);
				list.add(delivery);
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
