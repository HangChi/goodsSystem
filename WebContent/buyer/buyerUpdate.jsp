<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Buyers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>修改买家表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>

<form class="layui-form" action="/goodsSystem/buyer/update.do">
  <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">买家编号</label>
    <div class="layui-input-block">
      <input type="text" name="buyerId" required  lay-verify="required" placeholder="请输入要修改的买家编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item" style="width:500px">
  <label class="layui-form-label">买家姓名</label>
  <div class="layui-input-block">
      <input type="text" name="buyerName" required  lay-verify="required" placeholder="请输入买家姓名" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">买家地址</label>
    <div class="layui-input-block">
      <input type="text" name="buyerAddr" required  lay-verify="required" placeholder="请输入买家地址" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">买家电话</label>
    <div class="layui-input-block">
      <input type="text" name="buyerTele" required  lay-verify="required" placeholder="请输入买家电话" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">订单数量</label>
    <div class="layui-input-block">
      <input type="text" name="orderNum" required  lay-verify="required" placeholder="请输入订单数量" autocomplete="off" class="layui-input">
    </div>
  	</div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit" value="提交" class="layui-btn" lay-submit lay-filter="formDemo">
      <input type="reset" class="layui-btn layui-btn-primary" vaule="重置">
    </div>
  </div>
</form>
	
	<!-- 修改失败信息 -->
	<%
		String buyerUpdateTip = (String)request.getAttribute("buyerUpdateTip");
		if(buyerUpdateTip != null){
	%>
		<h3 style="color:red;"><%=buyerUpdateTip %></h3>
	<%
		}
	%>



	<script>
        //Demo
        layui.use('form', function () {
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