package com.soft1841.sm.dao;


import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class GoodsDAOTest {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();

    @Test
    public void insertGoods() {
    }

    @Test
    public void deleteGoods() {
    }

    @Test
    public void selectAllGoods() throws SQLException {
        List<Entity> goodList = goodsDAO.selectAllGoods();
        goodList.forEach(entity -> System.out.println(entity.getStr("goods_name")));
    }

    @Test
    public void getGoodsByTypeId() throws SQLException {
        Entity entity = goodsDAO.getGoodsByTypeId(1);
        System.out.println(entity);
    }

    @Test
    public void selectGoodsLike() {
    }

    @Test
    public void updateGoods() {
    }
}