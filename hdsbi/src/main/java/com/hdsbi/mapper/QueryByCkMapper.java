package com.hdsbi.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryByCkMapper {
	public List<Map<String, Object>> eventAnalysis(Map<String, Object> map);
	
	public List<Map<String, Object>> overview(Map<String, Object> map);
	
	public LinkedList<Map<String, Object>> distributeAnalysis(Map<String, Object> map);
}
