package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import cn.hutool.db.SqlConnRunner;
import com.soft1841.sm.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDAO {
    /**
     * 查询所有供应商信息
     * @return
     * @throws SecurityException
     */
    List<Entity> selectSuppler() throws  SecurityException;

    /**
     * 新增供应商，返回自增主键
     * @param supplier
     * @return
     * @throws SQLException
     */
    Long insetSupplier(Supplier supplier)throws SQLException;

    /**
     * 根据id删除供应商实体
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteSupplierById(long id) throws  SQLException;

    /**
     * 更新供货商信息
     * @param supplier
     * @return
     * @throws SQLException
     */
    int Supplier(Supplier supplier) throws SQLException;
}
