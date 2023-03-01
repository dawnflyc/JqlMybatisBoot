package com.dawnflyc.jqlmb;

import com.dawnflyc.jqlapi.sql.IPreParamManage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 预参数管理器
 */
public class PreParamManage implements IPreParamManage {


    /**
     * 预编码参数
     */
    private final Map<PreParamGenerator.PreParam, Object> params = new HashMap<>();

    /**
     * 分配参数
     */
    public String allocPreParam(Object value) {
        PreParamGenerator.PreParam preParam = PreParamGenerator.alloc();
        this.params.put(preParam, value);
        return "#{params." + preParam.toString() + "}";
    }

    @Override
    public Map<String, Object> toParams() {
        Map<String, Object> params = new HashMap<>();
        for (Map.Entry<PreParamGenerator.PreParam, Object> entry : this.params.entrySet()) {
            params.put(entry.getKey().toString(), entry.getValue());
        }
        return params;
    }

    @Override
    public void done() {
        List<PreParamGenerator.PreParam> destroy = new ArrayList<>();
        for (PreParamGenerator.PreParam preParam : params.keySet()) {
            preParam.close();
            destroy.add(preParam);
        }
        for (PreParamGenerator.PreParam preParam : destroy) {
            params.remove(preParam);
        }
    }

}
