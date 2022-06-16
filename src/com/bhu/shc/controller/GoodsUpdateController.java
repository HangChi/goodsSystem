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
 * Servlet implementation class GoodsUpdateController
 */
@WebServlet("/goods/update.do")
public class GoodsUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsUpdateController() {
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
		String goodsName = request.getParameter("goodsName");		
		double goodsPrice = Double.parseDouble(request.getParameter("goodsPrice"));
		int goodsNum = Integer.parseInt(request.getParameter("goodsNum"));
		String description = request.getParameter("description");
		int sellerId = Integer.parseInt(request.getParameter("sellerId"));
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		
		//调用添加数据的业务逻辑
		GoodsService goodsService = new GoodsServiceImp();
		int code = goodsService.goodsUpdate(goodsName, goodsPrice, goodsNum, description, sellerId, goodsId);
		
		//修改成功 跳转到查询全部 修改失败转发回到查询全部页面并返回失败信息
		if(code == 0) {
			request.setAttribute("goodsUpdateTip", "修改失败!");
			request.getRequestDispatcher("goodsUpdate.jsp").forward(request, response);
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
