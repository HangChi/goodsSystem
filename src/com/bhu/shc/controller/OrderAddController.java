package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.entity.Orders;
import com.bhu.shc.service.OrderService;
import com.bhu.shc.service.imp.OrderServiceImp;

/**
 * Servlet implementation class OrderAddController
 */
@WebServlet("/order/add.do")
public class OrderAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAddController() {
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
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		String orderName = request.getParameter("orderName");
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		String remark = request.getParameter("remark");	
		Double orderSum = Double.parseDouble(request.getParameter("orderSum"));
		String orderDate = request.getParameter("orderDate");	
		String orderStmt = request.getParameter("orderStmt");
		int buyerId = Integer.parseInt(request.getParameter("buyerId"));
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int deliveryId = Integer.parseInt(request.getParameter("deliveryId"));
		Orders order = new Orders(orderId, orderName, orderNum, remark, orderSum, orderDate, orderStmt, buyerId, goodsId, deliveryId);
		
		//调用添加数据的业务逻辑
		OrderService orderService = new OrderServiceImp();
		int code = orderService.orderAdd(order);
		
		//添加成功 跳转到查询 添加失败转发回到添加页面
		if(code == 0) {
			request.setAttribute("addtip", "添加失败!");
			request.getRequestDispatcher("orderAdd.jsp").forward(request, response);
		}else {
			response.sendRedirect("/goodsSystem/order/info.do");
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
