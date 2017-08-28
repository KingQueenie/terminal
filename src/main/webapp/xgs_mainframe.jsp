<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>XX样本检测系统</title>
    <link rel="stylesheet" href="styles/bootstrap.css" />
    <link rel="stylesheet" href="styles/terminal.css" />
    <script src="scripts/jquery-1.11.3.js"></script>
    <script src="scripts/ajaxfileupload.js"></script>
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
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 style="display:inline-block;">
                            <span class="glyphicon glyphicon-th"></span>
                            <strong>已上传的文件</strong>
                        </h4>
                        <h5 class="pull-right" id="upload">
                            <span class="glyphicon glyphicon-open"></span>
                            <strong>上传文件</strong>
                        </h5>
                    </div>
                    
                    <div class="panel-body">
                    	 <div class="table-responsive">
	                        <table id="file_table" class="table table-bordered table-hover">
	                            <thead>
	                            <tr>
	                                <th>序号</th>
	                                <th>唯一标识</th>
	                                <th>文件名</th>
	                                <th>上传时间</th>
	                                <th>状态</th>
	                                <th>操作</th>
	                            </tr>
	                            </thead>
	                            <tbody>
	                            	
	                            </tbody>
	                        </table>
	                        <ul class="pull-right bot_page">
  
                            </ul>
	                        <input type="hidden" id="currentPage" /> <!-- 记录当前页数 -->
	                        <input type="hidden" id="totalPages" />  <!-- 记录总页数 -->
	                        <input type="hidden" id="totalRecords" />  <!-- 记录总页数 -->
	                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!--上传文件-->
    <div class="panel panel-info" id="upload_div">
        <div class="panel-heading">
            <strong>上传检测文件</strong>
            <span class="close" id="close">&times;</span>
        </div>
        <div class="panel-body">
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="col-xs-3 text-right">
                        <label class="control-label" for="uniqueid">选择上传文件：</label>
                    </div>
                    <div class="col-xs-6">
                        <input type="file" class="form-control" id="uploadFile" name="uploadFile" />
                    </div>
                    <button type="button" class="btn btn-primary" id="commit">上传</button>                 
                </div>
            </div>
        </div>
    </div>
</div>
<div id="wait_loading">
	<div>
		<img src="images/loading.gif" />
	</div>
</div>
<script src="scripts/header.js"></script>
<script src="scripts/changePwd.js"></script>
<script src="scripts/mainUser.js"></script>
</body>
</html>