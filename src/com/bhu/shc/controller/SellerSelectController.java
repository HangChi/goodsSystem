package com.bhu.shc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhu.shc.entity.Sellers;
import com.bhu.shc.service.SellerService;
import com.bhu.shc.service.imp.SellerServiceImp;

/**
 * Servlet implementation class SellerSelectController
 */
@WebServlet("/seller/select.do")
public class SellerSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerSelectController() {
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
		int sellerId = Integer.parseInt(request.getParameter("id"));
		
		//调用条件查询的业务逻辑
		SellerService sellerService = new SellerServiceImp();
		List<Sellers> list = sellerService.selectById(sellerId);
		HttpSession httpSession = request.getSession();
		
		//查询成功 跳转到新的商品信息界面  查询失败转发回到商品信息页面
		if(list.size() == 0) {
			httpSession.setAttribute("sellerSelectTip", "查询失败!");
			request.getRequestDispatcher("info.do").forward(request, response);
		}else {
			request.setAttribute("list", list);
			request.getRequestDispatcher("selectInfo.jsp").forward(request, response);
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
