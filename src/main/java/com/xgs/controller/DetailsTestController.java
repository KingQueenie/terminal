package com.xgs.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.batik.transcoder.TranscoderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;
import com.xgs.entity.Alarminfo;
import com.xgs.entity.Behavior;
import com.xgs.entity.Createthread;
import com.xgs.entity.FileSysteminfo;
import com.xgs.entity.Module;
import com.xgs.entity.Netinfo;
import com.xgs.entity.Pendingthread;
import com.xgs.entity.Processoperation;
import com.xgs.entity.Recoverthread;
import com.xgs.entity.Reginfo;
import com.xgs.entity.Setregvaluekey;
import com.xgs.service.DetailsTestService;
import com.xgs.util.TerResult;

import sun.misc.BASE64Decoder;

@Controller
@RequestMapping("/testDetails")
public class DetailsTestController {
	private static final long serialVersionUID = -6255840467175259021L;
	@Resource
	DetailsTestService service;
	// 文件操作详情
	@RequestMapping("/loadFileSysteminfo.do")
	@ResponseBody
	public TerResult<List<FileSysteminfo>> loadSysteminfo(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		result=service.loadFileSysteminfo(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadFileSysteminfoByElements.do")
	@ResponseBody
	public TerResult<List<FileSysteminfo>> loadSysteminfoByElements(
			int pageNum,int pageSize,Integer uniqueId,Integer opType,Integer removable,
			String filePath,String processName,String processPath,String time){
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		result=service.loadFileSysteminfoByElements(pageNum, pageSize, uniqueId, opType, removable, filePath, processName, processPath, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 文件map操作详情
	@RequestMapping("/loadFileSystemMapinfo.do")
	@ResponseBody
	public TerResult<List<FileSysteminfo>> loadMapinfo(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		result=service.loadFileSystemMapinfo(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadFileSystemMapinfoByElements.do")
	@ResponseBody
	public TerResult<List<FileSysteminfo>> loadFileMapByElements(
			int pageNum,int pageSize,Integer uniqueId,Integer opType,Integer removable,
			String filePath,String processName,String processPath,String time){
		TerResult<List<FileSysteminfo>> result=new TerResult<List<FileSysteminfo>>();
		result=service.loadFileSystemMapinfoByElements(pageNum, pageSize, uniqueId, opType, removable, filePath, processName, processPath, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 网络使用信息
	@RequestMapping("/loadNetinfo.do")
	@ResponseBody
	public TerResult<List<Netinfo>> loadNet(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Netinfo>> result=new TerResult<List<Netinfo>>();
		result=service.loadNetinfo(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadNetinfoByElements.do")
	@ResponseBody
	public TerResult<List<Netinfo>> loadNetByElements(int pageNum, int pageSize, Integer uniqueId, 
			Integer opType,String processName, Integer dataProtocol, String time){
		TerResult<List<Netinfo>> result=new TerResult<List<Netinfo>>();
		result=service.loadNetinfoByElements(pageNum, pageSize, uniqueId, opType, processName, dataProtocol, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 注册表基本信息
	@RequestMapping("/loadReginfo.do")
	@ResponseBody
	public TerResult<List<Reginfo>> loadReg(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Reginfo>> result=new TerResult<List<Reginfo>>();
		result=service.loadReginfo(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadReginfoByElements.do")
	@ResponseBody
	public TerResult<List<Reginfo>> loadRegByElements(int pageNum, int pageSize, Integer uniqueId, Integer opType,
			String processName, Integer processId, String regPath, String time){
		TerResult<List<Reginfo>> result=new TerResult<List<Reginfo>>();
		result=service.loadReginfoByElements(pageNum, pageSize, uniqueId, opType, processName, processId, regPath, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 注册表赋值操作
	@RequestMapping("/loadSetregvaluekey.do")
	@ResponseBody
	public TerResult<List<Setregvaluekey>> loadSetregvaluekey(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Setregvaluekey>> result=new TerResult<List<Setregvaluekey>>();
		result=service.loadSetregvaluekey(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadSetregvaluekeyByElements.do")
	@ResponseBody
	public TerResult<List<Setregvaluekey>> loadSetregvaluekeyByElements(int pageNum, int pageSize, Integer uniqueId, String processName,Integer processID,String keyValue,String regPath,String time){
		TerResult<List<Setregvaluekey>> result=new TerResult<List<Setregvaluekey>>();
		result=service.loadSetregvaluekeyByElements(pageNum, pageSize, uniqueId, processName, processID, keyValue, regPath, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 进程操作信息
	@RequestMapping("/loadProcessoperation.do")
	@ResponseBody
	public TerResult<List<Processoperation>> loadProcessoperation(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Processoperation>> result=new TerResult<List<Processoperation>>();
		result=service.loadProcessoperation(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadProcessoperationByElements.do")
	@ResponseBody
	public TerResult<List<Processoperation>> loadProcessoperationByElements(int pageNum, int pageSize, Integer uniqueId,
			Integer opType, String currentProcessName, Integer currentProcessID, String objectProcessName,
			Integer objectProcessID, String time){
		TerResult<List<Processoperation>> result=new TerResult<List<Processoperation>>();
		result=service.loadProcessoperationByElements(pageNum, pageSize, uniqueId, opType, currentProcessName, currentProcessID, objectProcessName, objectProcessID, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 进程操作线程信息
	@RequestMapping("/loadCreatethread.do")
	@ResponseBody
	public TerResult<List<Createthread>> loadCreatethread(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Createthread>> result=new TerResult<List<Createthread>>();
		result=service.loadCreatethread(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadCreatethreadByElements.do")
	@ResponseBody
	public TerResult<List<Createthread>> loadCreatethreadByElements(int pageNum, int pageSize, Integer uniqueId,
			String currentProcessName,Integer currentProcessID,String targetProcessName,
			Integer targetProcessID,String threadHandle,String time){
		TerResult<List<Createthread>> result=new TerResult<List<Createthread>>();
		result=service.loadCreatethreadByElements(pageNum, pageSize, uniqueId, currentProcessName, currentProcessID, targetProcessName, targetProcessID, threadHandle, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 挂起线程操作信息
	@RequestMapping("/loadPendingthread.do")
	@ResponseBody
	public TerResult<List<Pendingthread>> loadPendingthread(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Pendingthread>> result=new TerResult<List<Pendingthread>>();
		result=service.loadPendingthread(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadPendingthreadByElements.do")
	@ResponseBody
	public TerResult<List<Pendingthread>> loadPendingthreadByElements(int pageNum, int pageSize, Integer uniqueId,
			String currentProcessName,Integer currentProcessID,String dependProcessName,String dependProcessID,
			String pendingProcessID,String time){
		TerResult<List<Pendingthread>> result=new TerResult<List<Pendingthread>>();
		result=service.loadPendingthreadByElements(pageNum, pageSize, uniqueId, currentProcessName, currentProcessID, dependProcessName, dependProcessID, pendingProcessID, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 恢复线程操作信息
	@RequestMapping("/loadRecoverthread.do")
	@ResponseBody
	public TerResult<List<Recoverthread>> loadRecoverthread(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Recoverthread>> result=new TerResult<List<Recoverthread>>();
		result=service.loadRecoverthread(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadRecoverthreadByElements.do")
	@ResponseBody
	public TerResult<List<Recoverthread>> loadRecoverthreadByElements(int pageNum, int pageSize, Integer uniqueId,
			String currentProcessName,Integer currentProcessID,String dependProcessName,String dependProcessID,
			String pendingProcessID,String time){
		TerResult<List<Recoverthread>> result=new TerResult<List<Recoverthread>>();
		result=service.loadRecoverthreadByElements(pageNum, pageSize, uniqueId, currentProcessName, currentProcessID, dependProcessName, dependProcessID, pendingProcessID, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 模块操作
	@RequestMapping("/loadModule.do")
	@ResponseBody
	public TerResult<List<Module>> loadModule(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Module>> result=new TerResult<List<Module>>();
		result=service.loadModule(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadModuleByElements.do")
	@ResponseBody
	public TerResult<List<Module>> loadModuleByElements(int pageNum, int pageSize,Integer uniqueId, 
			Integer opType,String processName, Integer processNum, String regeditName, String time){
		TerResult<List<Module>> result=new TerResult<List<Module>>();
		result=service.loadModuleByElements(pageNum, pageSize, uniqueId, opType, processName, processNum, regeditName, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 告警信息
	@RequestMapping("/loadAlarminfo.do")
	@ResponseBody
	public TerResult<List<Alarminfo>> loadAlarminfo(int pageNum,int pageSize,Integer uniqueId){
		TerResult<List<Alarminfo>> result=new TerResult<List<Alarminfo>>();
		result=service.loadAlarminfo(pageNum, pageSize, uniqueId);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/loadAlarminfoByElements.do")
	@ResponseBody
	public TerResult<List<Alarminfo>> loadAlarminfoByElements(int pageNum, int pageSize,Integer uniqueId,Integer type,
			String processName,String path,String explain1,String explain2,String time){
		TerResult<List<Alarminfo>> result=new TerResult<List<Alarminfo>>();
		result=service.loadAlarminfoByElements(pageNum, pageSize, uniqueId, type, processName, path, explain1, explain2, time);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	// 样本检测报告
	@RequestMapping("/loadBehavior.do")
	@ResponseBody
	public TerResult<List<Behavior>> loadBehavior(){
		TerResult<List<Behavior>> result=new TerResult<List<Behavior>>();
		result=service.loadBehavior();
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/saveSvg.do")
	@ResponseBody
	public TerResult<Object> saveSvg(HttpServletRequest req) throws IOException, TranscoderException{
		TerResult<Object> result = new TerResult<Object>();								
		String imgData = req.getParameter("imgData");
		String [] strs = imgData.split("[,]");		
//		System.out.println(imgData);
		String savePath = req.getSession().getServletContext().getRealPath("/")+"temp\\";
//		System.out.println(savePath);
		File file=new File(savePath);
		if(!file.exists()) {
			file.mkdir();
		}
		try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = decoder.decodeBuffer(strs[1]);
            for(int i=0;i<b.length;++i){
                if(b[i]<0){//调整异常数据
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(savePath+"demo_tree.png"); //生成图片  
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		result.setStatus(0);
		result.setMsg("生成图片成功");
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	@RequestMapping("/exportTree.do")
	@ResponseBody
	public void exportTree(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		ServletContext sc = req.getSession().getServletContext();  
        String path = sc.getRealPath("");
      //把路径中的反斜杠转成正斜杠  
        path = path.replaceAll("\\\\", "/"); // 输出为D:/xampp/tomcat/wtpwebapps/terminal1
//        System.out.println(path);
        String path3 = req.getContextPath();  //输出---/terminal1
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path3+"/";  
        //输出为：http://localhost:8080/terminal/
        res.setContentType("application/pdf");  
        //res.setHeader("Content-Disposition", "attachment; filename=WebReport.pdf");  
        res.setHeader("Content-Disposition", "inline; filename=Report.pdf");  		            
        //jsp --> pdf
        ByteArrayOutputStream to_file;    
        String ur=basePath+"d_tree.jsp"; 
        to_file = new ByteArrayOutputStream();//输出到控制台
        URL url = new URL(ur);
        String protocol = url.getProtocol();  
        if (!protocol.equals("http"))   
           throw new IllegalArgumentException("Must use 'http:' protocol"); 
        String host = url.getHost();  
        int port = url.getPort();  
        if (port == -1) port = 80;   
        String filename = url.getFile();  
        Socket socket = new Socket(host, port);//打开一个socket连接  
        InputStream from_server = socket.getInputStream();//获取输入流  
        PrintWriter to_server = new PrintWriter(socket.getOutputStream());//获取输出流        
        to_server.print("GET " + filename + "\n\n");//请求服务器上的文件  
        to_server.flush();  // Send it right now!           
        byte[] buffer = new byte[4096];  
        int bytes_read;  
        //读服务器上的响应，并写入文件。  
        while((bytes_read = from_server.read(buffer)) != -1) {
        	to_file.write(buffer, 0, bytes_read);
        }  
        String htmls = new String(to_file.toByteArray(),"utf-8");      
        socket.close();  
        to_file.close();	                
        // parse our markup into an xml Document  
        try {  
            ITextRenderer renderer = new ITextRenderer();  
            ///解决中文问题
            ITextFontResolver fontResolver = renderer.getFontResolver(); 
            fontResolver.addFont("C:/Windows/Fonts/SIMSUN.TTC",
            		BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);           		            
            renderer.setDocumentFromString(htmls); 		           		             		            
            // 解决图片的相对路径问题    
            renderer.getSharedContext().setBaseURL("file:/" + path + "/images");              
            renderer.layout();  
            OutputStream os = res.getOutputStream();  
            renderer.createPDF(os);  
            os.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}
}
