$.ajax({
	url:"testDetails/loadBehavior.do",
	type:"POST",
	dataType:"json",
	success:function(result){
		// Create the input graph
		var g = new dagreD3.graphlib.Graph().setGraph({}).setDefaultEdgeLabel(function() { return {}; });
		//设置点	
	    var cnt = result.exData;
	    var type = "";
	    var aData;
	    var id;
		for(var i=0;i<cnt;i++){	
			aData=result.data[i];
			// 设置点
			g.setNode(aData.id, {label: aData.description,  class: aData.type });
			id = aData.id;
			type = aData.type;
			// 设置形状
			var node  = g.node(id);
			if( type == "top"){
				node.rx = node.ry = 30;
			} else{
				node.rx = node.ry = 5;
			}			
		}
		//设置边
	    for(var i=1;i<cnt;i++){
			g.setEdge(result.data[i].pid,  result.data[i].id ,{label: result.data[i].name});
		}		
		// Create the renderer
		var render = new dagreD3.render();
		// Set up an SVG group so that we can translate the final graph.
		var svg = d3.select("svg"),
		svgGroup = svg.append("g");
		// Run the renderer. This is what draws the final graph.
		render(d3.select("svg g"), g);
		// Center the graph
		var xCenterOffset = (svg.attr("width") - g.graph().width) / 2;
		svgGroup.attr("transform", "translate(" + xCenterOffset + ", 20)");
		svg.attr("height", g.graph().height + 40);		
		var ssvg =  document.querySelector('.csvg').innerHTML;
		var img = new Image();
	    img.src = 'data:image/svg+xml;base64,' + window.btoa(unescape(encodeURIComponent(ssvg))); //给图片对象写入base64编码的svg流
	    var canvas = document.createElement('canvas');  //准备空画布
	    canvas.width = $('.csvg svg').width();
	    canvas.height = $('.csvg svg').height();
	    var context = canvas.getContext('2d');  //取得画布的2d绘图上下文
	    if(img.complete){
	    	context.drawImage(img, 0, 0,700,300); 
	    	// 图片导出为 png 格式  
	    	var imgData = canvas.toDataURL('image/png');
	    	saveSvg(imgData.replace(" ","+"));
	    } else {
	    	img.onload=function(){
	    		context.drawImage(img, 0, 0,700,300);
	    		var imgData = canvas.toDataURL('image/png');
		    	saveSvg(imgData);
	    	};
	    	img.oneror=function(){
	    		context.drawImage(img, 0, 0,700,300);
	    	}
	    }
	    //document.getElementsByTagName('body')[0].appendChild(canvas);	   
	},
	error:function(){
		alert("加载样本检测报告失败！！");
	}
});
function saveSvg(imgData){ 
	$.ajax({
		url : "testDetails/saveSvg.do",
		type : "POST",
		dataType : "json",		
		data :{imgData:imgData},
		success : function(data) {
			//console.log("导出图片成功");
		},
		error : function() {
			alert("fail!");
		}
	});
}