<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Delivery"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>物流信息表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>

<form action="/goodsSystem/delivery/select.do">
<li>
	<div class="layui-input-block" style="float: left; position: relative;">
	    <label class="layui-form-label">物流搜索</label>
	  <input style="width: 500px; margin-bottom: 10px;margin-right: 10px;" type="text" name="id" lay-verify="required" placeholder="请输入物流编号" autocomplete="off" class="layui-input">
	</div>
	<input class="layui-btn" type="submit" style="float: left;" value="搜索">
</li>
</form>

	<!-- 获取查询失败session -->
	<%
		String deliverySelectTip = (String)session.getAttribute("deliverySelectTip");
		if(deliverySelectTip!=null){
	%>
		<h6 style="color:red;"><%=deliverySelectTip %></h6>
		
	<%
		}
	%>
		

	<%
		String infotip = (String)request.getAttribute("infotip");
		if(infotip!=null){
	%>
		<h1><%=infotip %></h1>
	<%
		}else{
	%>
	<table class="layui-table" style="text-align:center;">
	 <colgroup>
	   <col width="100">
	   <col width="150">
	   <col>
	 </colgroup>
	<thead>
	  <tr>
	    <th style="text-align:center;">物流编号</th>
	    <th style="text-align:center;">物流名称</th>
	    <th style="text-align:center;">发货地址</th>
	    <th style="text-align:center;">收货地址</th>
	    <th style="text-align:center;">运费</th>
	    <th colspan="2" style="text-align:center;">操作</th>
	  </tr> 
	</thead>
	<tbody>
	<%
		List<Delivery> list = (ArrayList)request.getAttribute("list");
		for(Delivery delivery:list){
	%>
			<tr>
				<td><%=delivery.getDeliveryId() %></td>
				<td><%=delivery.getDeliveryName() %></td>
				<td><%=delivery.getOrign() %></td>
				<td><%=delivery.getDestination() %></td>
				<td><%=delivery.getDeliveryPrice() %></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-danger" 
				href="javascript:confirm(<%=delivery.getDeliveryId() %>)">删除</a></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-normal" 
				href="/goodsSystem/delivery/deliveryUpdate.jsp" target="myif">修改</a></td>
			</tr>
	<%
		}
	%>
	  <%
	  session.setAttribute("deliverySelectTip", null);
	  %>
	</tbody>
	</table>
	<%
		}
	%>
	
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
				  window.location.href = "/goodsSystem/delivery/delete.do?deliveryId=" + a;
				}, function(){
				});
			});            
		}
	</script>
	
</body>
</html>