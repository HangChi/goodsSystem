<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Buyers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>新增卖家表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>
<form class="layui-form" action="/goodsSystem/seller/add.do">
  <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">卖家编号</label>
    <div class="layui-input-block">
      <input type="text" name="sellerId" required  lay-verify="required" placeholder="请输入卖家编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item" style="width:500px">
  <label class="layui-form-label">卖家姓名</label>
  <div class="layui-input-block">
      <input type="text" name="sellerName" required  lay-verify="required" placeholder="请输入卖家姓名" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">卖家地址</label>
    <div class="layui-input-block">
      <input type="text" name="sellerAddr" required  lay-verify="required" placeholder="请输入卖家地址" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">卖家电话</label>
    <div class="layui-input-block">
      <input type="text" name="sellerTele" required  lay-verify="required" placeholder="请输入卖家电话" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">营业执照</label>
    <div class="layui-input-block">
      <input type="text" name="certification" required  lay-verify="required" placeholder="请输入营业执照" autocomplete="off" class="layui-input">
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