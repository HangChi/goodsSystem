<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>新增订单信息</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>
<form class="layui-form" action="/goodsSystem/order/add.do">
  <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">订单编号</label>
    <div class="layui-input-block">
      <input type="text" name="orderId" required  lay-verify="required" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item" style="width:500px">
  <label class="layui-form-label">订单名称</label>
  <div class="layui-input-block">
      <input type="text" name="orderName" required  lay-verify="required" placeholder="请输入订单名称" autocomplete="off" class="layui-input">
  </div>
  </div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">购买数量</label>
    <div class="layui-input-block">
      <input type="text" name="orderNum" required  lay-verify="required" placeholder="请输入购买数量" autocomplete="off" class="layui-input">
    </div>
    </div>
    
    
   	<div class="layui-form-item layui-form-text" style="width:500px">
   	<label class="layui-form-label">备注</label>
	  <div class="layui-input-block">
	    <textarea name="remark" placeholder="请输入订单备注" class="layui-textarea"></textarea>
	  </div>
	</div>
    
    <div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">支付金额</label>
    <div class="layui-input-block">
      <input type="text" name="orderSum" required  lay-verify="required" placeholder="请输入支付金额" autocomplete="off" class="layui-input">
    </div>
  	</div>
  	
	<div class="layui-form-item" style="width:500px">
	<label class="layui-form-label">交易日期</label>
	<div class="layui-input-block">
	    <input type="text" name="orderDate" required  lay-verify="required" placeholder="请输入交易日期(yyyy-mm-dd)" autocomplete="off" class="layui-input">
	</div>
	</div>
	
	<div class="layui-form-item" style="width:500px">
    <label class="layui-form-label">订单状态</label>
    <div class="layui-input-block">
      <select name="orderStmt" lay-verify="required">
        <option value="">请选择</option>
        <option value="未支付">未支付</option>
        <option value="已支付">已支付</option>
        <option value="未发货">未发货</option>
        <option value="运输中">运输中</option>
        <option value="已签收">已签收</option>
      </select>
    </div>
  	</div>
	
	<div class="layui-form-item" style="width:500px">
	<label class="layui-form-label">买家编号</label>
	<div class="layui-input-block">
	    <input type="text" name="buyerId" required  lay-verify="required" placeholder="请输入买家编号" autocomplete="off" class="layui-input">
	</div>
	</div>
	
	<div class="layui-form-item" style="width:500px">
	<label class="layui-form-label">商品编号</label>
	<div class="layui-input-block">
	    <input type="text" name="goodsId" required  lay-verify="required" placeholder="请输入商品编号" autocomplete="off" class="layui-input">
	</div>
	</div>
	
	<div class="layui-form-item" style="width:500px">
	<label class="layui-form-label">物流编号</label>
	<div class="layui-input-block">
	    <input type="text" name="deliveryId" required  lay-verify="required" placeholder="请输入物流编号" autocomplete="off" class="layui-input">
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