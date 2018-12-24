package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDAO {
    /**
     * 新增商品
     * @param goods
     * @return
     * @throws SQLException
     */
    Long insertGoods(Goods goods) throws SQLException;

    /**
     * 删除商品
     * @param name
     * @return
     * @throws SQLException
     */
    int deleteGoods(String name) throws SQLException;

    /**
     * 查询所有商品
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllGoods() throws SQLException;

    /**
     * 根据商品类型查询
     * @param typeId
     * @return
     * @throws SQLException
     */
    Entity getGoodsByTypeId(int typeId) throws SQLException;

    /**
     * 根据关键词查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Entity> selectGoodsLike(String keywords) throws SQLException;
    /**
     * 更改商品信息
     * @param goods
     * @return
     * @throws SQLException
     */
    int updateGoods(Goods goods) throws SQLException;

}
