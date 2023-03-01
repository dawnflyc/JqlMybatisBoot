package com.dawnflyc.jqlmb;

import com.dawnflyc.jqlapi.sql.ISqlHandle;
import com.dawnflyc.jqlmb.DbMapper;

import java.util.List;
import java.util.Map;

/**
 * Mapper 代理类
 */

public class DbMapperProxy implements ISqlHandle {

    /**
     * 被代理类
     */
    private final DbMapper dbMapper;

    public DbMapperProxy(DbMapper dbMapper) {
        this.dbMapper = dbMapper;
    }

    @Override
    public List<Map<String, Object>> select(String sql, Map<String, Object> params) {
        return dbMapper.select(sql, params);
    }

    /**
     * 返回插入的id
     */
    @Override
    public Object insert(String sql, Map<String, Object> params) {
        Object ido = new Object() {
            public Object  id;
        };
        dbMapper.insert(sql, params, ido);
        try {
            return  ido.getClass().getField("id").get(ido);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(String sql, Map<String, Object> params) {
        return dbMapper.update(sql, params);
    }

    @Override
    public int delete(String sql, Map<String, Object> params) {
        return dbMapper.delete(sql, params);
    }
}
