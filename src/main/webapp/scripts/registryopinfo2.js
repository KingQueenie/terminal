search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadSetregvaluekey.do",
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
	var processName=$("#processName").val().trim();
	var processID=$("#processID").val().trim();
	var keyValue=$("#keyValue").val().trim();
	var regPath=$("#regPath").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadSetregvaluekeyByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			processName:processName,
			processID:processID,
			keyValue:keyValue,
			regPath:regPath,
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
		var dataType=judgeDataType(file);
		str+='<tr>';
		str+=   '<td>'+file.id+'</td>';
		str+=   '<td>'+file.processID+'</td>';		
		str+=   '<td>'+file.processName+'</td>';
		str+=   '<td>'+file.keyValue+'</td>';
		str+=   '<td>'+dataType+'</td>';
		str+=   '<td>'+file.dataSize+'</td>';
		str+=   '<td>'+file.regPath+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}
function judgeDataType(data){
	var dataType;	   
    if(data.dataType == 0){	
	    dataType = "REG_NONE";
    } else if(data.dataType == 1){
	    dataType = "REG_SZ";
    } else if(data.dataType == 2){
	    dataType = "REG_EXPAND_SZ";
    }else if(data.dataType == 3){
	    dataType = "REG_BINARY";
    } else if(data.dataType == 4) {
	    dataType = "REG_DWORD";
    } else if(data.dataType == 5) {
	    dataType = "REG_DWORD_LITTLE_ENDIAN";
    } else if(data.dataType == 6) {
	    dataType = "REG_LINK";
    } else if(data.dataType == 7) {
	    dataType = "REG_MULTI_SZ";
    } else if(data.dataType == 8) {
	    dataType = "REG_RESOURCE_LIST";
    } else if(data.dataType == 9) {
	    dataType = "REG_FULL_RESOURCE_DESCRIPTOR";
    } else if(data.dataType == 10) {
	    dataType = "REG_RESOURCE_REQUIREMENTS_LIST";
    } else if(data.dataType == 19) {
	    dataType = "重命名";
    } else if(data.dataType == 20) {
	    dataType = "删除键";
    } else {
	    dataType = "ERROR";
    }
    return dataType;
}