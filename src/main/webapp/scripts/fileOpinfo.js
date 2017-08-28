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
		var opType;
		var removable;
		opType=judgeOpType(file);
		removable=judgeRemovable(file);
		str+='<tr>';
		str+=   '<td>'+file.id+'</td>';
		str+=   '<td>'+opType+'</td>';
		str+=   '<td>'+removable+'</td>';
		str+=   '<td>'+file.filePath+'</td>';
		str+=   '<td>'+file.processName+'</td>';
		str+=   '<td>'+file.processPath+'</td>';
		str+=   '<td>'+file.time+'</td>';
		str+='</tr>';
	}
	$("#detailDetect_table tbody").html(str);
	loadPageNum(p,totalRecordsNum,totalPagesNum,loadType);
}
function judgeOpType(data){
	var opType; 
	if(data.opType==1){
		opType = "读文件";
	} else if(data.opType==2){
		opType = "写文件";
	} else if(data.opType==3){
		opType = "创建文件";
	}else if(data.opType==4) {
		opType = "打开文件";
	} else if(data.opType==5){
		opType = "删除文件";
	} else if(data.opType==6){
		opType = "CreateSection";
	}else if(data.opType==7){
		opType = "MapView";
	}else if(data.opType==8){
		opType = "UnmapView";
	}else if(data.opType==9){
		opType = "重命名";
	}else if(data.opType==10){
		opType = "删除目录";
	}else{
		opType = "未知";
	}
	return opType;
}
function judgeRemovable(data){
	var removable;
	if(data.removable==-1){
  		removable = "当前进程句柄";
    }else if(data.removable==1){
  		removable = "IO_TYPE_ADAPTRE";
    }else if(data.removable==2){
  		removable = "IO_TYPE_CONTROLLER";
    }else if(data.removable==3){
  		removable = "IO_TYPE_DEVICE";
    }else if(data.removable==4){
  		removable = "IO_TYPE_DRIVER";
    }else if(data.removable==5) {
  		removable = "IO_TYPE_FILE";
    }else if(data.removable==6){
  		removable = "IO_TYPE_IRP";
    }else if(data.removable==7){
  		removable = "IO_TYPE_ADAPTER";
    }else if(data.removable==8){
  		removable = "IO_TYPE_PACKET";
    }else if(data.removable==9){
  		removable = "IO_TYPE_TIMER";
    }else if(data.removable==10){
  		removable = "IO_TYPE_VPB";
    }else if(data.removable==11){
  		removable = "IO_TYPE_LOG";
    }else if(data.removable==12){
  		removable = "IO_TYPE_MESSAGE";
    }else if(data.removable==13){
  		removable = "IO_TYPE_EXTENSION";
    }else{
  		removable = "ERROR";
    }
	return removable;
}