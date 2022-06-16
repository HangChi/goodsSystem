<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>个人信息表</title>
<link rel="stylesheet" href="/goodsSystem/css/layui.css">
<!-- 引入 layui.js -->
<script src="/goodsSystem/layui.js"></script>
</head>
<body>

	<!-- 查询失败信息 -->	
	<%
		String infotip = (String)session.getAttribute("infotip");
		if(infotip != null){
	%>
		<h1 style="color:red;"><%= infotip %></h1>
	<%
		}else{
	%>
	
	<%
		Person person = (Person)session.getAttribute("person");
	%>	
	
	<%! public static int flag = 1; %>	
	<%
		if(flag++ % 2 != 0){
			response.sendRedirect("/goodsSystem/person/personal.jsp");
			//flag ++;
		}
	 %>	
	

<form class="layui-form" action="/goodsSystem/person/update.do">
  <div class="layui-form-item" style="width:300px">
    <label class="layui-form-label">用户名</label>
    <div class="layui-input-block">
      <input type="text" name="name" required placeholder="<%=person.getUserName() %>" class="layui-input">
    </div>
  </div>

	<div class="layui-form-item" style="width:300px">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input type="radio" name="sex" value="男" title="男" checked>
      <input type="radio" name="sex" value="女" title="女">
    </div>
  </div>


	<div class="layui-form-item" style="width:300px">
	    <label class="layui-form-label">出生日期</label>
	    <div class="layui-input-block">
	      <input type="text" name="birth" placeholder="<%=person.getUserBirth() %>" class="layui-input">
	    </div>
  	</div>

	<div class="layui-form-item" style="width:300px">
	    <label class="layui-form-label">入职日期</label>
	    <div class="layui-input-block">
	      <input type="text" name="hiredate" placeholder="<%=person.getUserHireDate() %>" class="layui-input">
	    </div>
  	</div>


  <div class="layui-form-item layui-form-text" style="width:300px">
    <label class="layui-form-label">个人描述</label>
    <div class="layui-input-block">
      <textarea name="desc" lay-verify="required" placeholder="<%=person.getUserDesc() %>" class="layui-textarea"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit"class="layui-btn" lay-submit lay-filter="formDemo" value="保存修改">
    </div>
  </div>
</form>
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
	  	});
	});*/
</script>
</body>
</html>