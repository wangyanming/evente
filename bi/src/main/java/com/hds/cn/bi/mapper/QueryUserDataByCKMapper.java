package com.hds.cn.bi.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QueryUserDataByCKMapper {
    public Map<String, Object> getTotalData(Map<String, Object> req);
    public List<Map<String, Object>> getRegistFrom(Map<String, Object> req);
    public List<Map<String, Object>> getRegistChannel(Map<String, Object> req);
    public List<Map<String, Object>> getRegistRegion(Map<String, Object> req);
    public List<Map<String, Object>> getPayFrom(Map<String, Object> req);
    public List<Map<String, Object>> getClientFrom(Map<String, Object> req);
    public List<Map<String, Object>> getConsumeCnt(Map<String, Object> req);
    public List<Map<String, Object>> getConsumeAmount(Map<String, Object> req);
    public Map<String, Object> getLogonCnt(Map<String, Object> req);
    public List<Map<String, Object>> getGenderCnt(Map<String, Object> req);
    public List<Map<String, Object>> getAgeCnt(Map<String, Object> req);
}
