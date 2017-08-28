//判断是否超过最大间隔数未修改密码
var to_chg_pwd=getCookie("to_chg_pwd");
var max_chg_pwd_day=getCookie("max_chg_pwd_day");
//console.log("to_chg_pwd:"+to_chg_pwd);
//console.log("max_chg_pwd_day:"+max_chg_pwd_day);
if(to_chg_pwd=="1"){
	alert("您已"+max_chg_pwd_day+"天未修改密码，请先修改密码");
	$('#modal-changePwd').modal({backdrop: 'static', keyboard: false});
	changePwd();
}
$("#changePwd").click(changePwd);
function changePwd(){
	var basePath=getCookie("basePath");
	var oldPwd=$("#oldPwd");
	var newPwd=$("#newPwd");
	var againPwd=$("#againPwd");
	var oldPwd_warning=$("#oldPwd_warning");
	var newPwd_warning=$("#newPwd_warning");
	var againPwd_warning=$("#againPwd_warning");
	againPwd.blur(function(){
	    var newPassword=newPwd.val().trim();
	    var againPassword=againPwd.val().trim();
	    if(newPassword!=againPassword){
	        againPwd_warning.html("前后密码不一致，请重新输入");
	        againPwd_warning.show();
	    }
	});
	oldPwd.focus(function(){
	    oldPwd_warning.hide();
	});
	newPwd.focus(function(){
	    newPwd_warning.hide();
	});
	againPwd.focus(function(){
	    againPwd_warning.hide();
	});
	$("#btnOk").click(function(){
		var oldPassword=oldPwd.val().trim();
		var newPassword=newPwd.val().trim();
		var againPassword=againPwd.val().trim();
		var regExg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$/g;
			var ok=true;
			var username= getCookie("username");
		if(username==null){
			alert("登录已失效，请重新登录");
			window.location.href="xgs_login.jsp";
			ok=false;
		}
		if(oldPassword==""){
			oldPwd_warning.html("请填写原密码");
			oldPwd_warning.show();
			ok=false;
		}
		if(newPassword==""){
			newPwd_warning.html("请填写新密码");
			newPwd_warning.show();
			ok=false;
		}
		if(againPassword==""){
			againPwd_warning.html("请填写新密码");
			againPwd_warning.show();
			ok=false;
		}
		if(oldPassword==newPassword){
			newPwd_warning.html("新密码不能与旧密码一样，请重新输入");
			newPwd_warning.show();
			ok=false;
		}
		if( newPassword!=againPassword ){
			againPwd_warning.html("前后密码不一致，请重新输入");
	        againPwd_warning.show();
		    ok=false;
		}
		if(ok){
			oldPassword=hex_md5(oldPassword);
			$.ajax({
				url:"user/changePassword.do",
				type:"POST",
				dataType:"json",
				data:{username:username,oldPassword:oldPassword,newPassword:newPassword},
				success:function(result){
					var status=result.status;
					var msg=result.msg;
					if(result.status==0){
						alert(msg);
						logout();
					} else {
						var data = result.data;
						if(data.oldPwdMsg!=null){
							oldPwd_warning.html(data.oldPwdMsg);
							oldPwd_warning.show();
						}
						if(data.newPwdMsg!=null){
							newPwd_warning.html(data.newPwdMsg);
							newPwd_warning.show();
						}
					}
				},
				error:function(){
					alert("密码修改失败，请重新刷新再试！");
				}
			});
		}
	});
}

function logout(){
	var username=getCookie("username");
	delCookie("username");
	delCookie("loginstate");
	window.location.href="xgs_login.jsp";	
}