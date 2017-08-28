package com.xgs.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils; 
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xgs.entity.Fileinfo;
import com.xgs.service.FileService;
import com.xgs.util.TerResult;

@Controller
@RequestMapping("/file")
public class FileController {
	@Resource
	FileService service;
	@RequestMapping("/loadFiles.do")
	@ResponseBody
	public TerResult<List<Fileinfo>> load(int pageNum,int pageSize,String username){
		TerResult<List<Fileinfo>> result = new TerResult<List<Fileinfo>>();
		result=service.loadFiles(pageNum, pageSize, username);
//		System.out.println(result.getData());
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	
	@RequestMapping("/downloadFile.do")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			                               HttpServletResponse response) throws IOException {    
		String fileName = request.getParameter("fileName");
		//下载显示的文件名，解决中文名称乱码问题  
		//String fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8"); 用这个反而会乱码
		//下载文件路径
		String fileSaveRootPath = request.getServletContext().getRealPath("/WEB-INF/upload");
//		System.out.println(fileSaveRootPath);
		//得到要下载的文件
        File file = new File(fileSaveRootPath + "\\" + fileName);
        HttpHeaders headers = new HttpHeaders(); 
        //通知浏览器以attachment附件（下载方式）打开文件
        headers.setContentDispositionFormData("attachment", fileName); 
        //application/octet-stream ： 二进制流数据（最常见的文件下载）
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.CREATED);   
	}
//	异常处理
	@ExceptionHandler
	public String exHandle(Exception ex, HttpServletRequest request){
//		根据异常类型的不同，分别进行相同的处理
		if(ex instanceof FileNotFoundException){
			System.out.println("-------------->>>> "+"您要下载的资源已被删除！！");
			request.setAttribute("errorMsg", "您要下载的资源已被删除！！");
			return "../message";
		}
		return null;
	}	
	
	@RequestMapping("/modifyState.do")
	@ResponseBody
	public TerResult<Object> modifyState(String file_uniqueid, String stateValue, String alertsystembase_uniqueid){
		TerResult<Object> result = new TerResult<Object>();
		result=service.changeState(file_uniqueid, stateValue, alertsystembase_uniqueid);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}
	
	@RequestMapping("/uploadFile.do")
	@ResponseBody
	public void upload(HttpServletRequest req){
		String fileName = "";
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);		
		DiskFileItemFactory factory = new DiskFileItemFactory();  		
		// Configure a repository (to ensure a secure temp location is used)  
        ServletContext servletContext = req.getSession().getServletContext();  
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");  
        factory.setRepository(repository); 
        //System.out.println("-----------------uploading");
        // Create a new file upload handler  
        ServletFileUpload upload = new ServletFileUpload(factory); 
        upload.setHeaderEncoding("UTF-8"); 
        try {  
            List<FileItem> items = upload.parseRequest(req);  
            for(FileItem item : items) {  
                //其他参数  
                String type = item.getContentType();  
                if(type == null) {  
                   //System.out.println(item.getString(item.getFieldName()));  
                    continue;  
                }                    
                //文件参数  
                fileName = item.getName();                                  
                //设置保存文件路径  
                String realPath = req.getServletContext().getRealPath("/WEB-INF/upload");
                //System.out.println("-----------------realPath--"+realPath);
                File dir = new File(realPath);                 
                //System.out.println("-----------------filename--"+fileName);                
                if (!dir.exists() && !dir.isDirectory()) {
                    System.out.println(realPath+"目录不存在，需要创建");
                    //创建目录
                    dir.mkdir();
                }               
                File f = new File(dir, fileName);   
                f.createNewFile();                    
                //保存  
                item.write(f);  
                //写入数据库
            	Date now = new Date(); 
            	SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");//可以方便地修改日期格式
            	String username  =req.getParameter("username");
//            	System.out.println("-----------------username--"+username);
            	String unqiue = fileName+dateFormat.format(now);
            	String uniqueid =DigestUtils.md5Hex(unqiue);
//            	System.out.println("-----------------uniqueid--"+uniqueid);
            	TerResult<Object> result=service.addFile(uniqueid, username, fileName, realPath, "未检测", dateFormat.format(now));
            	System.out.println("-------------->>>> "+result.getMsg());
            }  
        }catch (FileUploadException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	}
	@RequestMapping("/removeFile.do")
	@ResponseBody
	public TerResult<Object> remove(Integer id){
		TerResult<Object> result=new TerResult<Object>();
		result=service.removeFile(id);
		System.out.println("-------------->>>> "+result.getMsg());
		return result;
	}

}
