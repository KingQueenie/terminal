search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadAlarminfo.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId
		},
		dataType:"json",
		success:function(result){
			loadData(result,p,pageSize,loadType);
		},
		error:function(){
			alert("文件列表响应完成但有问题！");
		}
	});
}
/*条件查询结果*/
function element_submit(p){
	var loadType="element_submit";
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var type=$("#type").val();
	var processName=$("#processName").val().trim();
	var path=$("#path").val().trim();
	var explain1=$("#explain1").val().trim();
	var explain2=$("#explain2").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadAlarminfoByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			type:type,
			processName:processName,
			path:path,
			explain1:explain1,
			explain2:explain2,
			time:time				
		},
		dataType:"json",
		success:function(result){
			loadData(result,p,pageSize,loadType);
		},
		error:function(){
			alert("文件列表响应完成但有问题！");
		}
	});
}
function loadData(result,p,pageSize,loadType){
	var str="";
	var currentPage=$("#currentPage");
	var totalPages=$("#totalPages");
	var totalRecords=$("#totalRecords");
	var currentPageNum=p;
	currentPage.val(currentPageNum);
	var totalRecordsNum=result.exData;
	totalRecords.val(totalRecordsNum);
	var resiRecordsNum=totalRecordsNum-(p-1)*pageSize;
	var totalPagesNum=Math.ceil(totalRecordsNum/pageSize);
	totalPages.val(totalPagesNum);
	for(var i=0;i<result.data.length;i++){
		var file=result.data[i];
		var warningType=judgeWarningType(file);
		str+='<tr>';
		str+=   '<td>'+file.id+'</td>';
		str+=   '<td>'+warningType+'</td>';		
		str+=   '<td>'+file.processName+'</td>';
		str+=   '<td>'+file.path+'</td>';
		str+=   '<td>'+file.explain1+'</td>';
		str+=   '<td>'+file.explain2+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+=   '<td><span class="glyphicon glyphicon-chevron-down"></span></td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}
function judgeWarningType(data){
	var warningType;
	switch (data.type){
	case 1:
		warningType = "启动自释放文件"; 
		break;
	case 2:	
		warningType = "注册服务动态库";
		break;
	case 3:
		warningType = "添加系统防火墙放过列表";
		break;
	case 4:
		warningType = "禁止服务";
		break;
	case 5:
		warningType = "降低系统安全性";
		break;
	case 6:
		warningType = "修改注册表自启动项";
		break;
	case 7:
		warningType = "覆写PE文件";
		break;
	case 8:
		warningType = "感染PE文件";
		break;
	case 9:
		warningType = "入侵进程";
		break;
	case 10:
		warningType = "隐蔽执行";
		break;
	case 11:
		warningType = "自我删除";
		break;
	case 12:
		warningType = "自我复制";
		break;
	case 13:
		warningType = "释放PE文件";
		break;
	case 14:
		warningType = "释放隐蔽文件";
		break;
	case 15:
		warningType = "进程异常";
		break;
	case 16:
		warningType = "文件异常";
		break;
    default :
    	warningType = "未知类型";
    	break;
	}
	return warningType;
}