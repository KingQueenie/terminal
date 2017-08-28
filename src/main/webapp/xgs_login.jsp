<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
String ipaddr=request.getRemoteAddr();
response.setHeader("Cache-Control", "no-cache");          
response.setHeader("Cache-Control", "no-store");         
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache"); 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>XX样本检测系统</title>
    <link href="styles/login.css" rel="stylesheet" />
    <script type="text/javascript" src="scripts/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="scripts/md5.js"></script>
    <script type="text/javascript" src="scripts/cookie_util.js"></script>
    <script type="text/javascript" src="scripts/basevalue.js"></script>
    <script type="text/javascript" src="scripts/login.js"></script>
    <script type="text/javascript">
	    $(function(){
	    	var ipaddr="<%=ipaddr%>";
	    	addCookie("ipaddr",ipaddr,0);
	    	var user=$("#username");
	    	var pwd=$("#password");
	    	var warning=$("#warning");
	    	user.focus(function(){
                warning.hide();
            });
	    	pwd.focus(function(){
                warning.hide();
            });
	        $("#login").click(checkLogin);
	        $("#reg").click(function(){
	            window.location = 'xgs_registe.jsp';
	        });
	    });
	</script>
</head>
<body>
	<canvas id="tercanvas"></canvas>
	<div class="main">
	    <div class="log">
	        <div class="letter">
	            <label for="count">用户名:</label>
	            <input type="text" name="" id="username" tabindex="1" />
	        </div>
	        <div class="letter">
	            <label for="password">密&nbsp;&nbsp;&nbsp;码:</label>
	            <input type="password" name="" id="password" tabindex="2" />
	            <button type="button" name="" id="login" tabindex="3">&nbsp;登&nbsp;录&nbsp;</button>
	        </div>
	        <span class='warning' id='warning'></span>
	        <a href="#" class="reg" id="reg">用户注册</a>
	    </div>
	</div>
	<script src="scripts/terCanvas.js"></script>
</body>
</html>