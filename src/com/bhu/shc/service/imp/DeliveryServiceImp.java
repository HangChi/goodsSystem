package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Delivery;
import com.bhu.shc.mapper.DeliveryMapper;
import com.bhu.shc.service.DeliveryService;

public class DeliveryServiceImp implements DeliveryService{

	DeliveryMapper deliveryMapper = new DeliveryMapper();
	
	@Override
	public List<Delivery> deliveryInfo() {
		// TODO Auto-generated method stub
		return deliveryMapper.selectAll();
	}

	@Override
	public int deliveryAdd(Delivery delivery) {
		// TODO Auto-generated method stub
		return deliveryMapper.insert(delivery);
	}

	@Override
	public int deliveryUpdate(String deliveryName,String orign,String destination,double deliveryPrice, int deliveryId) {
		// TODO Auto-generated method stub
		return deliveryMapper.update(deliveryName, orign, destination, deliveryPrice, deliveryId);
	}

	@Override
	public int deliveryDelete(int deliveryId) {
		// TODO Auto-generated method stub
		return deliveryMapper.delete(deliveryId);
	}

	@Override
	public List<Delivery> selectById(int id) {
		// TODO Auto-generated method stub
		return deliveryMapper.selectById(id);
	}

}
