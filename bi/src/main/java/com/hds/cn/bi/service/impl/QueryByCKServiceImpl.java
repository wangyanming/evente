package com.hds.cn.bi.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.cn.bi.mapper.QueryByCKMapper;
import com.hds.cn.bi.service.QueryByCKService;

@Service
public class QueryByCKServiceImpl implements QueryByCKService{
	
	@Autowired
	private QueryByCKMapper queryByCKMapper;

	@Override
	public Map<String, Object> getTotalDataByDay(Map<String, Object> req) {
		List<Map<String, Object>> resultList = queryByCKMapper.getTotalDataByDay(req);
		Map<String, Object> rsMap = new HashMap<String, Object>();
		for (Map<String, Object> map : resultList) {
			for (Entry<String, Object> map1 : map.entrySet()) {
				rsMap.put(map1.getKey(), map1.getValue());
			}
		}
		return rsMap;
	}

	@Override
	public List<Map<String, Object>> getTotalDataByHour(Map<String, Object> req) {
		return queryByCKMapper.getTotalDataByHour(req);
	}
	
	@Override
	public List<Map<String, Object>> getDataByChannelId(Map<String, Object> req) {
		return queryByCKMapper.getDataByChannelId(req);
	}

	@Override
	public List<Map<String, Object>> getDataByDeviceType(Map<String, Object> req) {
		return queryByCKMapper.getDataByDeviceType(req);
	}

	@Override
	public List<Map<String, Object>> getDataByPayWay(Map<String, Object> req) {
		return queryByCKMapper.getDataByPayWay(req);
	}
	
	@Override
	public List<Map<String, Object>> getDataByRegion(Map<String, Object> req) {
		return queryByCKMapper.getDataByRegion(req);
	}
	
	@Override
	public List<Map<String, Object>> getBuyRate(Map<String, Object> req) {
		return queryByCKMapper.getBuyRate(req);
	}

	@Override
	public List<Map<String, Object>> getMultiActivity(Map<String, Object> req) {
		return queryByCKMapper.getMultiActivity(req);
	}

	@Override
	public List<Map<String, Object>> getMultiTotalData(Map<String, Object> req) {
		return queryByCKMapper.getMultiTotalData(req);
	}

	@Override
	public List<Map<String, Object>> getMultiProductData(Map<String, Object> req) {
		return queryByCKMapper.getMultiProductData(req);
	}

	@Override
	public List<Map<String, Object>> getMultiProductDataByProductId(Map<String, Object> req) {
		return queryByCKMapper.getMultiProductDataByProductId(req);
	}

	@Override
	public List<Map<String, Object>> getMultiAgentData(Map<String, Object> req) {
		return queryByCKMapper.getMultiAgentData(req);
	}

	@Override
	public List<Map<String, Object>> getMultiAgentRegionData(Map<String, Object> req) {
		return queryByCKMapper.getMultiAgentRegionData(req);
	}

	@Override
	public List<Map<String, Object>> getMultiAgentSaleData(Map<String, Object> req) {
		return queryByCKMapper.getMultiAgentSaleData(req);
	}

	@Override
	public List<Map<String, Object>> getMultiAgentFromData(Map<String, Object> req) {
		return queryByCKMapper.getMultiAgentFromData(req);
	}

	@Override
	public List<Map<String, Object>> getMultiAgentClientData(Map<String, Object> req) {
		return queryByCKMapper.getMultiAgentClientData(req);
	}

}
