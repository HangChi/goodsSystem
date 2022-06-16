package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Buyers;
import com.bhu.shc.mapper.BuyerMapper;
import com.bhu.shc.service.BuyerService;

public class BuyerServiceImp implements BuyerService {

	BuyerMapper buyerMapper = new BuyerMapper();
	
	@Override
	public List<Buyers> buyerInfo() {
		// TODO Auto-generated method stub
		return buyerMapper.selectAll();
	}

	@Override
	public int buyerAdd(Buyers buyer) {
		// TODO Auto-generated method stub
		return buyerMapper.insert(buyer);
	}

	@Override
	public int buyerUpdate(String buyerName,String buyerAddr,String buyerTele,int orderNum,int buyerId) {
		// TODO Auto-generated method stub
		return buyerMapper.update(buyerName, buyerAddr, buyerTele, orderNum, buyerId);
	}

	@Override
	public int buyerDelete(int buyerId) {
		// TODO Auto-generated method stub
		return buyerMapper.delete(buyerId);
	}

	@Override
	public List<Buyers> selectById(int id) {
		// TODO Auto-generated method stub
		return buyerMapper.selectById(id);
	}

}
