package com.hds.hdyapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.hds.hdyapp.service.QueryByCKService;
import com.hds.hdyapp.util.BaseController;
import com.hds.hdyapp.util.RequestUtil;
import com.hds.hdyapp.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("hdyapp/queryByCK")
public class QueryByCKController extends BaseController{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private String mseg = "";
	@Autowired
	private QueryByCKService queryByCKService;
	
	//TODO 整合了getTotalData，getUserDataByDate，getProductData这三个接口
	@ResponseBody
	@RequestMapping(value = "getTotalData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<Map<String, Object>> getTotalData(@RequestBody String info) {
		logger.info("parameters:" + info);
		Map<String, Object> rsMap = new HashMap<String, Object>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getTotalData(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getProductData", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<Map<String, Object>> getProductData(@RequestBody String info) {
		logger.info("parameters:" + info);
		Map<String, Object> rsMap = new HashMap<String, Object>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getTotalData(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserDataByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<Map<String, Object>> getUserDataByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		Map<String, Object> rsMap = new HashMap<String, Object>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getTotalData(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getTotalDataByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getTotalDataByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getTotalDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getDataSourceByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getDataSourceByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getChannelDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getDataSourceByProductId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getDataSourceByProductId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getChannelDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	//TODO 整合getRegionDistributionByDate，getUserDistributionByDate，getRegionDistributionByProductId
	@ResponseBody
	@RequestMapping(value = "getRegionDistributionByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getRegionDistributionByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getRegionDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getRegionDistributionByProductId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getRegionDistributionByProductId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getRegionDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserDistributionByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getUserDistributionByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getRegionDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	//TODO 整合getClientDataByDate，getClientDataByProductId
	@ResponseBody
	@RequestMapping(value = "getClientDataByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getClientDataByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDeviceDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getClientDataByProductId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getClientDataByProductId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDeviceDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserPayWayByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getUserPayWayByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getPayWayDataByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getBestSellingByDate", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getBestSellingByDate(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getBestSellingByDay(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getSourceDataByChannelId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getSourceDataByChannelId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByChannelId(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getRegionDateByRegionId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getRegionDateByRegionId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByRegionId(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
	
	@ResponseBody
	@RequestMapping(value = "getClientDataByClientId", method = {RequestMethod.POST, RequestMethod.GET})
	public ResponseUtil<List<Map<String, Object>>> getClientDataByClientId(@RequestBody String info) {
		logger.info("parameters:" + info);
		List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
			rsMap = queryByCKService.getDataByDeviceType(requestMap);
			mseg = "success";
			requestMap = null;
			logger.info("result：" + rsMap);
		} catch (Exception e) {
			logger.error(e.toString());
			mseg = "请求失败!!!";
			return error(mseg);
		}
		return success(mseg, rsMap);
	}
}
