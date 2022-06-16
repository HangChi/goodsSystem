package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Buyers;
import com.bhu.shc.util.BaseDao;

public class BuyerMapper {
	
	BaseDao baseDao = new BaseDao();
	
	//查询全部Buyers信息方法
	public List<Buyers> selectAll(){
		String sql = "select * from buyers";
		ResultSet rs = baseDao.query(sql, null);
		List<Buyers> list = new ArrayList<Buyers>();
		
		try {
			//处理结果集
			while(rs.next()) {
				int buyerId = rs.getInt(1);
				String buyerName = rs.getString(2);
				String buyerAddr = rs.getString(3);
				String buyerTele = rs.getString(4);
				int orderNum = rs.getInt(5);
				
				Buyers buyer = new Buyers(buyerId, buyerName, buyerAddr, buyerTele, orderNum);
				list.add(buyer);
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
	
	//插入新数据到Buyers方法
	public int insert(Buyers buyer) {
		String sql = "insert into buyers values(?,?,?,?,?)";
		Object[] params = {buyer.getBuyerId(),buyer.getBuyerName(),buyer.getBuyerAddr(),
				buyer.getBuyerTele(),buyer.getOrderNum()};
		return baseDao.update(sql, params);
	}
	
	//修改Buyers信息
	public int update(String buyerName,String buyerAddr,String buyerTele,int orderNum,int buyerId) {
		String sql = "update buyers set buyer_name=?,buyer_addr=?,buyer_tele=?,order_num=? where buyer_id = ?";
		Object[] params = {buyerName,buyerAddr,buyerTele,orderNum,buyerId};
		return baseDao.update(sql, params);
	}
	
	//删除Buyers信息
	public int delete(int buyerId) {
		String sql = "delete from buyers where buyer_id = ?";
		Object[] params = {buyerId};
		return baseDao.update(sql, params);
	}
	
	//按条件查询Buyers
	public List<Buyers> selectById(int id) {
		String sql = "select * from buyers where buyer_id = ?";
		Object[] params = {id};
		ResultSet rs = baseDao.query(sql, params);
		List<Buyers> list = new ArrayList<Buyers>();
		
		try {
			while(rs.next()) {
				int buyerId = rs.getInt(1);
				String buyerName = rs.getString(2);
				String buyerAddr = rs.getString(3);
				String buyerTele = rs.getString(4);
				int orderNum = rs.getInt(5);
				
				Buyers buyer = new Buyers(buyerId, buyerName, buyerAddr, buyerTele, orderNum);
				list.add(buyer);
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
