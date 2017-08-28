<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%	
response.setHeader("Cache-Control", "no-cache");          
response.setHeader("Cache-Control", "no-store");         
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache"); 
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>欢迎注册</title>
    <link href="styles/register.css" rel="stylesheet" />
    <script src="scripts/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="scripts/md5.js"></script>
    <script type="text/javascript" src="scripts/cookie_util.js"></script>
    <script type="text/javascript" src="scripts/regist.js"></script>
    <script type="text/javascript">
        
    </script>
</head>
<body>
    <canvas id="tercanvas"></canvas>
    <div class="main">
        <div class="wel">欢迎注册</div>
        <div class="sig">
            <div class="letter">
                <label for="username">用户名：</label>
                <input type="text" name="username" id="username" tabindex="1" />
                <span class="warning" id="user_warning"></span>
            </div>
            <div class="letter">
                <label for="nickname">昵&nbsp;&nbsp;&nbsp;&nbsp;称：</label>
                <input type="text" name="nickname" id="nickname" tabindex="2" />
                <span class="warning" id="nick_warning"></span>
            </div>
            <div class="letter">
                <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                <input type="password" name="password" id="password" tabindex="3" />
                <span class="warning" id="pwd_warning"></span>
            </div>
            <div class="letter">
                <label for="final_password">确认密码：</label>
                <input type="password" name="final_password" id="final_password" tabindex="4" />
                <span class="warning" id="final_warning"></span>
            </div>
            <div class="letter">
                <label for="age">年&nbsp;&nbsp;&nbsp;&nbsp;龄：</label>
                <input type="text" name="age" id="age" tabindex="5" />
            </div>
            <div class="letter radio">
                <label>性&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
                <label for="sex1" class="sex">
                    <input type="radio" id="sex1" name="gender" value="male" tabindex="6" checked />男
                </label>
                <label for="sex2" class="sex">
                    <input type="radio" id="sex2" name="gender" value="female" tabindex="7" />女
                </label>
            </div>
            <div class="letter">
                <label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
                <input type="email" name="email" id="email" tabindex="8" />
            </div>
            <div class="letter">
                <label for="phone">联系方式：</label>
                <input type="tel" name="phone" id="phone" tabindex="9" />
            </div>
            <div>
                <input type="button" name="" id="regist_button" value='&nbsp;注&nbsp;册&nbsp;' tabindex='10'/>
                <input type="button" name="" id="back" value='&nbsp;返&nbsp;回&nbsp;' tabindex='11'/>
            </div>
        </div>
    </div>
    <script src="scripts/terCanvas.js"></script>
</body>
</html>