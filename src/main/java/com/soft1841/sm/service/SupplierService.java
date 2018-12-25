package com.soft1841.sm.service;

import com.soft1841.sm.entity.Supplier;

import java.util.List;

/**
 * 供应商的业务逻辑接口
 * @author 孟妮
 */
public interface SupplierService {
    /**
     * 新增供应商，返回自增主键
     * @param supplier
     * @return
     */
    Long addSuppler(Supplier supplier);


    /**
     * 删除供应商
     * @param id
     */
    void deleteSupplier(long id);

    /**
     * 更新供应商信息
     * @param supplier
     */
    void  updateSupplier(Supplier supplier);

    /**
     * 根据id查询供应商信息
     * @param
     * @return
     */
    List<Supplier> getAllSuplier();








}
