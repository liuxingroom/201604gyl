package com.xing.gyl.utils;

import java.util.Calendar;

public class GyUtils {

	public static String getDateToString(){
		//获取一个日期的实例
		Calendar calendar=Calendar.getInstance();
		//获取年
		int year=calendar.get(Calendar.YEAR);
		//获取月
		int month=calendar.get(Calendar.MONTH+1);//得到月，因为从0开始的，所以要加1
		//获取天
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		return ""+year+month+day;
	}
	
	public static String getDHH(String type){
		//获取一个日期的实例
		Calendar calendar=Calendar.getInstance();
		//获取年
		int year=calendar.get(Calendar.YEAR);
		//获取月
		int month=calendar.get(Calendar.MONTH+1);//得到月，因为从0开始的，所以要加1
		//获取天
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		return type+year+month+day;
	}
}
