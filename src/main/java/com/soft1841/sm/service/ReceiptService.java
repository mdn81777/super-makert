package com.soft1841.sm.service;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Receipt;

import java.util.List;

/**
 * 收银小票的业务逻辑接口
 * @author 孟妮
 */

public interface ReceiptService {
    /**
     * 获取所有收银小票信息
     * @return
     */
    List<Entity> getAllReceipt() ;

    /**
     * 通过小票号码查询明细
     * @param id
     * @return
     */
    Entity getReceiptById(long id);

    /**
     * 新增收银小票
     * @param receipt
     * @return
     */
    Long addReceipt(Receipt receipt);
}
