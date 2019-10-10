package com.hdsbi.service;

import java.util.List;
import java.util.Map;

public interface QueryByCkService {
	
	public Map<Object, List> eventAnalysis(Map<String, Object> map);
	
	public List<Map<String, Object>> overview(Map<String, Object> map);
	
	public List<Map<String, Object>> distributeAnalysis(Map<String, Object> map);
}
