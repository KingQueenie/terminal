search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadCreatethread.do",
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
	var currentProcessName=$("#currentProcessName").val().trim();
	var currentProcessID=$("#currentProcessID").val().trim();
	var targetProcessName=$("#targetProcessName").val().trim();
	var targetProcessID=$("#targetProcessID").val().trim();
	var threadHandle=$("#threadHandle").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadCreatethreadByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			currentProcessName:currentProcessName,
			currentProcessID:currentProcessID,
			targetProcessName:targetProcessName,
			targetProcessID:targetProcessID,
			threadHandle:threadHandle,
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
		str+='<tr>';
		str+=   '<td>'+file.id+'</td>';
		str+=   '<td>'+file.currentProcessID+'</td>';		
		str+=   '<td>'+file.currentProcessName+'</td>';
		str+=   '<td>'+file.threadHandle+'</td>';
		str+=   '<td>'+file.targetProcessID+'</td>';
		str+=   '<td>'+file.targetProcessName+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}