package com.hdsbi.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ConvertParamsUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConvertParamsUtil.class);

	private static String tmpJsonStr;

	public static Map<String, Object> requestParams(LinkedHashMap<String, Object> paramsMap, String req) {
		Map<String, Object> temp = JSONObject.parseObject(req, Map.class);
		try {
			temp.forEach((k, v) -> {
				if ("java.lang.String".equals(v.getClass().getName())
						|| "java.lang.Integer".equals(v.getClass().getName())) {
					paramsMap.put(k, v);
				}

				if (JSONObject.class.getName().equals(v.getClass().getName())) {
					tmpJsonStr = JSONObject.toJSONString((Object) v);
					requestParams(paramsMap, tmpJsonStr);
				}

				if (JSONArray.class.getName().equals(v.getClass().getName())) {
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					List<Object> arrList = new ArrayList<Object>();
					JSONArray array = (JSONArray) v;
					if (JSONObject.class.getName().equals(array.get(0).getClass().getName())) {
						for (int i = 0; i < array.size(); i++) {
							Map<String, Object> map = JSONObject.parseObject(array.get(i).toString(), Map.class);
							if (map.containsKey("function")) {
								map.put("function", QueryConstant.getQueryFunction(map.get("function").toString()));
							}
							if (map.containsKey("params")) {
								map.put("params", map.get("params").toString().replaceAll("\\[", "")
										.replaceAll("\\]", "").replace("\"", "'"));
							}
							list.add(map);
						}
						paramsMap.put(k, list);
					} else {
						for (int i = 0; i < array.size(); i++) {
							arrList.add(array.get(i).toString().replace("\"", "'"));
						}
						paramsMap.put(k, arrList);
					}
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
		}
		return paramsMap;
	}
	
	public static Map<Object, List> getAllDate(String unit, String startDate, String endDate) {
		Map<Object, List> map4 = new LinkedHashMap();
		List<String> unitList = null;
		switch (unit) {
		case QueryConstant.MINUTE:
			unitList = DateUtils.getAllMinute(startDate);
			for (String str : unitList) {
				List list = new ArrayList<>();
				map4.put(str, list);
			}
			break;
		case QueryConstant.HOUR:
			unitList = DateUtils.getAllHour(startDate, endDate);
			for (String str : unitList) {
				List list = new ArrayList<>();
				map4.put(str, list);
			}
			break;
		case QueryConstant.DAY:
			unitList = DateUtils.getAllDay(startDate, endDate);
			for (String str : unitList) {
				List list = new ArrayList<>();
				map4.put(str, list);
			}
			break;
		case QueryConstant.WEEK:
			unitList = DateUtils.getAllWeek(startDate, endDate);
			for (String str : unitList) {
				List list = new ArrayList<>();
				map4.put(str, list);
			}
			break;
		case QueryConstant.MONTH:
			unitList = DateUtils.getAllMonth(startDate, endDate);
			for (String str : unitList) {
				List list = new ArrayList<>();
				map4.put(str, list);
			}
			break;
		case QueryConstant.YEAR:
			unitList = DateUtils.getAllYear(startDate, endDate);
			for (String str : unitList) {
				List list = new ArrayList<>();
				map4.put(str, list);
			}
			break;
		}
		
		return map4;
	}
}
