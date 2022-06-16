package com.bhu.shc.service.imp;

import java.util.List;

import com.bhu.shc.entity.Goods;
import com.bhu.shc.mapper.GoodsMapper;
import com.bhu.shc.service.GoodsService;

public class GoodsServiceImp implements GoodsService{

	GoodsMapper goodsMapper = new GoodsMapper();
	
	@Override
	public List<Goods> goodsInfo() {
		// TODO Auto-generated method stub
		return goodsMapper.selectAll();
	}

	@Override
	public int goodsAdd(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.insert(goods);
	}

	@Override
	public int goodsUpdate(String goodsName,double goodsPrice,int goodsNum,String description,int sellerId,int goodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.update(goodsName, goodsPrice, goodsNum, description, sellerId, goodsId);
	}

	@Override
	public int goodsDelete(int goodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.delete(goodsId);
	}

	@Override
	public Goods selectById(int id) {
		// TODO Auto-generated method stub
		return goodsMapper.selectById(id);
	}

	@Override
	public List<Goods> selectByName(String name) {
		// TODO Auto-generated method stub
		return goodsMapper.selectByName(name);
	}

}
