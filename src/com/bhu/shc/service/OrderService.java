package com.bhu.shc.service;

import java.util.List;

import com.bhu.shc.entity.Orders;

public interface OrderService {
	
	//查询全部Orders信息
	List<Orders> orderInfo();
	
	//新增Orders信息
	int orderAdd(Orders order);
	
	//修改Orders信息
	int deliveryUpdate(String remark,String orderStmt,int deliveryId,int orderId);
	
	//删除Orders信息
	int orderDelete(int orderId);
	
	//按条件查询Orders信息
	List<Orders> selectById(int id);
}
