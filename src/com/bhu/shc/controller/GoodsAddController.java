package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.entity.Goods;
import com.bhu.shc.service.GoodsService;
import com.bhu.shc.service.imp.GoodsServiceImp;

/**
 * Servlet implementation class GoodsAddController
 */
@WebServlet("/goods/add.do")
public class GoodsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取请求数据
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		String goodsName = request.getParameter("goodsName");		
		double goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		String description = request.getParameter("description");
		int sellerId = Integer.parseInt(request.getParameter("sellerId"));
		Goods goods = new Goods(goodsId, goodsName, goodsPrice, goodsNum, description, sellerId);
		
		//调用添加数据的业务逻辑
		GoodsService goodsService = new GoodsServiceImp();
		int code = goodsService.goodsAdd(goods);
		
		//添加成功 跳转到查询 添加失败转发回到添加页面
		if(code == 0) {
			request.setAttribute("addtip", "添加失败!");
			request.getRequestDispatcher("goodsAdd.jsp").forward(request, response);
		}else {
			response.sendRedirect("/goodsSystem/goods/info.do");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
