package com.hdsbi.util;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class QueryConstant {
	private static final String EQUAL = "in";
	private static final String NOTEQUAL = "!=";
	private static final String GREATER = ">";
	private static final String LESS = "<";
	private static final String CONTAIN = "in";
	private static final String NOTCONTAIN = "not in";
	private static final String ISEMPTY = "is null";
	private static final String ISNOTEMPTY = "is not null";
	
	public static final String MINUTE = "minute";
	public static final String HOUR = "hour";
	public static final String DAY = "day";
	public static final String WEEK = "week";
	public static final String MONTH = "month";
	public static final String YEAR = "year";
	
	public static final String FAILMSEG = "请求失败!!!";
	public static final String SUCCESSMSEG = "请求成功!!!";
	
	public static String getQueryFunction(String function) {
		switch (function.toUpperCase()) {
		case "EQUAL":
			return EQUAL;
		case "NOTEQUAL":
			return NOTEQUAL;
		case "GREATER":
			return GREATER;
		case "LESS":
			return LESS;
		case "CONTAIN":
			return CONTAIN;
		case "NOTCONTAIN":
			return NOTCONTAIN;
		case "ISEMPTY":
			return ISEMPTY;
		case "ISNOTEMPTY":
			return ISNOTEMPTY;
		}
		return function;
	}
	
	public static String getUnitFunction(String unit) {
		switch (unit.toUpperCase()) {
		case "MINUTE":
			return MINUTE;
		case "HOUR":
			return HOUR;
		case "DAY":
			return DAY;
		case "WEEK":
			return WEEK;
		case "MONTH":
			return MONTH;
		case "YEAR":
			return YEAR;
		}
		return unit;
	}
}
