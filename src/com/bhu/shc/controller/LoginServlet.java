package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhu.shc.entity.Users;
import com.bhu.shc.mapper.UserMapper;
import com.bhu.shc.service.UserService;
import com.bhu.shc.service.imp.UserServiceImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String password = request.getParameter("password");
		//获取复选框数据
        String remember = request.getParameter("remember");

		//2.调用登录的逻辑功能
		UserService userService = new UserServiceImp();
		Users user = new UserMapper().selectByName(userName);
		int code = userService.login(userName, password);
		
		//3.根据登录结果不同 实现不同的跳转
		switch(code) {
		case 404:
			request.setAttribute("login_msg", "该用户不存在，请重新输入！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case 500:
			request.setAttribute("login_msg", "密码错误，请重新输入！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case 200://页面跳转  响应重定向 重新请求主页面main.jsp
//			response.sendRedirect("/epidemicSystem/main.jsp");
			//判断用户是否勾选记住我
            if("1".equals(remember)){
                //勾选了，发送Cookie
                //1. 创建Cookie对象
                Cookie c_username = new Cookie("name",userName);
                Cookie c_password = new Cookie("password",password);
                // 设置Cookie的存活时间
                c_username.setMaxAge( 60 * 60 * 24);
                c_password.setMaxAge( 60 * 60 * 24);
                //2. 发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //将登陆成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            response.sendRedirect("/goodsSystem/main.jsp");

			break;
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
