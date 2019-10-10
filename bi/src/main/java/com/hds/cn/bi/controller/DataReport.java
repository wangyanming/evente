package com.hds.cn.bi.controller;

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

import com.hds.cn.bi.service.DataReportService;
import com.hds.cn.bi.util.BaseController;
import com.hds.cn.bi.util.RequestUtil;
import com.hds.cn.bi.util.ResponseUtil;
import com.hds.cn.bi.vo.LogonOrgVo;
import com.hds.cn.bi.vo.NewOrgVo;
import com.hds.cn.bi.vo.TotalOrgVo;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("report")
public class DataReport extends BaseController{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private String mseg = "";
	@Autowired
	private DataReportService dataReprotService;
	
	@ResponseBody
	@RequestMapping(value = "getTotalData", method = RequestMethod.POST)
	public ResponseUtil<List<TotalOrgVo>> getTotalData(@RequestBody String info) {
		List<TotalOrgVo> totalList = new ArrayList<TotalOrgVo>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.requestUtil(jsonObject);
			totalList = dataReprotService.getTotalData(requestMap);
			logger.info("requestMap:" + info.toString() + ";" + "\r\n" + "getTotalData" + ":" + totalList);
			mseg = "success";
			requestMap = null;
		} catch (Exception e) {
			logger.error("totalList:" + info + ";" + "totalList" + ":" + e.toString());
			mseg = e.toString();
			return error(mseg);
		}
		return success(mseg, totalList);
	}
	
	@ResponseBody
	@RequestMapping(value = "getNewOrgData", method = RequestMethod.POST)
	public ResponseUtil<List<NewOrgVo>> getNewOrgData(@RequestBody String info) {
		List<NewOrgVo> totalList = new ArrayList<NewOrgVo>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.requesHourtUtil(jsonObject);
			totalList = dataReprotService.getNewOrgData(requestMap);
			logger.info("requestMap:" + info.toString() + ";" + "\r\n" + "getNewOrgData" + ":" + totalList.toString());
			logger.info("getNewOrgData" + ":" + totalList.toString());
			mseg = "success";
		} catch (Exception e) {
			logger.error("getNewOrgData" + ":" + e.toString());
			mseg = e.toString();
			return error(mseg);
		}
		return success(mseg, totalList);
	}
	
	@ResponseBody
	@RequestMapping(value = "getLogonOrgData", method = RequestMethod.POST)
	public ResponseUtil<List<LogonOrgVo>> getLogonOrgData(@RequestBody String info) {
		List<LogonOrgVo> totalList = new ArrayList<LogonOrgVo>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.requesHourtUtil(jsonObject);
			totalList = dataReprotService.getLogonOrgData(requestMap);
			logger.info("requestMap:" + info.toString() + ";" + "\r\n" + "getLogonOrgData" + ":" + totalList.toString());
			logger.info("getLogonOrgData" + ":" + totalList.toString());
			mseg = "success";
		} catch (Exception e) {
			logger.error("getLogonOrgData" + ":" + e.toString());
			mseg = e.toString();
			return error(mseg);
		}
		return success(mseg, totalList);
	}
	
	@ResponseBody
	@RequestMapping(value = "getOrgRankData", method = RequestMethod.POST)
	public ResponseUtil<Map<String, Object>> getOrgRankData(@RequestBody String info) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			JSONObject jsonObject = JSONObject.fromObject(info);
			Map<String, Object> requestMap = RequestUtil.requesHourtUtil(jsonObject);
			resultMap = dataReprotService.getOrgRankData(requestMap);
			logger.info("requestMap:" + info.toString() + ";" + "\r\n" + "getOrgRankData" + ":" + resultMap.toString());
			logger.info("getOrgRankData" + ":" + resultMap.toString());
			mseg = "success";
		} catch (Exception e) {
			logger.error("getOrgRankData" + ":" + e.toString());
			mseg = e.toString();
			return error(mseg);
		}
		return success(mseg, resultMap);
	}
	
	/*public static void main(String[] args) {
		BulkRequestBuilder bulkRequest = EsClient.getConnect().prepareBulk();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		
		jsonMap.put("sign_time", "2018-01-23 14:11:00");
		jsonMap.put("org_id", 100035);
		jsonMap.put("user_id", "1234567");
		jsonMap.put("user_sex", 0);//性别
		jsonMap.put("user_birth", "19900101");//出生日期
		jsonMap.put("channel_id", "baidu");
		jsonMap.put("province_id", 110000);
		jsonMap.put("city_id", 110000);
		jsonMap.put("agent_type", 4);
		
		bulkRequest.add(EsClient.getConnect().prepareIndex("regist", "signup")
				.setSource(jsonMap));
		
		BulkResponse bulkResponse = bulkRequest.execute().actionGet();
		if(bulkResponse.hasFailures()) {
			System.out.println("插入失败！！！");
		} else {
			System.out.println("插入成功！！！");
		}
	}*/
}
