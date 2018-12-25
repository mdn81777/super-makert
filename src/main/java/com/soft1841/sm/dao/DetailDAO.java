package com.soft1841.sm.dao;
/**
 *
 * @author 孟妮
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Detail;

import java.sql.SQLException;
import java.util.List;

public interface DetailDAO {
    /**
     * 新增收银明细，返回自增主键
     * @param detail
     * @return
     * @throws SQLException
     */
    Long insertDetail(Detail detail) throws SQLException;

    /**
     * 通过小票号码查询明细
     * @param receiptId
     * @return
     * @throws SQLException
     */
    Entity getDetailByReceiptId(long receiptId) throws SQLException;

    /**
     * 获取所有明细
     * @return
     * @throws SQLException
     */
    List<Entity> getAllDetail() throws  SQLException;

}
