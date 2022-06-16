package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Buyers;

public interface BuyerService {
	
	//查询全部buyers信息
	List<Buyers> buyerInfo();
	
	//新增buyers信息
	int buyerAdd(Buyers buyer);
	
	//修改buyers信息
	int buyerUpdate(String buyerName,String buyerAddr,String buyerTele,int orderNum,int buyerId);
	
	//删除buyers信息
	int buyerDelete(int buyerId);
	
	//按条件查询buyers信息
	List<Buyers> selectById(int id);
	
}
