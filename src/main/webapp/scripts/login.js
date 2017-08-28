function checkLogin(){
	var ipaddr=getCookie("ipaddr");
	//获取参数
    var username=$("#username").val().trim();
    var password=$("#password").val().trim();
    var warning=$("#warning");
    //格式检测
    var ok=true;
    if(username==""){
        warning.html("请输入用户名");
        warning.show();
        ok=false;
    }
    if(password=="" && !username==""){
        warning.html("请输入密码");
        warning.show();
        ok=false;
    }
    if(ok){ //检查格式通过
        password=hex_md5(password);
        $.ajax({ //发送ajax请求
            type:"POST",
            url:"user/login.do",
            data:{"username":username,"password":password,"ipaddr":ipaddr},
            dataType:"json",
            success:function(result){
            	console.log(result);
                //result是服务器返回的JSON字符串结果
                if(result.status==0 || result.status==1){
                    //将用户信息保存到Cookie
                    var username=result.data.username;
                    var type=result.data.type;
                    var flag=result.data.flag;
                    var group=result.data.group;
                    var to_chg_pwd=result.status;
                    var max_chg_pwd_day=result.exData;
                    addCookie("username",username,0);
                    addCookie("userType",type,0);
                    addCookie("flag",flag,0);
                    addCookie("group",group,0);
                    addCookie("to_chg_pwd",to_chg_pwd,0);
                    addCookie("max_chg_pwd_day",max_chg_pwd_day,0);
                    if(type=="user"){ //若是用户登录，则登录状态设为2
                        addCookie("loginstate","2",0);
                        window.location = 'xgs_mainframe.jsp';
                    } else { //若是管理员登录，则登录状态设为1
                        addCookie("loginstate","1",0);
                        window.location = 'xgs_mainframe_admin.jsp';
                    }
                } else {
                    warning.html(result.msg);
                    warning.show();
                }
            },
            error:function(){
                alert("网络连接有问题,请重新登陆!");
            }
        });
    }
}
