package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Receipt;

import java.sql.SQLException;
import java.util.List;

/**
 *收银小票DAO
 */
public interface ReceiptDAO {
    /**
     * 新增收银小票，返回自增主键
     * @param receipt
     * @return
     * @throws SQLException
     */
    Long insertReceipt(Receipt receipt) throws SQLException;

    /**
     * 通过小票号码查询明细
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getReceiptById(long id) throws SQLException;

    /**
     * 获取收银小票
     * @return
     * @throws SQLException
     */
    List<Entity> getAllReceipt() throws  SQLException;

}
