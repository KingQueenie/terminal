search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadNetinfo.do",
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
	var dataProtocol=$("#dataProtocol").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadNetinfoByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			opType:opType,
			processName:processName,
			dataProtocol:dataProtocol,
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
		str+=   '<td>'+opType+'</td>';
		str+=   '<td>'+file.dataProtocol+'</td>';
		str+=   '<td>'+file.localIP+'</td>';
		str+=   '<td>'+file.localPort+'</td>';
		str+=   '<td>'+file.processName+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}
function judgeOpType(data){
	var opType;
	if(data.opType==1){
		opType = "bind";  
	} else if(data.opType==2){
		opType = "sento";
	} else if(data.opType==3){
		opType = "connect";
	} else if(data.opType==4){
		opType = "send";
	} else if(data.opType==5){
		opType = "recv";
	} else if(data.opType==6){
		opType = "recvfrom";
	} else if(data.opType==7){
		opType = "ping";
	} else if(data.opType==8) {
		opType = "accept";
	} else {
		opType = "Others";
	}
	return opType;
}