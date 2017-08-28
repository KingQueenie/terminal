$("#user").html(getCookie("username"));
$("#home").click(function(){
	var userType=getCookie("userType");
	if(userType=="admin"){
		window.location.href="xgs_mainframe_admin.jsp";
	} else {
		window.location.href="xgs_mainframe.jsp";
	}	
});
$("#back").click(function(){history.go(-1);});
$("#forward").click(function(){history.go(1);});
$("#quit").click(function(){
	delCookie("loginstate");
	$.ajax({
		url:"user/quit.do",
		data:"POST",
		dataType:"json",
		success:function(result){
			if(result.status==0){
				window.location='xgs_login.jsp';
			}
		},
		error:function(){
			alert("网络连接有问题，请重新登录");
			window.location='xgs_login.jsp';
		}
	});
	
});
today();

//获取年月日和星期
function today(){
	var myDate = new Date();
    var day = myDate.toLocaleDateString();
    var wek;
    var year = myDate.getFullYear();
    var mon = myDate.getMonth()+1;
    var date = myDate.getDate();
	if (myDate.getDay() == 4) {			
		wek = "星期四";
	} else if (myDate.getDay() == 3) {
		wek = "星期三";
	} else if (myDate.getDay() == 2) {
		wek = "星期二";
	} else if (myDate.getDay() == 1) {
		wek = "星期一";
	} else if (myDate.getDay() == 5) {
		wek = "星期五";
	} else if (myDate.getDay() == 6) {
		wek = "星期六";
	} else {
		wek = "星期日";
	}
	var info = "今天是：" + year + "年"+mon+"月"+date+"日 &nbsp;" + wek + "&nbsp;&nbsp;&nbsp";
	$("#days").html(info);
}