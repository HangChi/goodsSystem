package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Orders;
import com.bhu.shc.mapper.OrderMapper;
import com.bhu.shc.service.OrderService;

public class OrderServiceImp implements OrderService{

	OrderMapper orderMapper = new OrderMapper();
	
	@Override
	public List<Orders> orderInfo() {
		// TODO Auto-generated method stub
		return orderMapper.selectAll();
	}

	@Override
	public int orderAdd(Orders order) {
		// TODO Auto-generated method stub
		return orderMapper.insert(order);
	}

	@Override
	public int deliveryUpdate(String remark,String orderStmt,int deliveryId,int orderId) {
		// TODO Auto-generated method stub
		return orderMapper.update(remark, orderStmt, deliveryId, orderId);
	}

	@Override
	public int orderDelete(int orderId) {
		// TODO Auto-generated method stub
		return orderMapper.delete(orderId);
	}

	@Override
	public List<Orders> selectById(int id) {
		// TODO Auto-generated method stub
		return orderMapper.selectById(id);
	}

}
