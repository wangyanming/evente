package com.hds.hdyapp.service.impl;

import java.util.*;
import java.util.Map.Entry;

import com.hds.hdyapp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.hdyapp.mapper.QueryByCKMapper;
import com.hds.hdyapp.service.QueryByCKService;

@Service
public class QueryByCKServiceImpl implements QueryByCKService{

	@Autowired
	private QueryByCKMapper queryByCKMapper;
	
	@Override
	public Map<String, Object> getTotalData(Map<String, Object> req) {
		List<Map<String, Object>> resultList = queryByCKMapper.getTotalData(req);
		Map<String, Object> rsMap = new HashMap<String, Object>();
		for (Map<String, Object> map : resultList) {
			for (Entry<String, Object> map1 : map.entrySet()) {
				rsMap.put(map1.getKey(), map1.getValue());
			}
		}
		return rsMap;
	}

	@Override
	public List<Map<String, Object>> getTotalDataByDay(Map<String, Object> req) {
		Calendar cal = null;
		String searchType = req.get("searchType").toString();
		String startDate = req.get("startDate").toString();
		String endDate = req.get("endDate").toString();
		switch (searchType) {
			case "week":
				startDate = DateUtil.startWeek(startDate);
				endDate = DateUtil.endWeek(endDate);
				req.put("startDate", startDate);
				req.put("endDate", endDate);
				return queryByCKMapper.getTotalDataByDay(req);
			case "month":
				startDate = DateUtil.startMonth(startDate);
				endDate = DateUtil.endMonth(endDate);
				req.put("startDate", startDate);
				req.put("endDate", endDate);
				return queryByCKMapper.getTotalDataByDay(req);
			case "year":
				startDate = DateUtil.startYear(startDate);
				endDate = DateUtil.endYear(endDate);
				req.put("startDate", startDate);
				req.put("endDate", endDate);
				return queryByCKMapper.getTotalDataByDay(req);
			default:
				return queryByCKMapper.getTotalDataByDay(req);
		}
	}

	@Override
	public List<Map<String, Object>> getBestSellingByDay(Map<String, Object> req) {
		return queryByCKMapper.getBestSellingByDay(req);
	}

	@Override
	public List<Map<String, Object>> getChannelDataByDay(Map<String, Object> req) {
		return queryByCKMapper.getChannelDataByDay(req);
	}

	@Override
	public List<Map<String, Object>> getRegionDataByDay(Map<String, Object> req) {
		return queryByCKMapper.getRegionDataByDay(req);
	}

	@Override
	public List<Map<String, Object>> getDeviceDataByDay(Map<String, Object> req) {
		return queryByCKMapper.getDeviceDataByDay(req);
	}

	@Override
	public List<Map<String, Object>> getPayWayDataByDay(Map<String, Object> req) {
		return queryByCKMapper.getPayWayDataByDay(req);
	}

	@Override
	public List<Map<String, Object>> getDataByChannelId(Map<String, Object> req) {
		return queryByCKMapper.getDataByChannelId(req);
	}

	@Override
	public List<Map<String, Object>> getDataByRegionId(Map<String, Object> req) {
		return queryByCKMapper.getDataByRegionId(req);
	}

	@Override
	public List<Map<String, Object>> getDataByDeviceType(Map<String, Object> req) {
		return queryByCKMapper.getDataByDeviceType(req);
	}

}
