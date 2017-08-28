<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>样本检测报告</title>
    <link rel="stylesheet" href="styles/bootstrap.css" />
    <link rel="stylesheet" href="styles/terminal.css" />
    <link rel="stylesheet" href="styles/detailframe.css" />
    <link rel="stylesheet" href="styles/demo_tree.css" />
    <script src="scripts/jquery-1.11.3.js"></script>
    <script src="scripts/bootstrap.js"></script>
    <script src="scripts/cookie_util.js"></script>
    <script src="scripts/md5.js"></script>
    <script src="scripts/testDetails.js"></script>
    <script src="scripts/d3.v3.min.js"></script>
    <script src="scripts/dagre-d3.js"></script>
</head>
<body>
<form action="testDetails/exportTree.do" method="get">
<div id="main">
   <h3>样本检测报告</h3>
   <input type="submit" id="submit" value="导出" style="float:right;margin-bottom:10px;"></input>
</div>
<div class="content" id="content">
    <div id="csvg" class="csvg">
      <svg xmlns="http://www.w3.org/2000/svg" id="svg-canvas" width="960" height="800" class="svg-canvas">
      	<style>
      		<![CDATA[
      			g.top > rect {
			        /*fill: #ffffff;*/
			        fill:#F6A450
			    }
			    g.file > rect {
			        /*fill: #333366;*/
			        fill:#D36964;
			    }
			    g.net > rect {
			        /*fill: #003399;*/
			        fill:#B48654;
			    }
			    g.registe > rect {
			        /*fill: #009933;*/
			        fill:#49ADB9;
			    }
			    g.process > rect {
			        /*fill: #999900;*/
			        fill:#ABBB78;
			    }
			    g.module > rect {
			        /*fill: #669966;*/
			        fill:#669966;
			    }
			    g.alarm > rect {
			        /*fill: #cc0000;*/
			        fill:#918595;
			    }
			    g.top text{
			       fill:#fff;
			    }
				g.file text{
			       fill:#fff;
			    }
			    g.net text{
			       fill:#fff;
			    }
			    g.registe text{
			       fill:#fff;
			    }
			    g.process text{
			       fill:#fff;
			    }
			    g.module text{
			       fill:#fff;
			    }
			    g.alarm text{
			       fill:#fff;
			    }			    
				text {
				  font-weight: 300;
				  font-family: "Helvetica Neue", Helvetica, Arial, sans-serf;
				  font-size: 14px;
				}
				.node rect {
				  /*stroke: #999;*/
				  fill: #fff;
				  stroke-width: 1.5px;
				}
				.edgePath path {
				  stroke: #333;
				  stroke-width: 1.5px;
				}
      		]]>
      	</style>
      </svg>
    </div>
    <div class="description">
	  <ul>
	  	<li class="des">告警信息</li>
	  	<li class="rec alarm"></li>
	  	<li class="des">模块信息</li>
	  	<li class="rec module"></li>
	  	<li class="des">进程操作信息</li>
	  	<li class="rec process"></li>
	  	<li class="des">注册表信息</li>
	  	<li class="rec registe"></li>
	  	<li class="des">网络使用信息</li>
	  	<li class="rec net"></li>
	  	<li class="des">文件操作信息</li>
	  	<li class="rec file"></li>  	 	
	  </ul>
	</div> 
</div>
</form>
<script>

</script>
</body>
<script type="text/javascript" src="scripts/demo_tree.js"></script>
</html>