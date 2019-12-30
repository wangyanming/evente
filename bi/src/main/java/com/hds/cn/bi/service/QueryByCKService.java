package com.hds.cn.bi.service;

import java.util.List;
import java.util.Map;

public interface QueryByCKService {
	public Map<String, Object> getTotalDataByDay(Map<String, Object> req);
	public List<Map<String, Object>> getTotalDataByHour(Map<String, Object> req);
	public List<Map<String, Object>> getDataByChannelId(Map<String, Object> req);
	public List<Map<String, Object>> getDataByDeviceType(Map<String, Object> req);
	public List<Map<String, Object>> getDataByPayWay(Map<String, Object> req);
	public List<Map<String, Object>> getDataByRegion(Map<String, Object> req);
	public List<Map<String, Object>> getBuyRate(Map<String, Object> req);
	public List<Map<String, Object>> getMultiActivity(Map<String, Object> req);
	public Map<String, Object> getMultiTotalData(Map<String, Object> req);
	public List<Map<String, Object>> getMultiProductData(Map<String, Object> req);
	public List<Map<String, Object>> getMultiProductDataByProductId(Map<String, Object> req);
	public List<Map<String, Object>> getMultiAgentData(Map<String, Object> req);
	public List<Map<String, Object>> getMultiAgentRegionData(Map<String, Object> req);
	public List<Map<String, Object>> getMultiAgentSaleData(Map<String, Object> req);
	public List<Map<String, Object>> getMultiAgentFromData(Map<String, Object> req);
	public List<Map<String, Object>> getMultiAgentClientData(Map<String, Object> req);
}
