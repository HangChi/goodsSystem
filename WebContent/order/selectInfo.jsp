<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Orders"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>订单信息表</title>
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
	    <th style="text-align:center;">订单编号</th>
	    <th style="text-align:center;">订单名称</th>
	    <th style="text-align:center;">订单数量</th>
	    <th style="text-align:center;">备注</th>
	    <th style="text-align:center;">支付金额</th>
	    <th style="text-align:center;">下单日期</th>
	    <th style="text-align:center;">订单状态</th>
	    <th style="text-align:center;">买家编号</th>
	    <th style="text-align:center;">商品编号</th>
	    <th style="text-align:center;">物流编号</th>
	    <th colspan="2" style="text-align:center;">操作</th>
	  </tr> 
	</thead>
	<tbody>
	<%
		List<Orders> list = (ArrayList)request.getAttribute("list");
		for(Orders order:list){
	%>
			<tr>
				<td><%=order.getOrderId() %></td>
				<td><%=order.getOrderName() %></td>
				<td><%=order.getOrderNum() %></td>
				<td><%=order.getRemark() %></td>
				<td><%=order.getOrderSum() %></td>
				<td><%=order.getOrderDate() %></td>
				<td><%=order.getOrderStmt() %></td>
				<td><%=order.getBuyerId() %></td>
				<td><%=order.getGoodId() %></td>
				<td><%=order.getDeliveryId() %></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-danger" 
				href="javascript:confirm(<%=order.getOrderId() %>)">删除</a></td>
				<td><a class="layui-btn layui-btn-radius layui-btn-normal" 
				href="/goodsSystem/order/orderUpdate.jsp" target="myif">修改</a></td>	
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
				  window.location.href = "/goodsSystem/order/delete.do?orderId=" + a;
				}, function(){
				});
			});            
		}
	</script>
</body>
</html>