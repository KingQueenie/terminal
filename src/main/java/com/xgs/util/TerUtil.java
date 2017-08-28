package com.xgs.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class TerUtil {	
//	获得现在的时间
	public static String get_now(){
		Date now = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date_time = dateformat.format(now);
		return date_time;
	}	
//	获得min分钟之前的时间
	public static String get_min_ago(int min){
		Date now = new Date();
		Date get_time = new Date(now.getTime()-min*60000);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date_time = dateformat.format(get_time);
		return date_time;
	}	
//	获得时间间隔
	public static long get_time_diff(String time1, String time2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    long diff=0;
		try {
	    	Date date1=sdf.parse(time1);
	    	Date date2=sdf.parse(time2);	    	
	    	diff = date2.getTime() - date1.getTime();
	    	//System.out.println("1111111111111111:"+time1);
	    	//System.out.println("2222222222222222:"+time2);
	    	//System.out.println("3333333333333333:"+diff);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		//Date date1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(time1);
		return diff;
	}
	

//	md5加密
	public static String encodeStrByMd5(String str) {  
		String md5Str = "";  
		try {  
		    MessageDigest md = MessageDigest.getInstance("MD5");  
		    // 使用指定byte[]更新摘要
		    md.update(str.getBytes());  
		    // 完成计算，返回结果数组
		    byte[] b = md.digest();  
		    md5Str = byteArrayToHex(b);
		} catch (Exception e) {  
			// TODO Auto-generated catch block
		    e.printStackTrace();  
		}  
		return md5Str;  
	}  	
	public static String byteArrayToHex(byte[] bytes) {  
		// 字符数组，用来存放十六进制字符
		char[] hexReferChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8',  
		'9', 'a', 'b', 'c', 'd', 'e', 'f' };  
		// 一个字节占8位，一个十六进制字符占4位；十六进制字符数组的长度为字节数组长度的两倍
		char[] hexChars = new char[bytes.length * 2];  
		int index = 0;  
		for (byte b : bytes) {  
			// 取字节的高4位
		    hexChars[index++] = hexReferChars[b >>> 4 & 0xf];  
		    // 取字节的低4位
		    hexChars[index++] = hexReferChars[b & 0xf];  
		}  
		return new String(hexChars);  
	}
	
	
//	判断字符串是否同时包含数字和字母
	public static boolean isLetterDigit(String str){  
		boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for(int i=0 ; i<str.length() ; i++){ //循环遍历字符串   
            if(Character.isDigit(str.charAt(i))){     //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;   
            }
            if(Character.isLetter(str.charAt(i))){   //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        if(isDigit && isLetter){
        	return true;
        }else{
        	return false;
        }
	}  
//	判断密码是否长度和格式要求
	public static int judgePwd(String pwd,int len_pwd) {
		int judge_state = 0;
		int len = pwd.length(); 
		if(len<len_pwd){
			judge_state = -1; 		//状态为-1表示密码长度小于len_pwd
			return judge_state;
		}
		boolean is_digit_letter = isLetterDigit(pwd);
		if(!is_digit_letter){
			judge_state = -2;		//状态为-2表示密码中没有同时包含数字和字母
			return judge_state;
		}
		return judge_state;
	}
//	将图片转化为png格式
	public static void convertToPng(String svgCode, OutputStream outputStream) throws TranscoderException, IOException {  
	    try {  
	        byte[] bytes = svgCode.getBytes("utf-8");  
	        PNGTranscoder t = new PNGTranscoder();  
	        TranscoderInput input = new TranscoderInput(new ByteArrayInputStream(bytes));  
	        TranscoderOutput output = new TranscoderOutput(outputStream);  
	        t.transcode(input, output);  
	        outputStream.flush();  
	    } finally {  
	        if (outputStream != null) {  
	            try {  
	                outputStream.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	} 
}
