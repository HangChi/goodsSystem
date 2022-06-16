package com.bhu.shc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhu.shc.entity.Goods;
import com.bhu.shc.util.BaseDao;

public class GoodsMapper {
	
	BaseDao baseDao = new BaseDao();
	
	//查询全部Goods信息方法
	public List<Goods> selectAll(){
		String sql = "select * from goods";
		ResultSet rs = baseDao.query(sql, null);
		List<Goods> list = new ArrayList<Goods>();
		
		try {
			while(rs.next()) {
				int goodsId = rs.getInt(1);
				String goodsName = rs.getString(2);
				double goodsPrice = rs.getDouble(3);
				int goodsNum = rs.getInt(4);
				String description = rs.getString(5);
				int sellerId = rs.getInt(6);
				
				Goods goods = new Goods(goodsId, goodsName, goodsPrice, goodsNum, description, sellerId);
				list.add(goods);
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
	
	//新增Goods信息
	public int insert(Goods goods) {
		String sql = "insert into goods values(?,?,?,?,?,?)";
		Object[] params = {goods.getGoodsId(),goods.getGoodsName(),goods.getGoodsPrice(),
				goods.getGoodsNum(),goods.getDescription(),goods.getSellerId()};
		return baseDao.update(sql, params);
	}
	
	//修改Goods信息
	public int update(String goodsName,double goodsPrice,int goodsNum,String description,int sellerId,int goodsId) {
		String sql = "update goods set good_name=?,good_price=?,good_num=?,description=?,seller_id=? where good_id=?";
		Object[] params = {goodsName,goodsPrice,goodsNum,description,sellerId,goodsId};
		return baseDao.update(sql, params);
	}
	
	//删除Goods信息
	public int delete(int goodsId) {
		String sql = "delete from goods where good_id = ?";
		Object[] params = {goodsId};
		return baseDao.update(sql, params);
	}
	
	//按商品编号查询Goods信息
	public Goods selectById(int id) {
		String sql = "select * from goods where good_id = ?";
		Object[] params = {id};
		ResultSet rs = baseDao.query(sql, params);
		Goods goods = null;
		try {
			while(rs.next()) {
				int goodsId = rs.getInt(1);
				String goodsName = rs.getString(2);
				double goodsPrice = rs.getDouble(3);
				int goodsNum = rs.getInt(4);
				String description = rs.getString(5);
				int sellerId = rs.getInt(6);
				
				goods = new Goods(goodsId, goodsName, goodsPrice, goodsNum, description, sellerId);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			baseDao.closeAll();
		}
		return goods;
	}
	
	//按商品名称模糊查询Goods信息
	public List<Goods> selectByName(String name) {
		String sql = "select * from goods where good_name like ?";
		Object[] params = {name};
		ResultSet rs = baseDao.query(sql, params);
		List<Goods> list = new ArrayList<Goods>();
		try {
			while(rs.next()) {
				int goodsId = rs.getInt(1);
				String goodsName = rs.getString(2);
				double goodsPrice = rs.getDouble(3);
				int goodsNum = rs.getInt(4);
				String description = rs.getString(5);
				int sellerId = rs.getInt(6);
				
				Goods goods = new Goods(goodsId, goodsName, goodsPrice, goodsNum, description, sellerId);
				list.add(goods);
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
