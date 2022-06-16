package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhu.shc.entity.Users;
import com.bhu.shc.mapper.UserMapper;
import com.bhu.shc.service.UserService;
import com.bhu.shc.service.imp.UserServiceImp;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout.do")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//1.获取请求数据
		String userName = request.getParameter("name");
		
		//2.调用注销账号的逻辑功能
		UserService userService = new UserServiceImp();
//		Users user = new UserMapper().selectByName(userName);
		int code = userService.logout(userName);
		
		if(code == 0) {
			request.setAttribute("logout_msg", "注销失败，请重试！！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.setAttribute("logout_msg", "注销成功！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
