search_submit(1);
$("#save").click(function(){element_submit(1);});
function search_submit(p){
	var pageSize=15;
	var uniqueId=GetRequestParam();
	var loadType="search_submit";
	$.ajax({
		url:"testDetails/loadFileSysteminfo.do",
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
	var removable=$("#removable").val();
	var filePath=$("#filePath").val().trim();
	var processName=$("#processName").val().trim();
	var processPath=$("#processPath").val().trim();
	var time=$("#time").val().trim();
	$.ajax({
		url:"testDetails/loadFileSysteminfoByElements.do",
		type:"POST",
		data:{
			pageNum:p,
			pageSize:pageSize,
			uniqueId:uniqueId,
			opType:opType,
			removable:removable,
			filePath:filePath,
			processName:processName,
			processPath:processPath,
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
