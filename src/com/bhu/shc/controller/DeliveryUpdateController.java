package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.entity.Delivery;
import com.bhu.shc.service.DeliveryService;
import com.bhu.shc.service.imp.DeliveryServiceImp;

/**
 * Servlet implementation class DeliveryUpdateController
 */
@WebServlet("/delivery/update.do")
public class DeliveryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryUpdateController() {
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
		String deliveryName = request.getParameter("deliveryName");
		String orign = request.getParameter("orign");	
		String destination = request.getParameter("destination");	
		Double deliveryPrice = Double.parseDouble(request.getParameter("deliveryPrice"));
		int deliveryId = Integer.parseInt(request.getParameter("deliveryId"));
		
		//调用添加数据的业务逻辑
		DeliveryService deliveryService = new DeliveryServiceImp();
		int code = deliveryService.deliveryUpdate(deliveryName, orign, destination, deliveryPrice, deliveryId);
		
		//添加成功 跳转到查询 添加失败转发回到添加页面
		if(code == 0) {
			request.setAttribute("deliveryUpdateTip", "添加失败!");
			request.getRequestDispatcher("deliveryUpdate.jsp").forward(request, response);
		}else {
			response.sendRedirect("/goodsSystem/delivery/info.do");
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
