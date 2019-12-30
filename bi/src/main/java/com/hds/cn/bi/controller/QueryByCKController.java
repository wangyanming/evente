package com.hds.cn.bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hds.cn.bi.service.QueryByCKService;
import com.hds.cn.bi.util.BaseController;
import com.hds.cn.bi.util.RequestUtil;
import com.hds.cn.bi.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("queryByCK")
public class QueryByCKController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String mseg = "";
	@Autowired
	private QueryByCKService queryByCKService;
	
	@ResponseBody
	@RequestMapping(value = "getTotalbyDay", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<Map<String, Object>> getTotalbyDay(@RequestBody String info) {
		logger.info("parameters:" + info);
		Map<String, Object> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getTotalDataByDay(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getTotalbyHour", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getTotalbyHour(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getTotalDataByHour(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	//TODO 等埋点
	@ResponseBody
	@RequestMapping(value = "getVisitorFrom", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getVisitorFrom(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByChannelId(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	//TODO 等埋点
	@ResponseBody
	@RequestMapping(value = "getClientFrom", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getClientFrom(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByDeviceType(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getPayFrom", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getPayFrom(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByPayWay(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getRegionDistribution", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getRegionDistribution(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByRegion(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getBuyRate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getBuyRate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getBuyRate(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiActivity", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiActivity(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiActivity(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiTotalData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<Map<String, Object>> getMultiTotalData(@RequestBody String info) {
		logger.info("parameters:" + info);
		Map<String, Object> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiTotalData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiProductData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiProductData(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiProductData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiProductDataByProductId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiProductDataByProductId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiProductDataByProductId(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiAgentData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiAgentData(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiAgentData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiAgentRegionData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiAgentRegionData(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiAgentRegionData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiAgentSaleData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiAgentSaleData(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiAgentSaleData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiAgentFromData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiAgentFromData(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap;
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiAgentFromData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getMultiAgentClientData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getMultiAgentClientData(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getMultiAgentClientData(requestMap);
			mseg = "success";
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
}
