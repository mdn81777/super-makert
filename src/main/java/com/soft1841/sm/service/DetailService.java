package com.soft1841.sm.service;

import com.soft1841.sm.entity.Detail;

import java.util.List;

/**
 * 收银明细的业务逻辑接口
 * @author 孟妮
 */

public interface DetailService {
    /**
     * 获取所有收银明细的功能
     * @return
     */
    List<Detail> getAllDetail();
    /**
     * 新增收银明细，返回自增主键
     * @param detail
     * @return
     */
    Long addDetail(Detail detail);

    /**
     * 根据小票号码查询明细信息
     * @param receiptId
     * @return Book
     */
    List<Detail> getDetail(long receiptId);

}