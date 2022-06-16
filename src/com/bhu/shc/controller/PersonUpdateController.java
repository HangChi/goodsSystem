package com.bhu.shc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhu.shc.entity.Person;
import com.bhu.shc.mapper.PersonMapper;

/**
 * Servlet implementation class PersonUpdateController
 */
@WebServlet("/person/update.do")
public class PersonUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置字符集
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取请求数据
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		
		//2.调用业务逻辑代码
		PersonMapper personMapper = new PersonMapper();
		int code = personMapper.updateDesc(desc, name);
		
		HttpSession httpSession = request.getSession();
		
		//3.页面跳转 请求转发（通过数据传递）
		//3.1 给请求添加  名字为list的属性  属性值为list
		if(code == 0) {
			//3.2 通过转发器  转发请求到指定的文件文件路径下 
//					request.setAttribute("infotip", "获取数据失败");
			httpSession.setAttribute("upadtetip", "更新数据失败");
			request.getRequestDispatcher("personInfo.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("personInfo.jsp").forward(request, response);
			
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
