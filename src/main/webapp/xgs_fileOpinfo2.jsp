<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <script src="scripts/testDetails.js"></script>
    <script type="text/javascript" src="scripts/fileOpinfo.js"></script>
</head>
<body>
<!-- 搜索框 -->
<div class="search_tab form-horizontal">
	<div class="row">
		<div class="col-xs-3">
		    <div class="form-group">
		        <div class="col-xs-5 text-right">
		            <label class="control-label" for="opType">操作类型：</label>
		        </div>
		        <div class="col-xs-7" >
		            <select id="opType" class="form-control">
		                <option value="0" label=""></option>
		                <option value="7" label="">MapView</option>
		                <option value="8" label="">UnmapView</option>		              
		            </select>
		        </div>
		    </div>
		</div>
		<div class="col-xs-3">
		    <div class="form-group">
		        <div class="col-xs-5 text-right">
		            <label class="control-label" for="removable">文件类型：</label>
		        </div>
		        <div class="col-xs-7">
		            <select id="removable" class="form-control">
		                <option value="0"></option>
		                <option value="-1">当前进程句柄</option>
		                <option value="1">IO_TYPE_ADAPTRE</option>
		                <option value="2">IO_TYPE_CONTROLLER</option>
		                <option value="3">IO_TYPE_DEVICE</option>
		                <option value="4">IO_TYPE_DRIVER</option>
		                <option value="5">IO_TYPE_FILE</option>
		                <option value="6">IO_TYPE_IRP</option>
		                <option value="7">IO_TYPE_ADAPTER</option>
		                <option value="8">IO_TYPE_PACKET</option>
		                <option value="9">IO_TYPE_TIMER</option>
		                <option value="10">IO_TYPE_VPB</option>
		                <option value="11">IO_TYPE_LOG</option>
		                <option value="12">IO_TYPE_MESSAGE</option>
		                <option value="13">IO_TYPE_EXTENSION</option>
		            </select>
		        </div>
		    </div>
		</div>
		<div class="col-xs-3">
		    <div class="form-group">
		        <div class="col-xs-5 text-right">
		            <label class="control-label" for="filePath">文件路径：</label>
		        </div>
		        <div class="col-xs-7">
		            <input type="text" class="form-control"id="filePath" />
		        </div>
		    </div>
		</div>
	</div>
    <div class="row">
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="processPath">进程ID：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="processPath" />
                </div>
            </div>
        </div>
        <div class="col-xs-3">
            <div class="form-group">
                <div class="col-xs-5 text-right">
                    <label class="control-label" for="processName">操作名：</label>
                </div>
                <div class="col-xs-7">
                    <input type="text" class="form-control"id="processName" />
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
                <strong>文件map操作详情</strong>
            </h4>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-bordered table-hover" id="detailDetect_table">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>操作类型</th>
                        <th>文件类型</th>
                        <th>文件路径</th>
                        <th>进程名称</th>
                        <th>进程ID</th>
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
<script type="text/javascript" src="scripts/fileOpinfo2.js"></script>
</html>