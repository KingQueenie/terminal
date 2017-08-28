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
					str+='<a href=xgs_mainframe_detail_admin.jsp?uniqueId='+uniqueId+' class="de">';
					str+=	' <span class="glyphicon glyphicon-list-alt"></span> 检测详情';
					str+='</a>';
					str+='<a href="#" onclick=deleteInfo('+file.id+')>';
					str+=	'<span class="glyphicon glyphicon-remove remove"></span> 删除';
                    str+='</a>';
					str+='</td>';
				} else {
					str+='<td>';
					str+='<a href="#" onclick=deleteInfo('+file.id+')>';
					str+=	'<span class="glyphicon glyphicon-remove remove"></span> 删除';
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

/***上传文件***/
var upload_btn=$("#upload");
var close_btn=$("#close");
var commit_btn=$("#commit");
var upload_div=$("#upload_div");
var wait_loading=$("#wait_loading");
upload_btn.click(function(){
    upload_div.show();
});
close_btn.click(function(){
	upload_div.hide();
})
commit_btn.click(commit);
function commit(){
	upload_div.hide();
	wait_loading.ajaxStart(function(){
		$(this).show();
	}).ajaxComplete(function(){
		$(this).hide();
	});
	if($("#uploadFile").val().length>0){
		ajaxFileUpload();
	} else {
		alert("请选择要上传的文件！！");
		upload_div.show();
	}
}
function ajaxFileUpload(){
	var username=getCookie("username");
	$.ajaxFileUpload({
		url:"file/uploadFile.do?username="+username,
		type:"POST", 		
		secureuri:false, //是否需要安全协议，默认为false
		fileElementId:"uploadFile", //需要上传的文件域的ID，即<input type="file">的ID
		success:function(data,status){
			if(status=="success"){
				alert("上传文件成功！");
				location.reload();
			}
		},
		error:function(data,status,e){
			alert(e);
		}
	});
}
/***删除文件***/
function deleteInfo(id){
	if (confirm("确认删除？")==true){
		$.ajax({
			url : "file/removeFile.do",
			type : "POST",
			dataType : "json",				
			data : {id:id},
		    success:function(result){
		    	if(result.status==0){
		    		alert("删除成功！");
			    	location.reload();
		    	}		    	
		    },
			error : function() {
				alert("网络连接有问题,请重新登陆!");
			}
	   });
	    return true;
	}else{
	    return false;
	}
}

