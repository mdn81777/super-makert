package com.soft1841.sm.service;

import com.soft1841.sm.entity.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * 新增商品，返回自增主键
     * @param goods
     * @return
     */
    Long addGoods(Goods goods);

    /**
     * 根据条形码删除商品
     * @param barcode
     */
    void deleteGoods(long barcode);

    /**
     * 更新商品信息
     * @param goods
     */
    void updateGoods(Goods goods);

    /**
     * 查询所有商品
     * @return
     */
    List<Goods> getAllGoods();

    /**
     * 根据typeId查询商品
     * @param typeId
     * @return
     */
    Goods getGoods(long typeId);

    /**
     * 根据商品名称关键词模糊查询商品
     * @param keywords
     * @return
     */
    List<Goods> getGoodsLike(String keywords);
}
