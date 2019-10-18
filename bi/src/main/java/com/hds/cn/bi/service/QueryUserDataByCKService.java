package com.hds.cn.bi.service;

import java.util.List;
import java.util.Map;

public interface QueryUserDataByCKService {
    public Map<String, Object> getTotalData(Map<String, Object> req);
    public List<Map<String, Object>> getRegistFrom(Map<String, Object> req);
    public Map<String, Object> getRegistChannel(Map<String, Object> req);
    public Map<String, Object> getRegistRegion(Map<String, Object> req);
    public Map<String, Object> getPayFrom(Map<String, Object> req);
    public Map<String, Object> getClientFrom(Map<String, Object> req);
    public Map<String, Object> getConsumeCnt(Map<String, Object> req);
    public Map<String, Object> getConsumeAmount(Map<String, Object> req);
    public Map<String, Object> getLogonCnt(Map<String, Object> req);
    public Map<String, Object> getGenderCnt(Map<String, Object> req);
    public Map<String, Object> getAgeCnt(Map<String, Object> req);

}
