package com.bhu.shc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bhu.shc.entity.Goods;
import com.bhu.shc.service.GoodsService;
import com.bhu.shc.service.imp.GoodsServiceImp;




/**
 * Servlet implementation class GoodsInfoController
 */
@WebServlet("/goods/info.do")
public class GoodsInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsInfoController() {
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
		
		//1.获取请求数据(无)
		//2.调用业务逻辑代码
		GoodsService goodsService = new GoodsServiceImp();
		List<Goods> list = goodsService.goodsInfo();
		
		//3.页面跳转 请求转发（通过数据传递）
		//3.1 给请求添加  名字为list的属性  属性值为list
//		String jsonString = JSON.toJSONString(list);

		if(list.size() == 0) {
			request.setAttribute("infotip", "获取数据失败");
		}else {
			request.setAttribute("list", list);
		}
		
		//3.2 通过转发器  转发请求到指定的文件文件路径下 
		request.getRequestDispatcher("goodsInfo.jsp").forward(request, response);
//		response.getWriter().write(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
