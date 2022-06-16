package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Delivery;

public interface DeliveryService {
	//查询全部Delivery信息
	List<Delivery> deliveryInfo();
	
	//新增Delivery信息
	int deliveryAdd(Delivery delivery);
	
	//修改Delivery信息
	int deliveryUpdate(String deliveryName,String orign,String destination,double deliveryPrice, int deliveryId);
	
	//删除Delivery信息
	int deliveryDelete(int deliveryId);
	
	//按条件查询Delivery信息
	List<Delivery> selectById(int id);
}
