<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
response.setHeader("Cache-Control", "no-cache");          
response.setHeader("Cache-Control", "no-store");         
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache");
%>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>XX样本检测系统</title>
    <link rel="stylesheet" href="styles/bootstrap.css" />
    <link rel="stylesheet" href="styles/terminal.css" />
    <link rel="stylesheet" href="styles/detailframe.css" />
    <script src="scripts/jquery-1.11.3.js"></script>
    <script src="scripts/bootstrap.js"></script>
    <script src="scripts/cookie_util.js"></script>
    <script src="scripts/md5.js"></script>
    <script src="scripts/basevalue.js"></script>
    <script src="scripts/page.js"></script>
</head>
<body>
<!-- 导航条 -->
<header id="header">
	<c:import url="header.jsp"></c:import>	
</header>
<!-- 主页面内容 -->
<div class="main">
    <!--左侧菜单栏-->
    <div class="leftHand pull-left">
        <div class="subNavBox">
            <div class="subNav currentDd currentDt">
                <i class="glyphicon glyphicon-file"></i>
                <i class="glyphicon glyphicon-menu-down pullDown"></i>
                <span class="sub_title">文件操作</span>
                <ul class="navContent" style="display:block;">
                    <li>
                    	<a href="xgs_fileOpinfo1.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">文件操作详情</a> 
                    	<span class="leftArrow" style="display:block;"></span>
                    </li>
                    <li>
                    	<a href="xgs_fileOpinfo2.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">文件map操作详情</a>
                    	<span class="leftArrow"></span>
                    </li>
                </ul>
            </div>
            <div class="subNav">
                <i class="glyphicon glyphicon-globe"></i>
                <a href="xgs_netinfo.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="sub_title clickOpera">网络使用信息</a>
                <span class="leftArrow leftArrow1"></span>
            </div>
            <div class="subNav">
                <i class="glyphicon glyphicon-th-list"></i>
                <i class="glyphicon glyphicon-menu-down pullDown"></i>
                <span class="sub_title">注册表信息</span>
                <ul class="navContent">
                    <li>
                    	<a href="xgs_registryopinfo1.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">注册表基本信息</a>
                    	<span class="leftArrow"></span>
                    </li>
                    <li>
                    	<a href="xgs_registryopinfo2.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">注册表赋值操作</a>
                    	<span class="leftArrow"></span>
                    </li>
                </ul>
            </div>
            <div class="subNav">
                <i class="glyphicon glyphicon-random"></i>
                <i class="glyphicon glyphicon-menu-down pullDown"></i>
                <span class="sub_title">进程操作信息</span>
                <ul class="navContent">
                    <li>
                    	<a href="xgs_netopinfo1.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">进程操作信息</a>
                    	<span class="leftArrow"></span>
                    </li>
                    <li>
                    	<a href="xgs_netopinfo2.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">进程操作线程信息</a>
                    	<span class="leftArrow"></span>
                    </li>
                    <li>
                    	<a href="xgs_netopinfo3.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">挂起线程操作信息</a>
                    	<span class="leftArrow"></span>
                    </li>
                    <li>
                    	<a href="xgs_netopinfo4.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="clickOpera">恢复线程操作信息</a>
                    	<span class="leftArrow"></span>
                    </li>
                </ul>
            </div>
            <div class="subNav">
                <i class="glyphicon glyphicon-unchecked"></i>
                <a href="xgs_moduleinfo.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="sub_title clickOpera">模块操作</a>
                <span class="leftArrow leftArrow1"></span>
            </div>
            <div class="subNav">
                <i class="glyphicon glyphicon-tag"></i>
                <a href="xgs_alarminfo.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="sub_title clickOpera">告警信息</a>
                <span class="leftArrow leftArrow1"></span>
            </div>
            <div class="subNav">
                <i class="glyphicon glyphicon-pencil"></i>
                <a href="demo_tree.jsp?uniqueId=${param.uniqueId}" target="iframepage" class="sub_title clickOpera">样本检测报告</a>
                <span class="leftArrow leftArrow1"></span>
            </div>
        </div>
    </div>
    <!--检测详情-->
    <div class="detailContent">
    	<iframe src="xgs_fileOpinfo1.jsp?uniqueId=${param.uniqueId}" id="iframepage" name="iframepage"></iframe>
    </div>    
</div>
<script>
    $(function(){
    	$(".subNavBox").on("click",".clickOpera",function(){
    	    $(".leftArrow").hide();
    	    $(this).parent().children(".leftArrow").show();
    	});
        $(".sub_title").click(function(){
            $(this).parent(".subNav").toggleClass("currentDd");
            $(this).parent(".subNav").siblings(".subNav").removeClass("currentDd");
            $(this).parent(".subNav").toggleClass("currentDt");
            $(this).parent(".subNav").siblings(".subNav").removeClass("currentDt");
            //slideToggle() 方法，通过使用滑动效果（高度变化）来切换元素的可见状态
            $(this).next(".navContent").slideToggle(300);
            //slideUp()方法，通过使用滑动效果，隐藏被选元素，如果元素已显示出来的话
            $(this).parent(".subNav").siblings(".subNav").children(".navContent").slideUp(500);
        });
    });
</script>
<script src="scripts/header.js"></script>
<script src="scripts/changePwd.js"></script>
</body>
</html>