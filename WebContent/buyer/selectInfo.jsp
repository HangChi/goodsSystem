<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Buyers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>查询买家信息表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>
<table class="layui-table" style="text-align:center;">
	 <colgroup>
	   <col width="100">
	   <col width="150">
	   <col>
	 </colgroup>
	<thead>
	  <tr>
	    <th style="text-align:center;">买家编号</th>
	    <th style="text-align:center;">买家姓名</th>
	    <th style="text-align:center;">买家地址</th>
	    <th style="text-align:center;">买家电话</th>
	    <th style="text-align:center;">购买数量</th>
	    <th colspan="2" style="text-align:center;">操作</th>
	  </tr> 
	</thead>
	<tbody>
	<%
		List<Buyers> list = (ArrayList)request.getAttribute("list");
		for(Buyers buyer:list){
	%>
			<tr>
				<td><%=buyer.getBuyerId() %></td>
				<td><%=buyer.getBuyerName() %></td>
				<td><%=buyer.getBuyerAddr() %></td>
				<td><%=buyer.getBuyerTele() %></td>
				<td><%=buyer.getOrderNum() %></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-danger" 
				href="javascript:confirm(<%=buyer.getBuyerId() %>)">删除</a></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-normal" 
				href="/goodsSystem/buyer/buyerUpdate.jsp" target="myif">修改</a></td>
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
				  window.location.href = "/goodsSystem/buyer/delete.do?buyerId=" + a;
				}, function(){
				});
			});            
		}
	</script>
	
</body>
</html>