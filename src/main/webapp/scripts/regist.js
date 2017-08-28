$(function(){ //加载完body后调用该函数
    //点击“返回”按钮，返回到登录页面
    $("#back").click(function(){
        window.location = 'xgs_login.jsp';
    });
    var user=$("#username");
    var nick=$("#nickname");
    var pwd=$("#password");
    var final_pwd=$("#final_password");
    var user_warning=$("#user_warning");
    var nick_warning=$("#nick_warning");
    var pwd_warning=$("#pwd_warning");
    var final_warning=$("#final_warning");
    //(?![0-9]+$) 预测该位置后面不全是数字;(?![a-zA-Z]+$) 预测该位置后面不全是字母;[0-9A-Za-z] {8,16} 由8-16位数字或这字母组成
    var regExg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$/g;
    pwd.change(function(){
        var password=pwd.val().trim();
        var npwd=password.length;
        if(npwd<8 && npwd>0){
            pwd_warning.html("密码不能小于8位，请重新输入");
            pwd_warning.show();
        }else if(!regExg.test(password) && npwd>0){
            pwd_warning.html("密码应同时包含数字和字母，请重新输入");
            pwd_warning.show();
        }
    });
    final_pwd.blur(function(){
        var password=pwd.val().trim();
        var final_password=final_pwd.val().trim();
        if(password!=final_password){
            final_warning.html("前后密码不一致，请重新输入");
            final_warning.show();
        }
    });
    user.focus(function(){
        user_warning.hide();
    });
    nick.focus(function(){
        nick_warning.hide();
    });
    pwd.focus(function(){
        pwd_warning.hide();
    });
    final_pwd.focus(function(){
        final_warning.hide();
    });
    $("#regist_button").click(function(){
        var username=user.val().trim();
        var nickname=nick.val().trim();
        var password=pwd.val().trim();
        var final_password=final_pwd.val().trim();
        var age=$("#age").val().trim();
        var gender=$("input:radio[name='gender']:checked").val() ;
        var email = $("#email").val().trim();
    	var phone = $("#phone").val().trim();
        var regExg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,}$/g;
        var ok=true;
        if(username==""){
            user_warning.html("请填写用户名");
            user_warning.show();
            ok=false;
        }
        if(nickname==""){
            nick_warning.html("请填写昵称");
            nick_warning.show();
            ok=false;
        }
        if(password==""){
            pwd_warning.html("请填写密码");
            pwd_warning.show();
            ok=false;
        }
        if(password.length<8 || !regExg.test(password) || password!=final_password ){
            ok=false;
        }
        if(ok){
        	password=hex_md5(password);
        	$.ajax({
        		type:"POST",
        		url:"http://localhost:8080/terminal1/user/regist.do",
        		data : {
                   	username:username,
        			nickname:nickname,
        			password:password,
        			age:age,
        			gender:gender,
        			email:email,
        			phone:phone,
        		},
        		success:function(result){
        			if(result.status==0){ //登录成功
						alert(result.msg);
						//返回到登录页面
						window.location = "xgs_login.jsp";
					} else if(result.status==1){
						//用户名被占用
						$("#user_warning").html(result.msg);
						$("#user_warning").show();
					}
        		},
        		error:function(){
        			alert("注册失败");
        		}
        	});
        }
    });
});