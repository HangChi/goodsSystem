package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Sellers;
import com.bhu.shc.mapper.SellerMapper;
import com.bhu.shc.service.SellerService;

public class SellerServiceImp implements SellerService{

	SellerMapper sellerMapper = new SellerMapper();
	
	@Override
	public List<Sellers> sellerInfo() {
		// TODO Auto-generated method stub
		return sellerMapper.selectAll();
	}

	@Override
	public int sellerAdd(Sellers seller) {
		// TODO Auto-generated method stub
		return sellerMapper.insert(seller);
	}

	@Override
	public int sellerUpdate(String sellerName,String sellerAddr,String sellerTele, String certification,int sellerId) {
		// TODO Auto-generated method stub
		return sellerMapper.update(sellerName, sellerAddr, sellerTele, certification, sellerId);
	}

	@Override
	public int sellerDelete(int sellerId) {
		// TODO Auto-generated method stub
		return sellerMapper.delete(sellerId);
	}

	@Override
	public List<Sellers> selectById(int id) {
		// TODO Auto-generated method stub
		return sellerMapper.selectById(id);
	}

}
