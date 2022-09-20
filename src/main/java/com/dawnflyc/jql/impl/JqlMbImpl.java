package com.dawnflyc.jql.impl;

import com.dawnflyc.jqlapi.sql.IJqlImpl;
import com.dawnflyc.jqlapi.sql.IPreParamManageFactory;
import com.dawnflyc.jqlapi.sql.ISqlHandle;
import com.dawnflyc.jqlmb.DbMapper;
import com.dawnflyc.jqlmb.DbMapperProxy;
import com.dawnflyc.jqlmb.PreParamManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * jql实现，提供sql处理器和预编译管理器
 */
@Component
public class JqlMbImpl implements IJqlImpl {

    private static ISqlHandle handle;

    @Override
    public ISqlHandle getSqlHandle() {
        return handle;
    }

    @Override
    public IPreParamManageFactory getPreParamManageFactory() {
        return PreParamManage::new;
    }

    @Autowired
    public void setHandle(DbMapper mapper) {
        JqlMbImpl.handle = new DbMapperProxy(mapper);
    }
}
