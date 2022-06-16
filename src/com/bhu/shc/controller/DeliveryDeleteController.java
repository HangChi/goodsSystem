package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.service.DeliveryService;
import com.bhu.shc.service.imp.DeliveryServiceImp;

/**
 * Servlet implementation class DeliveryDeleteController
 */
@WebServlet("/delivery/delete.do")
public class DeliveryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryDeleteController() {
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
		int deliveryId = Integer.parseInt(request.getParameter("deliveryId"));
		DeliveryService deliveryService = new DeliveryServiceImp();
		deliveryService.deliveryDelete(deliveryId);
		response.sendRedirect("/goodsSystem/delivery/info.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
