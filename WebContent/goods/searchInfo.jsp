<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>查询商品信息表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>
	
	<table class="layui-table" style="text-align:center;">
	 <colgroup>
	   <col width="150">
	   <col width="200">
	   <col>
	 </colgroup>
	<thead>
	
	<tbody>

	  <tr>
	    <th style="text-align:center;">商品编号</th>
	    <th style="text-align:center;">商品名称</th>
	    <th style="text-align:center;">商品价格</th>
	    <th style="text-align:center;">商品数量</th>
	    <th style="text-align:center;">商品描述</th>
	    <th style="text-align:center;">卖家编号</th>
	     <th colspan="2" style="text-align:center;">操作</th>
	     
	  </tr> 
	  
	
	</thead>
	<tbody>
	<%
		List<Goods> list = (ArrayList)request.getAttribute("list");
		for(Goods goods:list){
	%>
			<tr>
				<td><%=goods.getGoodsId() %></td>
				<td><%=goods.getGoodsName() %></td>
				<td><%=goods.getGoodsPrice() %></td>
				<td><%=goods.getGoodsNum() %></td>
				<td><%=goods.getDescription() %></td>
				<td><%=goods.getSellerId() %></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-danger" 
				href="javascript:confirm(<%=goods.getGoodsId() %>)">删除</a></td>
				<!-- <td><a class="layui-btn layui-btn-radius" 
				href="/goodsSystem/goods/delete.do?
				goodsId=">删除</a></td> -->
				<td><a class="layui-btn layui-btn-radius layui-btn-normal" 
				href="/goodsSystem/goods/goodsUpdate.jsp" target="myif">修改</a></td>
			</tr>
	<%
		}
	%>
	</tbody>
	
	</table>
	<script>
		//Demo
		layui.use('form', function(){
	  	var form = layui.form;
		});
	  	
		function confirm(a){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认删除吗？', {
				  btn: ['确定','取消'] //按钮
				}, function(){
				  window.location.href = "/goodsSystem/goods/delete.do?goodsId=" + a;
				}, function(){
				});
			});            
		}
	</script>
</body>
</html>