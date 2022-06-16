package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.entity.Sellers;
import com.bhu.shc.service.SellerService;
import com.bhu.shc.service.imp.SellerServiceImp;

/**
 * Servlet implementation class SellerUpdateController
 */
@WebServlet("/seller/update.do")
public class SellerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerUpdateController() {
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
		String sellerName = request.getParameter("sellerName");
		String sellerAddr = request.getParameter("sellerAddr");	
		String sellerTele = request.getParameter("sellerTele");	
		String certification = request.getParameter("certification");	
		int sellerId = Integer.parseInt(request.getParameter("sellerId"));
		
		//调用添加数据的业务逻辑
		SellerService sellerService = new SellerServiceImp();
		int code = sellerService.sellerUpdate(sellerName, sellerAddr, sellerTele, certification, sellerId);
		
		//添加成功 跳转到查询 添加失败转发回到添加页面
		if(code == 0) {
			request.setAttribute("sellerUpdateTip", "修改失败!");
			request.getRequestDispatcher("sellerUpdate.jsp").forward(request, response);
		}else {
			response.sendRedirect("/goodsSystem/seller/info.do");
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
