/***加载文件***/
$(function(){
	search_submit(1);
});
function search_submit(p){
	var loadType="search_submit";
	var username = getCookie("username");
	//console.log(username);
	var currentPage=$("#currentPage");
	var totalPages=$("#totalPages");
	var totalRecords=$("#totalRecords");
	var pageSize=15;
	$.ajax({
		url:"file/loadFiles.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			username:username
		},
		dataType:"json",
		success:function(result){
			var pli="";
			var str="";
			//console.log(result);
			//console.log(result.status);
			//console.log(result.msg);
			//console.log(result.data);
			//console.log(result.data[1].id);
			//console.log(result.data[1].file_alertsystembase_uniqueid.alertsystembase_uniqueid);
			//console.log(result.data.length);
			var currentPageNum=p;
			currentPage.val(currentPageNum);
			var totalRecordsNum=result.exData;
			totalRecords.val(totalRecordsNum);
			var resiRecordsNum=totalRecordsNum-(p-1)*pageSize;
			var totalPagesNum=Math.ceil(totalRecordsNum/pageSize);
			totalPages.val(totalPagesNum);
			for(var i=0;i<result.data.length;i++){
				var file=result.data[i];
				var nums=i+1;
				str+='<tr>';
				str+=   '<td>'+nums+'</td>';
				str+=   '<td>'+file.file_alertsystembase_uniqueid.file_uniqueid+'</td>';
				str+=   '<td>'+file.fileName+'</td>';
				str+=   '<td>'+file.time+'</td>';
				str+=   '<td>'+file.state+'</td>';
				if(file.state=="已检测"){
					var uniqueId=file.file_alertsystembase_uniqueid.alertsystembase_uniqueid;
					str+='<td class="tested">';
					str+='<a href=xgs_mainframe_detail_admin.jsp?uniqueId='+uniqueId+'>';
					str+=	' <span class="glyphicon glyphicon-list-alt"></span> 检测详情';
					str+='</a>';
					str+='</td>';
				} else {
					str+='<td>';
					str+='<a href=file/downloadFile.do?fileName='+file.fileName+'>';
					str+=	' <span class="glyphicon glyphicon-save"></span>下载';
                    str+='</a>';
                    str+='</td>';
				}
				str+='</tr>';
			}
			$("#file_table tbody").html(str);
			loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);			
		},
		error:function(){
			alert("文件列表响应完成但有问题！");
		}
	});
}

/***修改文件状态件***/
var edit_div=$("#edit_div");
var close_btn=$("#close");
var save_btn=$("#save");
var cancel_btn=$("#cancel");
var modify_btn=$("#modify");
modify_btn.click(function(){
    edit_div.show();
});
close_btn.click(function(){
    edit_div.hide();
});
cancel_btn.click(function(){
    edit_div.hide();
});
var uniqueid_warning=$("#uniqueid_warning");
var systembase_warning=$("#systembase_warning");
$("#uniqueid").focus(function(){
	uniqueid_warning.hide();
});
$("#systembase").focus(function(){
	systembase_warning.hide();
});
$("#detectState").blur(function(){
	if($("#detectState").val().trim()=="0"){
		systembase_warning.hide();
	}
});
save_btn.click(function(){
	var file_uniqueid=$("#uniqueid").val().trim();
	var stateValue=$("#detectState").val().trim();
	var alertsystembase_uniqueid=$("#systembase").val().trim();
	var ok=true;
	if(file_uniqueid==""){
		uniqueid_warning.html("请输入文件的唯一标识");
		uniqueid_warning.show();
		ok=false;
	}
	if(stateValue=="1"){
    	if(alertsystembase_uniqueid==""){
    		systembase_warning.html("请输入检测系统的唯一标识");
    		systembase_warning.show();
    		ok=false;
    	}
	} else {
		systembase_warning.hide();
	}
	if(ok){
    	$.ajax({
    		url:"file/modifyState.do",
    		type:"POST",
    		dataType:"json",
    		data:{
    			file_uniqueid:file_uniqueid,
    			stateValue:stateValue,
    			alertsystembase_uniqueid:alertsystembase_uniqueid
    		},
    		success:function(result){
    			if(result.status=="1"){
    				uniqueid_warning.html(result.msg);
    				uniqueid_warning.show();
    			} else if(result.status=="0"){
    				alert(result.msg);
    				window.location.reload();
    			}
    		},
    		error:function(){
    			alert("修改状态失败，请重新再试！");
    		}
    	});
	}
});