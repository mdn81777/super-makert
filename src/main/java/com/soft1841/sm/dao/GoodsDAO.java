package com.soft1841.sm.dao;
/**
 * 商品接口
 * @author蔡一帆
 */

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
     * @param barcode
     * @return
     * @throws SQLException
     */
    int deleteGoodsByBarcode(long barcode) throws SQLException;

    /**
     * 查询所有商品
     * @return
     * @throws SQLException
     */
    List<Goods> selectAllGoods() throws SQLException;

    /**
     * 根据商品类型查询
     * @param typeId
     * @return
     * @throws SQLException
     */
    Goods getGoodsByTypeId(long typeId) throws SQLException;

    /**
     * 根据关键词查询
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Goods> selectGoodsLike(String keywords) throws SQLException;
    /**
     * 更改商品信息
     * @param goods
     * @return
     * @throws SQLException
     */
    int updateGoods(Goods goods) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    List<Goods> selectGoodsByTypeId(long id) throws SQLException;

    /**
     * 通过ID查询单件商品
     * @param id
     * @return
     */
    Goods getGoodsByID(long id) throws SQLException;


    int countByType(long typeId) throws SQLException;

}
