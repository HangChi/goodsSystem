package com.bhu.shc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhu.shc.entity.Goods;
import com.bhu.shc.service.GoodsService;
import com.bhu.shc.service.imp.GoodsServiceImp;

/**
 * Servlet implementation class GoodsSelectByIdController
 */
@WebServlet("/goods/select.do")
public class GoodsSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsSelectController() {
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
		String name = request.getParameter("name");
		//拼接字符串实现模糊查询
		String goodsName = "%" + name + "%";
		
		//调用条件查询的业务逻辑
		GoodsService goodsService = new GoodsServiceImp();
		List<Goods> list = goodsService.selectByName(goodsName);
		HttpSession httpSession = request.getSession();
		
		//查询成功 跳转到新的商品信息界面  查询失败转发回到商品信息页面
		if(list.size() == 0) {
//			request.setAttribute("selecttip", "查询失败!");
			httpSession.setAttribute("selecttip", "查询失败!");
			request.getRequestDispatcher("info.do").forward(request, response);
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("searchInfo.jsp").forward(request, response);
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
