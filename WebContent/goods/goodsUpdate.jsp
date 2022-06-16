<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>修改商品表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>

	<form class="layui-form" action="/goodsSystem/goods/update.do">
	    <div class="layui-form-item" style="width:500px">
	        <label class="layui-form-label">商品编号</label>
	        <div class="layui-input-block">
	            <input type="text" name="goodsId" required lay-verify="required" placeholder="请输入要修改的商品编号"
	                autocomplete="off" class="layui-input">
	        </div>
	    </div>
	
	    <div class="layui-form-item" style="width:500px">
	        <label class="layui-form-label">商品名称</label>
	        <div class="layui-input-block">
	            <input type="text" name="goodsName" required lay-verify="required" placeholder="请输入商品名称"
	                autocomplete="off" class="layui-input">
	        </div>
	    </div>
	
	    <div class="layui-form-item" style="width:500px">
	        <label class="layui-form-label">商品价格</label>
	        <div class="layui-input-block">
	            <input type="text" name="goodsPrice" required lay-verify="required" placeholder="请输入商品价格"
	                autocomplete="off" class="layui-input">
	        </div>
	    </div>
	
	
	    <div class="layui-form-item" style="width:500px">
	        <label class="layui-form-label">商品库存</label>
	        <div class="layui-input-block">
	            <input type="text" name="goodsNum" required lay-verify="required" placeholder="请输入商品库存"
	                autocomplete="off" class="layui-input">
	        </div>
	    </div>
	
	    <div class="layui-form-item layui-form-text" style="width:500px">
	        <label class="layui-form-label">商品描述</label>
	        <div class="layui-input-block">
	            <textarea name="description" placeholder="请输入商品描述" class="layui-textarea"></textarea>
	        </div>
	    </div>
	
	    <div class="layui-form-item" style="width:500px">
	        <label class="layui-form-label">卖家编号</label>
	        <div class="layui-input-block">
	            <input type="text" name="sellerId" required lay-verify="required" placeholder="请输入卖家编号"
	                autocomplete="off" class="layui-input">
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
		String goodsUpdateTip = (String)request.getAttribute("goodsUpdateTip");
		if(goodsUpdateTip != null){
	%>
		<h3 style="color:red;"><%=goodsUpdateTip %></h3>
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