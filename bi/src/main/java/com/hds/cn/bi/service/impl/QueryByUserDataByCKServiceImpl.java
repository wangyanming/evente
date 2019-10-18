package com.hds.cn.bi.service.impl;

import com.hds.cn.bi.mapper.QueryUserDataByCKMapper;
import com.hds.cn.bi.service.QueryUserDataByCKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryByUserDataByCKServiceImpl implements QueryUserDataByCKService {

    @Autowired
    private QueryUserDataByCKMapper queryUserDataByCKMapper;

    @Override
    public Map<String, Object> getTotalData(Map<String, Object> req) {
        return queryUserDataByCKMapper.getTotalData(req);
    }

    @Override
    public List<Map<String, Object>> getRegistFrom(Map<String, Object> req) {
        return queryUserDataByCKMapper.getRegistFrom(req);
    }

    @Override
    public Map<String, Object> getRegistChannel(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getRegistChannel(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("channel_id").toString(), m.get("registCnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getRegistRegion(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getRegistRegion(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("region").toString(), m.get("registCnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getPayFrom(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getPayFrom(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("pay_way").toString(), m.get("registCnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getClientFrom(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getClientFrom(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("device_type").toString(), m.get("registCnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getConsumeCnt(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getConsumeCnt(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("type").toString(), m.get("cnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getConsumeAmount(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getConsumeAmount(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("type").toString(), m.get("cnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getLogonCnt(Map<String, Object> req) {
        return queryUserDataByCKMapper.getLogonCnt(req);
    }

    @Override
    public Map<String, Object> getGenderCnt(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getGenderCnt(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("sex").toString(), m.get("registCnt"));
        }
        return map;
    }

    @Override
    public Map<String, Object> getAgeCnt(Map<String, Object> req) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> maps = queryUserDataByCKMapper.getAgeCnt(req);
        for (Map<String, Object> m : maps) {
            map.put(m.get("type").toString(), m.get("cnt"));
        }
        return map;
    }
}
