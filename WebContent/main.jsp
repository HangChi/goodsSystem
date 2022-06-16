<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>主界面</title>
    <link rel="stylesheet" href="/goodsSystem/css/layui.css">
    <script src="/goodsSystem/layui.js"></script>
</head>

<body>
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo layui-hide-xs layui-bg-black">
	            <img src="img/3.png" class="layui-nav-img" style="margin-left:-15px;margin-top:-5px">
	            <a href="main.jsp" style="text-decoration:none;color: white;">订单管理系统</a>
            </div>
            <!-- 头部区域（可配合layui 已有的水平导航） -->
            <ul class="layui-nav layui-layout-left">
                <!-- 移动端显示 -->
                <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                    <i class="layui-icon layui-icon-spread-left"></i>
                </li>
				
                <li class="layui-nav-item layui-hide-xs">
                	<a href="/goodsSystem/buyer/info.do" target="myif">买家信息</a>
                </li>
                <li class="layui-nav-item layui-hide-xs">
                	<a href="/goodsSystem/seller/info.do" target="myif">卖家信息</a>
                </li>
                <li class="layui-nav-item layui-hide-xs">
                	<a href="/goodsSystem/delivery/info.do" target="myif">物流信息</a>
                </li>
                <li class="layui-nav-item layui-hide-xs">
                	<a href="/goodsSystem/goods/info.do" target="myif">商品信息</a>
                </li>
                <li class="layui-nav-item layui-hide-xs">
                	<a href="/goodsSystem/order/info.do" target="myif">订单信息</a>
                </li>
                
            </ul>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                    <a href="javascript:;">
                        <img src="img/1.png" class="layui-nav-img">
                        <%
                        	Users user = (Users)session.getAttribute("user");
                        	if(user != null){
                        %>
                        <span><%= user.getUserName() %></span>
                        <% 
                        	}else{
                        %>
                      		<span>未登录</span>
                        <%
                        	}
                        %>
                        
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a  href="/goodsSystem/person/info.do?name=<%= user.getUserName() %>" target="myif">个人信息</a></dd>
                        <dd><a href="javascript:confirm('<%=user.getUserName() %>')">注销账号</a></dd>
                        <dd><a href="/goodsSystem/login.jsp">退出登录</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:logout()">
                        <i class="layui-icon layui-icon-logout"></i>
                    </a>
                </li>
            </ul>
        </div>

		<div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;">买家信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/goodsSystem/buyer/info.do" target="myif">
                            <i class="layui-icon">&#xe714;</i>查看买家信息</a></dd>
                            <dd><a href="/goodsSystem/buyer/buyerAdd.jsp" target="myif">
                            <i class="layui-icon">&#xe608;</i>增加买家管理</a></dd>
                        </dl>
                    </li>
                    
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;">卖家信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/goodsSystem/seller/info.do" target="myif">
                            <i class="layui-icon">&#xe714;</i>查看卖家信息</a></dd>
                            <dd><a href="/goodsSystem/seller/sellerAdd.jsp" target="myif">
                            <i class="layui-icon">&#xe608;</i>增加卖家信息</a></dd>
                        </dl>
                    </li>
                    
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;">物流信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/goodsSystem/delivery/info.do" target="myif">
                            <i class="layui-icon">&#xe714;</i>查看物流信息</a></dd>
                            <dd><a href="/goodsSystem/delivery/deliveryAdd.jsp" target="myif">
                            <i class="layui-icon">&#xe608;</i>增加物流管理</a></dd>
                        </dl>
                    </li>
                    
                    <li class="layui-nav-item">
                        <a class="" href="javascript:;">商品信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/goodsSystem/goods/info.do" target="myif">
                            <i class="layui-icon">&#xe714;</i>查看商品信息</a></dd>
                            <dd><a href="/goodsSystem/goods/goodsAdd.jsp" target="myif">
                            <i class="layui-icon">&#xe608;</i>增加商品管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">订单信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="/goodsSystem/order/info.do" target="myif">
                            <i class="layui-icon">&#xe714;</i>查看订单信息</a></dd>
                            <dd><a href="/goodsSystem/order/orderAdd.jsp" target="myif">
                            <i class="layui-icon">&#xe608;</i>增加订单信息</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item"><a href="/goodsSystem/person/info.do?name=<%= user.getUserName() %>" target="myif">个人中心</a></li>
                </ul>
            </div>
        </div>


        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div style="padding: 15px;">
				<iframe name="myif" width="100%" height="600px" frameborder="0" scrolling="yes" src="information.jsp"></iframe>
			</div>
        </div>

    </div>

	<script>
	
		//询问框
		function logout(){
			layer.confirm('确认退出登录吗？', {
			  btn: ['确认','取消'] //按钮
			}, function(){
				window.location.href = "/goodsSystem/login.jsp";
			}, function(){
			});
		}
		
	
        //JS 
        layui.use(['element', 'layer', 'util'], function () {
            var element = layui.element
                , layer = layui.layer
                , util = layui.util
                , $ = layui.$;

            //头部事件
            util.event('lay-header-event', {
                //左侧菜单事件
                menuLeft: function (othis) {
                    layer.msg('展开左侧菜单的操作', { icon: 0 });
                }
                , menuRight: function () {
                    layer.open({
                        type: 1
                        , content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                        , area: ['260px', '100%']
                        , offset: 'rt' //右上角
                        , anim: 5
                        , shadeClose: true
                    });
                }
            });

        });
        
        
        function confirm(name){
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认注销该账号吗？', {
				  btn: ['确定','取消'] //按钮
				}, function(){
				  window.location.href = "/goodsSystem/logout.do?name=" + name;
				}, function(){
				});
			});            
		}
        
    </script>
        
        
</body>
</html>