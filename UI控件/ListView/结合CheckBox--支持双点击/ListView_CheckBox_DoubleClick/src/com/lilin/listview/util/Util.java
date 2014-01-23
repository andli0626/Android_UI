package com.lilin.listview.util;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * 全局变量
 * 
 * @author lilin
 * @date 2012-2-6 下午01:41:20
 * @ClassName: Application
 */
public class Util {
	// 存储所有的Activity
	public static List<Activity> alist = new ArrayList<Activity>();

	// 背景色
	public static int backgroundcolor = 0x7f010002;

	// 当前用户登录ID
	public static String loginid;

	// 当前用户登录密码
	public static String password;

	// 当前用户姓名
	public static String name;

	// 当前用户guid
	public static String userguid;

	// 后台URL
	public static String seamurl;

}
