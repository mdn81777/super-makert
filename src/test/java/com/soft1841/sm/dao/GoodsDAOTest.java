package com.soft1841.sm.dao;


import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class GoodsDAOTest {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();

    @Test
    public void insertGoods() throws SQLException {
        Goods goods = new Goods();
        goods.setTypeId(1);
        goods.setName("");
        goods.setPrice(20);
        goods.setCover("");
        goods.setDescription("");
        goods.setBarcode("");
        goods.setStock(123);
        System.out.println(goodsDAO.insertGoods(goods));
    }

    @Test
    public void deleteGoods() throws SQLException {
    goodsDAO.deleteGoodsByBarcode(888889000);
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
    public void selectGoodsLike() throws SQLException{
        List<Entity> goodsList = goodsDAO.selectGoodsLike("");
        goodsList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void updateGoods() throws SQLException{
    Goods goods = new Goods();
    goods.setBarcode("");
    goods.setName("");
    goods.setStock(12);
    goodsDAO.updateGoods(goods);
}
}