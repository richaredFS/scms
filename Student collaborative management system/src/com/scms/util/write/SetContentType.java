package com.scms.util.write;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

/** 
 * @author  航
 * @version 创建时间：2017年2月2日 下午2:18:25 
 * 类说明 
 * 
 * 设置网页头请求
 */
public class SetContentType {
	/**
	 * 告诉浏览器 我要输出一个文本格式的内容到浏览器
	 * @param res
	 */
	public static void setWriterTextType(HttpServletResponse res){
		res.setContentType("text/xml;charset=UTF-8");	
	}
	/**
	 * 修改http请求头信息    告诉浏览器我要输出一个文件 到浏览器  而且是excel格式的
	 * @param res
	 * @param fileName
	 */
	public static void setWriterExcelFileType(HttpServletResponse res,String fileName){
		try {
			setFileType(res,"x-execl");
			res.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	/**
	 * 修改http请求头信息    告诉浏览器我要输出一个文件 到浏览器  而且是txt格式的
	 * @param res
	 * @param fileName
	 */
	public static void setWriterTxtFileType(HttpServletResponse res,String fileName){
		try {
			setFileType(res,"x-txt");
			res.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * 告诉浏览器我的文件格式
	 * @param res
	 * @param type
	 */
	public static void setFileType(HttpServletResponse res,String type){
		res.setContentType("application/"+type);
	}
}
