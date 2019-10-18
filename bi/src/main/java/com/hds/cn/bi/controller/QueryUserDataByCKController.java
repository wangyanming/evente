package com.hds.cn.bi.controller;

import com.hds.cn.bi.service.QueryUserDataByCKService;
import com.hds.cn.bi.util.BaseController;
import com.hds.cn.bi.util.RequestUtil;
import com.hds.cn.bi.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("queryUserDataByCk")
public class QueryUserDataByCKController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String mseg = "";

    @Autowired
    private QueryUserDataByCKService queryUserDataByCKService;

    @ResponseBody
    @RequestMapping(value = "getTotalData", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getTotalData(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getTotalData(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getRegistFrom", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<List<Map<String, Object>>> getRegistFrom(@RequestBody String info) {
        logger.info("parameters:" + info);
        List<Map<String, Object>> rsMap = new ArrayList<Map<String, Object>>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getRegistFrom(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getRegistChannel", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getRegistChannel(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getRegistChannel(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getRegistRegion", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getRegistRegion(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getRegistRegion(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getPayFrom", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getPayFrom(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getPayFrom(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getClientFrom", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getClientFrom(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getClientFrom(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getConsumeCnt", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getConsumeCnt(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getConsumeCnt(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getConsumeAmount", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getConsumeAmount(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getConsumeAmount(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getLogonCnt", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getLogonCnt(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getLogonCnt(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getGenderCnt", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getGenderCnt(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getGenderCnt(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }

    @ResponseBody
    @RequestMapping(value = "getAgeCnt", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseUtil<Map<String, Object>> getAgeCnt(@RequestBody String info) {
        logger.info("parameters:" + info);
        Map<String, Object> rsMap = new HashMap<String, Object>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(info);
            Map<String, Object> requestMap = RequestUtil.ckResUtil(jsonObject);
            rsMap = queryUserDataByCKService.getAgeCnt(requestMap);
            mseg = "success";
            requestMap = null;
        } catch (Exception e) {
            logger.error(e.toString());
            mseg = "请求失败!!!";
            return error(mseg);
        }
        return success(mseg, rsMap);
    }
}
