package com.hds.hdyapp.service;

import java.util.List;
import java.util.Map;

public interface QueryByCKService {
	public Map<String, Object> getTotalData(Map<String, Object> req);
	public List<Map<String, Object>> getTotalDataByDay(Map<String, Object> req);
	public List<Map<String, Object>> getBestSellingByDay(Map<String, Object> req);
	public List<Map<String, Object>> getChannelDataByDay(Map<String, Object> req);
	public List<Map<String, Object>> getDataByChannelId(Map<String, Object> req);
	public List<Map<String, Object>> getRegionDataByDay(Map<String, Object> req);
	public List<Map<String, Object>> getDataByRegionId(Map<String, Object> req);
	public List<Map<String, Object>> getDeviceDataByDay(Map<String, Object> req);
	public List<Map<String, Object>> getDataByDeviceType(Map<String, Object> req);
	public List<Map<String, Object>> getPayWayDataByDay(Map<String, Object> req);
}
