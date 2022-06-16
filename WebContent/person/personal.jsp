<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Person"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>个人信息界面</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<script src="/goodsSystem/layui.js"></script>
</head>
<body>
		
<div class="layui-row layui-col-space10">

<div class="layui-col-md4">
    <iframe name="myif2" height="650px" src="/goodsSystem/person/personInfo.jsp"
    frameborder="no"  border=0  marginwidth=0  marginheight=0  scrolling="no" style="margin-top:50px;">
    </iframe>
    <iframe name="myif4" height="650px" src="https://httishere.github.io/notion-widget/new/progress.html"
    frameborder="no"  border=0  marginwidth=0  marginheight=0  scrolling="no" style="margin-top:-150px;">
    </iframe>
  </div>
  <div class="layui-col-md4">
    <iframe name="myif1" height="650px" src="https://httishere.github.io/notion-widget/new/today-shici.html?mode=w"
    frameborder="no" border=0  marginwidth=0  marginheight=0  scrolling="no" style="margin-top:10px;">
    </iframe>
    
    <iframe name="myif5" height="650px" src="https://httishere.github.io/notion-widget/calendar.html"
    frameborder="no"  border=0  marginwidth=0  marginheight=0  scrolling="no" style="margin-top:-200px;">
    </iframe>
  </div>
  
  <div class="layui-col-md4">
    <iframe name="myif3" height="1000px" src="https://httishere.github.io/notion-widget/new/history-today.html"
    frameborder="no"  border=0  marginwidth=0  marginheight=0  scrolling="no">
    </iframe>
  </div>
</div>

<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  //监听提交
  /*form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  	});
	});*/
</script>


</body>
</html>