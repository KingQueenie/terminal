search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadModule.do",
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
	var processName=$("#processName").val().trim();
	var processNum=$("#processNum").val().trim();
	var regeditName=$("#regeditName").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadModuleByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			opType:opType,
			processName:processName,
			processNum:processNum,
			regeditName:regeditName,
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
		str+=   '<td>'+file.opType+'</td>';
		str+=   '<td>'+file.processNum+'</td>';
		str+=   '<td>'+file.processName+'</td>';
		str+=   '<td>'+file.regeditName+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}
function judgeOpType(data){
	var opType;
	if(data.opType==1){
		opType = "加载模块";  
	} else if(data.opType==2){
		opType = "卸载模块";
	}  else {
		opType = "其他";
	}
	return opType;
}