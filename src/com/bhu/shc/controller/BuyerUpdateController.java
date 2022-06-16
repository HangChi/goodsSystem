package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.entity.Buyers;
import com.bhu.shc.service.BuyerService;
import com.bhu.shc.service.imp.BuyerServiceImp;

/**
 * Servlet implementation class BuyerUpdateController
 */
@WebServlet("/buyer/update.do")
public class BuyerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerUpdateController() {
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
		String buyerName = request.getParameter("buyerName");
		String buyerAddr = request.getParameter("buyerAddr");	
		String buyerTele = request.getParameter("buyerTele");	
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		int buyerId = Integer.parseInt(request.getParameter("buyerId"));
		
		//调用添加数据的业务逻辑
		BuyerService buyerService = new BuyerServiceImp();
		int code = buyerService.buyerUpdate(buyerName, buyerAddr, buyerTele, orderNum, buyerId);
		
		//添加成功 跳转到查询 添加失败转发回到添加页面
		if(code == 0) {
			request.setAttribute("buyerUpdateTip", "修改失败!");
			request.getRequestDispatcher("buyerUpdate.jsp").forward(request, response);
		}else {
			response.sendRedirect("/goodsSystem/buyer/info.do");
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
