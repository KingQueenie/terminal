/*加载页码*/
function loadPageNum(p,totalRecordsNum,totalPagesNum,loadType){
	if(loadType=="element_submit"){
		submit=element_submit;
	} else {
		submit=search_submit;
	}
	var pli="";
	pli+='<li><a href="#" id="firstpage" onClick="firstPage(submit);">首页</a></li>';
	pli+='<li><a href="#" id="lastpage" onClick="lastPage(submit);">上一页</a></li>';
	pli+='<li><a href="#" id="nextpage" onClick="nextPage(submit);">下一页</a></li>';
	pli+='<li><a href="#" id="endpage" onClick="endPage(submit);">尾页</a></li>';
	pli+='<li class="skipPageNum">';
	pli+=   '跳转到第&nbsp;';
	pli+=   '<label class="sr-only" for="skipPageNum">跳转的页数</label>';
	pli+=   '<input type="text" id="skipPage">&nbsp;页';
	pli+='</li>';
	pli+='<li><a href="#" onClick="skipPage(submit);">GO!</a></li>';
	pli+=' <li>';
	pli+=   ' 共有'+totalRecordsNum+'条记录，当前第'+p+'/'+totalPagesNum+'页';
	pli+=' </li>';
	$(".bot_page").html(pli);
}
function loadPageNum1(p,totalRecordsNum,totalPagesNum,loadType){
	if(loadType=="element_search"){
		submit=element_submit;
	} else {
		submit=search_submit;
	}
	var pli="";
	pli+='<li><a href="#" id="firstpage" onClick="firstPage(submit);">首页</a></li>';
	pli+='<li><a href="#" id="lastpage" onClick="lastPage(submit);">上一页</a></li>';
	pli+='<li><a href="#" id="nextpage" onClick="nextPage(submit);">下一页</a></li>';
	pli+='<li><a href="#" id="endpage" onClick="endPage(submit);">尾页</a></li>';
	pli+='<li class="skipPageNum">';
	pli+=   '跳转到第&nbsp;';
	pli+=   '<label class="sr-only" for="skipPageNum">跳转的页数</label>';
	pli+=   '<input type="text" id="skipPage">&nbsp;页';
	pli+='</li>';
	pli+='<li><a href="#" onClick="skipPage(submit);">GO!</a></li>';
	pli+=' <li>';
	pli+=   ' 共有'+totalRecordsNum+'条记录，当前第'+p+'/'+totalPagesNum+'页';
	pli+=' </li>';
	$(".bot_page").html(pli);
}
function firstPage(submit){
	var currentPageNum=$("#currentPage").val();
	if(currentPageNum==1){
		alert("当前页就是首页");
	} else {
		submit(1);
		$("#currentPage").val(1);
	}
}
function lastPage(submit){
	var currentPageNum=$("#currentPage").val();
	currentPageNum=parseFloat(currentPageNum);
	var page=currentPageNum-1;
	if(currentPageNum==1){
		alert("当前页已经是首页");
	} else {
		submit(page);
		$("#currentPage").val(page);
	}
}
function nextPage(submit){
	var currentPageNum=$("#currentPage").val();
	currentPageNum=parseFloat(currentPageNum);
	var totalPagesNum=$("#totalPages").val();
	totalPagesNum=parseFloat(totalPagesNum);
	var page=currentPageNum+1;
	if(currentPageNum==totalPagesNum){
		alert("当前页已经是尾页");
	} else {
		submit(page);
		$("#currentPage").val(page);
	}
}
function endPage(loadType){
	var currentPageNum=$("#currentPage").val();
	var totalPagesNum=$("#totalPages").val();
	if(currentPageNum==totalPagesNum){
		alert("当前页就是尾页");
	} else {
		submit(totalPagesNum);
		$("#currentPage").val(totalPagesNum);
	}
}
function skipPage(submit){
	var currentPageNum=$("#currentPage").val();
	var totalPagesNum=$("#totalPages").val();
	var skipPageNum=$("#skipPage").val();
	page=parseFloat(skipPageNum);
	if(skipPageNum==""){
		alert("请输入您要跳转的页数！");
	} else if(page>0 && page<=totalPagesNum){
		submit(page);
	} else {
		alert("您输入的页数超出了范围！");
	}
}
