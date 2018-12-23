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
     * @param typeId
     * @return
     * @throws SQLException
     */
    int deleteGoods(Long typeId) throws SQLException;

    /**
     * 查询所有商品
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllGoods() throws SQLException;

    /**
     * 更改商品信息
     * @param typeId
     * @return
     * @throws SQLException
     */
    int updateGoods(Long typeId) throws SQLException;
}
