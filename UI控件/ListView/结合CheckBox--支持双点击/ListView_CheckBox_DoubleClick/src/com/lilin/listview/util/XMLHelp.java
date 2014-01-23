package com.lilin.listview.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class XMLHelp {
	/**
	 * 将XML文件转换为String流的形式
	 * 
	 * @author lilin
	 * @date 2012-2-6 下午01:11:10
	 */
	public static String XMLFileToString(String xmlname, Context context) {
		/* 获取XML文件流 */
		InputStream XML_Stream = context.getClassLoader().getResourceAsStream(
				xmlname);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(XML_Stream));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return buffer.toString();
	}
	/**
	 * 获取XML标签之间的属性
	 * 如:
	 * bs = "<name>epoint</name>"
	 * att = "name"
	 * return "epoint"
	 */
	public static String getXMLAtt(String bs,String att){
		try{
			String  head = "<"+att+">";
			String tail = "</"+att+">";
			return bs.substring(bs.indexOf(head)+head.length(),bs.indexOf(tail));
		}catch(Exception e){
			return "";
		}
	}

}
