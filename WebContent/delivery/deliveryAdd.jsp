<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Delivery"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>新增物流表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>
<form class="layui-form" action="/goodsSystem/delivery/add.do">
  <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">物流编号</label>
    <div class="layui-input-block">
      <input type="text" name="deliveryId" required  lay-verify="required" placeholder="请输入物流编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item" style="width:500px">
  <label class="layui-form-label">物流名称</label>
  <div class="layui-input-block">
      <input type="text" name="deliveryName" required  lay-verify="required" placeholder="请输入物流名称" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">发货地址</label>
    <div class="layui-input-block">
      <input type="text" name="orign" required  lay-verify="required" placeholder="请输入发货地址" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">收货地址</label>
    <div class="layui-input-block">
      <input type="text" name="destination" required  lay-verify="required" placeholder="请输入收货地址" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">运费</label>
    <div class="layui-input-block">
      <input type="text" name="deliveryPrice" required  lay-verify="required" placeholder="请输入运费" autocomplete="off" class="layui-input">
    </div>
  	</div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit" value="提交" class="layui-btn" lay-submit lay-filter="formDemo">
      <input type="reset" class="layui-btn layui-btn-primary" vaule="重置">
    </div>
  </div>
</form>
<%--添加信息展示 --%>
	<%
		String addtip = (String)request.getAttribute("addtip");
		if(addtip!=null){
	%>
		<h6 style="color:red"><%=addtip %></h6>

	<%
		}
	%>
	
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  /*form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });*/
});
</script>
</body>
</html>