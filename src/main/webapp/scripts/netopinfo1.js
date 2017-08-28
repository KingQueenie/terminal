search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadProcessoperation.do",
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
	var opType=$("#opType").val();
	var currentProcessName=$("#currentProcessName").val().trim();
	var currentProcessID=$("#currentProcessID").val().trim();
	var objectProcessName=$("#objectProcessName").val().trim();
	var objectProcessID=$("#objectProcessID").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadProcessoperationByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			opType:opType,
			currentProcessName:currentProcessName,
			currentProcessID:currentProcessID,
			objectProcessName:objectProcessName,
			objectProcessID:objectProcessID,
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
		var opType=judgeOpType(file);
		str+='<tr>';
		str+=   '<td>'+file.id+'</td>';
		str+=   '<td>'+file.currentProcessID+'</td>';		
		str+=   '<td>'+file.currentProcessName+'</td>';
		str+=   '<td>'+file.opType+'</td>';
		str+=   '<td>'+file.objectProcessID+'</td>';
		str+=   '<td>'+file.objectProcessName+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}
function judgeOpType(data){
	var opType;
	if(data.opType==1){
		opType = "结束当前进程";  
	} else if(data.opType==2){
		opType = "结束另一进程";
	} else if(data.opType==3){
		opType = "创建进程";
	} else if(data.opType==4){
		opType = "挂起进程";
	} else if(data.opType==5){
		opType = "恢复进程";
	} else {
		opType = "未知情况";
	}
	return opType;
}