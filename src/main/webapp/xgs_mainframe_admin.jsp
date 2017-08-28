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
                        <h5 class="pull-right" id="modify">
                            <span class="glyphicon glyphicon-edit"></span>
                            <strong>修改状态</strong>
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
	
	<!--修改状态框-->
    <div class="panel panel-info" id="edit_div">
        <div class="panel-heading">
            <strong>修改状态</strong>
            <span class="close" id="close">&times;</span>
        </div>
        <div class="panel-body">
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="col-xs-4 col-xs-offset-1 text-right">
                        <label class="control-label" for="uniqueid">唯&nbsp;&nbsp;一&nbsp;&nbsp;标&nbsp;&nbsp;识&nbsp;&nbsp;：</label>
                    </div>
                    <div class="col-xs-6">
                        <input type="text" class="form-control" name="password" id="uniqueid" tabindex="1" />
                    </div>
                    <span class="warning" id="uniqueid_warning"></span>
                </div>
                <div class="form-group">
                    <div class="col-xs-4 col-xs-offset-1 text-right">
                        <label class="control-label" for="detectState">检&nbsp;&nbsp;测&nbsp;&nbsp;状&nbsp;&nbsp;态&nbsp;&nbsp;：</label>
                    </div>
                    <div class="col-xs-6 ">
                        <select id="detectState" class="form-control">
                            <option label="未检测" value="0">未检测</option>
                            <option label="已检测" value="1">已检测</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-4 col-xs-offset-1 text-right">
                        <label class="control-label" for="systembase">基于系统唯一标识：</label>
                    </div>
                    <div class="col-xs-6">
                        <input type="text" class="form-control" name="password" id="systembase" tabindex="3" />
                    </div>
                    <span class="warning" id="systembase_warning"></span>
                </div>
                <div class="form-group">
                    <div class="col-xs-3 col-xs-offset-4">
                        <button type="button" class="btn btn-danger" id="save">保存</button>
                    </div>
                    <div class="col-xs-3 col-xs-pull-1">
                        <button type="button" class="btn btn-primary" id="cancel">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="scripts/header.js"></script>
<script src="scripts/changePwd.js"></script>
<script src="scripts/mainAdmin.js"></script>
<script>
	
</script>
</body>
</html>