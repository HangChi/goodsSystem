<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bhu.shc.entity.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>主界面信息展示</title>
    <link rel="stylesheet" href="/goodsSystem/css/layui.css">
    <script src="/goodsSystem/layui.js"></script>
</head>
<body>
<div>
    <br><br>
    <blockquote class="layui-elem-quote layui-text">
        <ul>
            <h3>7组--订单管理系统 </h3>
            <li>组长：黄心灵</li>
            <li>组员：宋杭弛、张小涵、姜皓扬、薛佳伊</li>
        </ul>
    </blockquote>

    <br>

    <div class="layui-card layui-panel">
        <div class="layui-card-header">
            工作日报时间线
        </div>
        <div class="layui-card-body">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">5月28日</h3>
                        <ul>
                            <li>8:20——10:10：完善订单管理系统<br>页面美化，提高用户体验度</li>
                            <li>13:30——17:20：对整个项目进行测试<br>录制视频</li>
                            <li>18:30——20:20：准备答辩PPT和项目提交物</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">5月27日</h3>
                        <ul>
                            <li>8:20——10:10：完成订单管理系统登录注册功能</li>
                            <li>13:30——17:20：完成订单管理系统个人中心模块</li>
                            <li>18:30——20:20：对登录注册功能进行改善，实现退出注销<br>整合项目</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">5月26日</h3>
                        <ul>
                            <li>8:20——10:10：完成订单管理系统删除功能</li>
                            <li>13:30——17:20：完成订单管理系统修改功能</li>
                            <li>18:30——20:20：对删除功能进行改善，实现弹窗提醒<br>整合项目</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">5月25日</h3>
                        <ul>
                            <li>8:20——10:10：完成订单管理系统查询功能</li>
                            <li>13:30——17:20：完成订单管理系统增加功能</li>
                            <li>18:30——20:20：对查询功能进行改善，实现模糊查询<br>整合项目</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">5月24日</h3>
                        <ul>
                            <li>8:20——10:10：学习layui使用<br>完成会议管理系统的查询功能</li>
                            <li>13:30——17:20：完成会议管理系统的增加功能</li>
                            <li>18:30——20:20：确定需求分析，绘制数据流图</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">5月23日</h3>
                        <ul>
                            <li>8:20——10:10：学习layui使用和会话技术</li>
                            <li>13:30——17:20：完成会议管理系统的登录功能</li>
                            <li>18:30——20:20：JavaEE考试</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <br>
</div>
</div>

   <div class="layui-footer">
   <!-- 底部固定区域 -->
   <div class="layui-form">
       <div class="layui-form-item">
           <div class="layui-inline">
               <label class="layui-form-label">中文版</label>
               <div class="layui-input-inline">
                   <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd">
               </div>
           </div>

       </div>
   </div>

<script>

	//日期组件
	layui.use('laydate', function () {
	    var laydate = layui.laydate;
	
	    //执行一个laydate实例
	    laydate.render({
	        elem: '#test1' //指定元素
	    });
	});
</script>
</body>
</html>