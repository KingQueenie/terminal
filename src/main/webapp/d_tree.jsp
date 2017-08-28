<%@ page language="java" contentType="text/html"   pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<title>报告</title>
<script src="scripts/d3.v3.min.js"></script>
<script src="scripts/dagre-d3.js"></script>
<script src="scripts/jquery-1.11.3.js" ></script>

<style>
body{
 font-family: SimSun;;
 color: #333;
}
.content{
 margin-bottom:10px;
}
ul,li{
  float:right;
  margin:0;padding:0;
  list-style:none;
}
.rec{
  width:70px;
  height:20px;
  margin:10px 6px 0 0px;
  border: 0;
  outline: 0;
}
.file{
  background-color:#D36964;
}
.net{
  background-color:#B48654;
}
.registe{
  background-color:#49ADB9;
}
.process{
  background-color:#ABBB78;
}
.module{
  background-color:#669966;
}
.alarm{
  background-color:#918595;
}
.des{
	font-size:10px;
  	line-height:20px;
  	width:80px;
  	margin-top: 10px;
}
</style>
</head>
<body>
<div class="main">
  <h3>样本检测报告</h3>
</div>   	
<div class="content">      
    <div class="img">
      <img src="temp/demo_tree.png"></img>
    </div>
    <div class="description" style="margin-bottom:20px;">
	  <ul>
	  	<li class="des">注册表信息</li>
	  	<li class="rec registe"></li>
	  	<li class="des">网络使用信息</li>
	  	<li class="rec net"></li>
	  	<li class="des">文件操作信息</li>
	  	<li class="rec file"></li>  	
	  </ul><br />
	  <ul>
	  	<li class="des">告警信息</li>
	  	<li class="rec alarm"></li>
	  	<li class="des">模块信息</li>
	  	<li class="rec module"></li>
	  	<li class="des">进程操作信息</li>
	  	<li class="rec process"></li> 	
	  </ul>
	</div> 
</div>
</body>
</html>