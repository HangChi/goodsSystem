package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Sellers;

public interface SellerService {
	//查询全部Sellers信息
	List<Sellers> sellerInfo();
	
	//新增Sellers信息
	int sellerAdd(Sellers seller);
	
	//修改Sellers信息
	int sellerUpdate(String sellerName,String sellerAddr,String sellerTele, String certification,int sellerId);
	
	//删除Sellers信息
	int sellerDelete(int sellerId);
	
	//按条件查询Sellers信息
	List<Sellers> selectById(int id);
}
