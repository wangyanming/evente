package com.hdsbi.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.hdsbi.mapper.QueryByCkMapper;
import com.hdsbi.service.QueryByCkService;
import com.hdsbi.util.ConvertParamsUtil;
import com.hdsbi.util.DateUtils;

@Service
public class QueryByCkServiceImpl implements QueryByCkService{
	
	@Autowired
	private QueryByCkMapper queryByCkMapper;
	
	@Override
	public List<Map<String, Object>> overview(Map<String, Object> map) {
		String date = DateUtils.dateStampToDay(System.currentTimeMillis());
		map.put("day", date);
		return queryByCkMapper.overview(map);
	}

	@Override
	public Map<Object, List> eventAnalysis(Map<String, Object> map) {
		List<Object> measureMap = new ArrayList<Object>();
		List<Map<String, Object>> measurlist = (List<Map<String,Object>>) map.get("measures");
		Map<Object, List> map4 = null;
		for (Map<String, Object> map2 : measurlist) {
			List<Map<String, Object>> map3 = new ArrayList<Map<String, Object>>();
			map.put("eventName", map2.get("eventName"));
			map.put("aggregator", map2.get("aggregator"));
			map.put("field", map2.get("field"));
			map3 = queryByCkMapper.eventAnalysis(map);
			measureMap.add(map3);
		}
		
		//measureMap为空，直接返回
		if (measureMap.toString().length() <= measurlist.size() * 4) {
			return map4;
		}
		
		String startDate = map.get("startDate").toString();
		String endDate = map.get("endDate").toString();
		String unit1 = map.get("unit").toString();
		
		map4 = ConvertParamsUtil.getAllDate(unit1, startDate, endDate);
		
		for (Object map2 : measureMap) {
			//如果查询结果为空，则直接添加0
			if (map2.toString().length() <= 2) {
				for (Entry<Object, List> entry : map4.entrySet()) {
					entry.getValue().add(0);
				}
			} else {
				for (Map<String, Object> map3 : (List<Map<String, Object>>)map2) {
					
					String unit = null;
					String field = null;
					for (Entry<String, Object> entry : map3.entrySet()) {
						if ("unit".equals(entry.getKey())) {
							unit = entry.getValue().toString();
						} else if ("field".equals(entry.getKey())) {
							field = entry.getValue().toString();
						}
					}
					
					if (map4.containsKey(unit)) {
						map4.get(unit).add(field);
					} 
				}
				
				int size = 1;
				
				for (Entry<Object, List> entry : map4.entrySet()) {
					size = size > entry.getValue().size() ? size : entry.getValue().size();
				}
				
				for (Entry<Object, List> entry : map4.entrySet()) {
					if (entry.getValue().size() < size) {
						entry.getValue().add(0);
					}
				}
			}
		}
		return map4;
	}

	@Override
	public List<Map<String, Object>> distributeAnalysis(Map<String, Object> map) {
		List<Map> list = new ArrayList<>();
		List arr =  (List) map.get("rParams");
		for (int i = 0; i < arr.size(); i++) {
			if (i == 0) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("start", 0);
				paramMap.put("end", arr.get(i));
				list.add(paramMap);
			} else {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("start", arr.get(i-1));
				paramMap.put("end", arr.get(i));
				list.add(paramMap);
			}
		}
		
		Map m1 = Maps.newHashMap();
		m1.put("start", arr.get(arr.size()-1));
		list.add(m1);
		
		map.put("list", list);
		
		List<Map<String, Object>> result = queryByCkMapper.distributeAnalysis(map);
		return result;
	};

}
