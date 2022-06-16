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
 * Servlet implementation class OrderUpdateController
 */
@WebServlet("/order/update.do")
public class OrderUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderUpdateController() {
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
		String remark = request.getParameter("remark");	
		String orderStmt = request.getParameter("orderStmt");
		int deliveryId = Integer.parseInt(request.getParameter("deliveryId"));
		
		//调用修改数据的业务逻辑
		OrderService orderService = new OrderServiceImp();
		int code = orderService.deliveryUpdate(remark, orderStmt, deliveryId, orderId);
		
		//修改成功 跳转到查询全部 添加失败转发回到修改页面
		if(code == 0) {
			request.setAttribute("orderUpdateUpdateTip", "添加失败!");
			request.getRequestDispatcher("orderUpdate.jsp").forward(request, response);
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
