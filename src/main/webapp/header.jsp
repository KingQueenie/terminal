<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 导航条 -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <!--导航条的头部=品牌商标+汉堡包按钮-->
        <div class="navbar-header">
            <div class="navbar-brand">
                <span class="logo"></span>
                <p class="logoname">XX样本检测系统</p>
            </div>
            <a class="navbar-toggle" data-toggle="collapse" href="#terminal-menu">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
        </div>
        <div class="navbar-collapse collapse" id="terminal-menu">
            <!--左侧的导航菜单-->
            <ul class="nav navbar-nav">
                <li>
                    <a href="#" id="home"><span class="glyphicon glyphicon-home"></span>  首页</a>
                </li>
                <li>
                    <a href="#" id="back"><span class="glyphicon glyphicon-arrow-left" ></span>  后退</a>
                </li>
                <li>
                    <a href="#" id="forward">前进 <span class="glyphicon glyphicon-arrow-right"></span></a>
                </li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
                    	<span id="user"></span>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#modal-changePwd" id="changePwd" data-toggle="modal">修改用户密码</a></li>
                        <li><a href="#" id="quit">退出</a></li>
                    </ul>
                </li>
            </ul>
            <div class="navbar-text navbar-right"><span id="days"></span></div>
        </div>
    </div>
</div>
<!--修改密码模态框-->
<div id="modal-changePwd" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4>个人密码修改
                    <span class="close" data-dismiss="modal">&times;</span>
                </h4>
            </div>
            <div class="modal-body">
                <div class="form-horizontal">
                    <div class="form-group"><!--.row-->
                        <div class="col-xs-3 col-xs-offset-2"><!--.col-*-*-->
                            <label class="control-label" for="oldPwd">原&nbsp;密&nbsp;码：</label>
                        </div>
                        <div class="col-xs-6 col-xs-pull-1">
                            <input type="password"  class="form-control" name="password" id="oldPwd" tabindex="1" />
                        </div>
                        <span class="warning" id="oldPwd_warning"></span>
                        <!--原密码输入错误，请重新输入-->
                    </div>
                    <div class="form-group">
                        <div class="col-xs-3 col-xs-offset-2">
                            <label class="control-label" for="newPwd">新&nbsp;密&nbsp;码：</label>
                        </div>
                        <div class="col-xs-6 col-xs-pull-1">
                            <input type="password" class="form-control" name="password" id="newPwd" tabindex="2" />
                        </div>
                        <span class="warning" id="newPwd_warning"></span>
                        <!--原密码与新密码一样，请重新输入-->
                    </div>
                    <div class="form-group">
                        <div class="col-xs-3 col-xs-offset-2">
                            <label class="control-label" for="againPwd">确认密码：</label>
                        </div>
                        <div class="col-xs-6 col-xs-pull-1">
                            <input type="password" class="form-control" name="password" id="againPwd" tabindex="3" />
                        </div>
                        <span class="warning" id="againPwd_warning"></span>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-2 col-xs-offset-5">
                            <button type="button" class="btn btn-block btn-primary" id="btnOk">确认</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>