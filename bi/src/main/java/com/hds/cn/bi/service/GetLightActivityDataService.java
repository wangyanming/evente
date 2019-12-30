package com.hds.cn.bi.service;

import java.util.List;
import java.util.Map;

import com.hds.cn.bi.vo.AgentDataVo;
import com.hds.cn.bi.vo.AgentVo;
import com.hds.cn.bi.vo.MultiActivityVo;
import com.hds.cn.bi.vo.ProductDataVo;

public interface GetLightActivityDataService {

    List<MultiActivityVo> getMultiActivity(Map<String, Object> requestMap);

    Map<String, Object> getTotalData(Map<String, Object> requestMap);

    List<AgentVo> getAgentData(Map<String, Object> requestMap);

    List<AgentDataVo> getAgentRegionData(Map<String, Object> requestMap);

    List<AgentDataVo> getAgentSaleData(Map<String, Object> requestMap);

    List<AgentDataVo> getAgentFromData(Map<String, Object> requestMap);

    List<AgentDataVo> getAgentClientData(Map<String, Object> requestMap);

    List<ProductDataVo> getProductData(Map<String, Object> requestMap);

    List<MultiActivityVo> getProductDateByProductId(Map<String, Object> requestMap);
}