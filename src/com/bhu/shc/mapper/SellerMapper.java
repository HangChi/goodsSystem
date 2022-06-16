package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Sellers;
import com.bhu.shc.util.BaseDao;

public class SellerMapper {
	
	BaseDao baseDao = new BaseDao();
	
	//查询全部sellers信息
	public List<Sellers> selectAll(){
		String sql = "select * from sellers";
		ResultSet rs = baseDao.query(sql, null);
		List<Sellers> list = new ArrayList<Sellers>();
		try {
			while(rs.next()) {
				int sellerId = rs.getInt(1);
				String sellerName = rs.getString(2);
				String sellerAddr = rs.getString(3);
				String sellerTele = rs.getString(4);
				String certification = rs.getString(5);
				
				Sellers seller = new Sellers(sellerId, sellerName, sellerAddr, sellerTele, certification);
				list.add(seller);
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
	
	//新增Sellers信息
	public int insert(Sellers seller) {
		String sql = "insert into sellers values(?,?,?,?,?)";
		Object[] params = {seller.getSellerId(),seller.getSellerName(),seller.getSellerAddr(),
				seller.getSellerTele(),seller.getCertification()};
		return baseDao.update(sql, params);
	}
	
	//修改Sellers信息
	public int update(String sellerName,String sellerAddr,String sellerTele, String certification,int sellerId) {
		String sql = "update sellers set seller_name=?,seller_addr=?,seller_tele=?,certification=? where seller_id=?";
		Object[] params = {sellerName,sellerAddr,sellerTele,certification,sellerId};
		return baseDao.update(sql, params);
	}
	
	//删除Sellers信息
	public int delete(int sellerId) {
		String sql = "delete from sellers where seller_id = ?";
		Object[] params = {sellerId};
		return baseDao.update(sql, params);
	}
	
	//条件查询Sellers信息
	public List<Sellers> selectById(int id) {
		String sql = "select * from sellers where seller_id = ?";
		Object[] params = {id};
		ResultSet rs = baseDao.query(sql, params);
		List<Sellers> list = new ArrayList<Sellers>();
		try {
			while(rs.next()) {
				int sellerId = rs.getInt(1);
				String sellerName = rs.getString(2);
				String sellerAddr = rs.getString(3);
				String sellerTele = rs.getString(4);
				String certification = rs.getString(5);
				Sellers seller = new Sellers(sellerId, sellerName, sellerAddr, sellerTele, certification);
				list.add(seller);
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
