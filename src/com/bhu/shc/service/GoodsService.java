package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Goods;

public interface GoodsService {
	//查询全部Goods信息
	List<Goods> goodsInfo();
	
	//新增Goods信息
	int goodsAdd(Goods goods);
	
	//修改Goods信息
	int goodsUpdate(String goodsName,double goodsPrice,int goodsNum,String description,int sellerId,int goodsId);
	
	//删除Goods信息
	int goodsDelete(int goodsId);
	
	//按商品编号查询Goods信息
	Goods selectById(int id);
	
	//按商品名称模糊
	List<Goods> selectByName(String name);
}
