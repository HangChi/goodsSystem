<%@page import="com.bhu.shc.mapper.BuyerMapper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Sellers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>卖家信息表</title>
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
	    <th style="text-align:center;">卖家编号</th>
	    <th style="text-align:center;">卖家姓名</th>
	    <th style="text-align:center;">卖家地址</th>
	    <th style="text-align:center;">卖家电话</th>
	    <th style="text-align:center;">营业执照</th>
	    <th colspan="2" style="text-align:center;">操作</th>
	  </tr> 
	</thead>
	<tbody>
	<%
		List<Sellers> list = (ArrayList)request.getAttribute("list");
		for(Sellers seller:list){
	%>
			<tr>
				<td><%=seller.getSellerId() %></td>
				<td><%=seller.getSellerName() %></td>
				<td><%=seller.getSellerAddr() %></td>
				<td><%=seller.getSellerTele() %></td>
				<td><%=seller.getCertification() %></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-danger" 
				href="javascript:confirm(<%=seller.getSellerId() %>)">删除</a></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-normal" 
				href="/goodsSystem/seller/sellerUpdate.jsp" target="myif">修改</a></td>
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
				  window.location.href = "/goodsSystem/seller/delete.do?sellerId=" + a;
				}, function(){
				});
			});            
		}
	</script>
	
</body>
</html>