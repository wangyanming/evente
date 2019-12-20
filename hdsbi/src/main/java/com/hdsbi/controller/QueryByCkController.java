package com.hdsbi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdsbi.util.BaseController;
import com.alibaba.fastjson.JSONObject;
import com.hdsbi.service.QueryByCkService;
import com.hdsbi.util.ConvertParamsUtil;
import com.hdsbi.util.DateUtils;
import com.hdsbi.util.QueryConstant;
import com.hdsbi.util.RedisUtils;
import com.hdsbi.util.ResponseUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author admin
 */
@RestController
@RequestMapping("queryByCK")
public class QueryByCkController extends BaseController {
	
	private final Logger logger = LoggerFactory.getLogger(QueryByCkController.class);
	
	private String mseg = "";
	
	private boolean hasKey = false;
	
	private final String today = DateUtils.dateStampToDay(System.currentTimeMillis());
	
	@Autowired
	private QueryByCkService queryByCkService;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@ResponseBody
	@RequestMapping(value = "overview", method = RequestMethod.POST)
	@HystrixCommand
	public ResponseUtil<List<Map<String, Object>>> overview(@RequestBody String req, HttpServletRequest request) {
		logger.info("params：" + req);
		
		if (req == null) {
			mseg = QueryConstant.FAILMSEG;
			logger.error(mseg);
			return error(mseg);
		}
		
		List<Map<String, Object>> resultList = null;
		
		try {
			Map<String, Object> params = JSONObject.parseObject(req, Map.class);
			resultList = queryByCkService.overview(params);
			
			logger.info("result：" + resultList);
		} catch (Exception e) {
			handleException(request, e);
			mseg = QueryConstant.FAILMSEG;
			logger.error(e.toString());
			return error(mseg);
		}
		mseg = QueryConstant.SUCCESSMSEG;
		return success(mseg, resultList);
	}
	
	@ResponseBody
	@RequestMapping(value = "eventAnalysis", method = RequestMethod.POST)
	@HystrixCommand
	public ResponseUtil<Map<Object, List>> eventAnalysis(@RequestBody String req, HttpServletRequest request) {
		logger.info("params：" + req);
		
		if (req == null) {
			mseg = QueryConstant.FAILMSEG;
			logger.error(mseg);
			return error(mseg);
		}
		
		LinkedHashMap<String, Object> paramsMap = new LinkedHashMap<String, Object>();
		Map<Object, List> map = new HashMap<Object, List>();
		String redisKey = String.valueOf(Objects.hash(req));
		hasKey = redisUtils.hasKey(redisKey);
		if (hasKey) {
			map =  (Map<Object, List>)redisUtils.getValues(redisKey);
			logger.info("redisCache：" + map);
			mseg = QueryConstant.SUCCESSMSEG;
			return success(mseg, map);
		}
		
		try {
			Map<String, Object> params = ConvertParamsUtil.requestParams(paramsMap, req);
			
			if ("minute".equals(params.get("unit")) && !params.get("startDate").equals(params.get("endDate"))) {
				mseg = QueryConstant.FAILMSEG;
				return error(mseg);
			}
			map = queryByCkService.eventAnalysis(params);
			
			if (null != params.get("endDate") && !(params.get("endDate").toString().equals(today))) {
				logger.info("redisKey：" + redisKey + "，writeToRedis：" + map + "，today：" + today);
				redisUtils.writeToRedis(redisKey, map);
			}
			
			logger.info("result：" + map);
		} catch (Exception e) {
			handleException(request, e);
			mseg = QueryConstant.FAILMSEG;
			logger.error(e.toString());
			return error(mseg);
		}
		mseg = QueryConstant.SUCCESSMSEG;
		return success(mseg, map);
	}
	
	@ResponseBody
	@RequestMapping(value = "distributeAnalysis", method = RequestMethod.POST)
	@HystrixCommand
	public ResponseUtil<List<Map<String, Object>>> distributeAnalysis(@RequestBody String req, HttpServletRequest request) {
		logger.info("params：" + req);
		
		if (req == null) {
			mseg = QueryConstant.FAILMSEG;
			logger.error(mseg);
			return error(mseg);
		}
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		LinkedHashMap<String, Object> paramsMap = new LinkedHashMap<String, Object>();
		String redisKey = String.valueOf(Objects.hash(req));
		hasKey = redisUtils.hasKey(redisKey);
		if (hasKey) {
			resultList =  (List<Map<String, Object>>)redisUtils.getValues(redisKey);
			logger.info("redisCache：" + resultList);
			mseg = QueryConstant.SUCCESSMSEG;
			return success(mseg, resultList);
		}
		
		try {
			Map<String, Object> params = ConvertParamsUtil.requestParams(paramsMap, req);
			resultList = queryByCkService.distributeAnalysis(params);
			
			if (null != params.get("endDate") && !(params.get("endDate").toString().equals(today))) {
				logger.info("redisKey：" + redisKey + "，writeToRedis：" + resultList + "，today：" + today);
				redisUtils.writeToRedis(redisKey, resultList);
			}
			
			logger.info("result：" + resultList);
		} catch (Exception e) {
			handleException(request, e);
			mseg = QueryConstant.FAILMSEG;
			logger.error(e.toString());
			return error(mseg);
		}
		
		mseg = QueryConstant.SUCCESSMSEG;
		return success(mseg, resultList);
	}
}
