var protocol=window.location.protocol; //获取协议名
var host=window.location.host; //获取主机名和端口号
var pathname=window.location.pathname;
var indexSlash =  pathname.substr(1).indexOf("/");
var contextPath=pathname.substr(0,indexSlash+1); //获取项目名 terminal1 
var basePath=protocol+"://"+host+contextPath+"/"; //http://localhost:8080/terminal1/