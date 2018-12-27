package com.soft1841.sm.dao;
/**
 * 供应商类
 * @author 孟妮
 */

import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Supplier;

import java.sql.SQLException;
import java.util.List;


public interface SupplierDAO {


    /**
     * 新增供应商，返回自增主键
     * @param
     * @return
     * @throws SQLException
     */
    Long insertSupplier(Supplier supplier)throws SQLException;
    /**
     * 查询所有供应商信息
     * @return
     * @throws SecurityException
     */


    List<Supplier> selectAllSupplier() throws SQLException;

    /**
     * 根据id删除供应商实体
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteSupplierById(long id) throws  SQLException;

    /**
     * 查询供货商信息
     * @param
     * @return
     * @throws SQLException
     */
    Supplier getSupplierByID(long id) throws SQLException;

    int countByType(long typeId) throws SQLException;

    int updateSupplier(Supplier supplier) throws SQLException;
}
