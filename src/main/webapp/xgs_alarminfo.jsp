<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>告警信息</title>
    <link rel="stylesheet" href="styles/bootstrap.css" />
    <link rel="stylesheet" href="styles/terminal.css" />
    <link rel="stylesheet" href="styles/detailframe.css" />
    <script src="scripts/jquery-1.11.3.js"></script>
    <script src="scripts/bootstrap.js"></script>
    <script src="scripts/cookie_util.js"></script>
    <script src="scripts/md5.js"></script>
    <script src="scripts/basevalue.js"></script>
    <script src="scripts/page.js"></script>
    <script src="scripts/testDetails.js"></script>
</head>
<body>
<!-- 搜索框 -->
<div class="search_tab form-horizontal">
    <div class="row">
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-6 text-right">
                    <label class="control-label" for="type">操作类型：</label>
                </div>
                <div class="col-xs-6" >
                    <select id="type" class="form-control">
           				<option value="0"></option>
              			<option value="1">启动自释放文件</option>
						<option value="2">注册服务动态库</option>
						<option value="3">添加系统防火墙放过列表</option>
						<option value="4">禁止服务</option>
						<option value="5">降低系统安全性</option>
						<option value="6">修改注册表自启动项</option>
						<option value="7">覆写PE文件</option>
						<option value="8">感染PE文件</option>
						<option value="9">入侵进程</option>
						<option value="10">隐蔽执行</option>
						<option value="11">自我删除</option>
						<option value="12">自我复制</option>
						<option value="13">释放PE文件</option>
						<option value="14">释放隐蔽文件</option>
						<option value="15">进程异常</option>
						<option value="16">文件异常</option>
                    </select>
                </div>
            </div>
        </div>
         <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-6 text-right">
                    <label class="control-label" for="path">文件路径/注册表路径：</label>
                </div>
                <div class="col-xs-6">
                    <input type="text" class="form-control"id="path" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-6 text-right">
                    <label class="control-label" for="explain2">威胁程度：</label>
                </div>
                <div class="col-xs-6">
                    <input type="text" class="form-control"id="explain2" />
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-6 text-right">
                    <label class="control-label" for="processName">进程名：</label>
                </div>
                <div class="col-xs-6">
                    <input type="text" class="form-control"id="processName" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-6 text-right">
                    <label class="control-label" for="explain1">关联进程/注册表键：</label>
                </div>
                <div class="col-xs-6">
                    <input type="text" class="form-control"id="explain1" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-6 text-right">
                    <label class="control-label" for="time">操作时间：</label>
                </div>
                <div class="col-xs-6">
                    <input type="text" class="form-control"id="time" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-offset-5">
                    <button type="button" class="btn btn-primary" id="save">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 检测详情表格 -->
<div class="detailDetect">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 style="display:inline-block;">
                <span class="glyphicon glyphicon-th"></span>
                <strong>告警信息</strong>
            </h4>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="detailDetect_table" style="table-layout:fixed;">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>告警类型</th>
                        <th>进程名</th>
                        <th width="50%">文件路径/注册表路径</th>
                        <th width="12%" >关键进程/注册表键</th>
                        <th>威胁程度</th>
                        <th>操作时间</th>
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
</body>
<script src="scripts/alarminfo.js"></script>
</html>