<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>进程操作线程信息</title>
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
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="currentProcessName">当前进程名：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="currentProcessName" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="currentProcessID">当前进程ID：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="currentProcessID" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="threadHandle">线程句柄：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="threadHandle" />
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="targetProcessName">被操作进程名：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="targetProcessName" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="targetProcessID">被操作进程ID：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="targetProcessID" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="time">操作时间：</label>
                </div>
                <div class="col-xs-7">
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
                <strong>进程操作线程信息</strong>
            </h4>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="detailDetect_table">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>当前进程ID</th>
                        <th>当前进程名</th>
                        <th>线程句柄</th>
                        <th>目标进程ID</th>
                        <th>目标进程名</th>
                        <th>操作时间</th>
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
<script src="scripts/netopinfo2.js"></script>
</html>