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
    public void insertGoods() {
        Goods goods = new Goods();
        goods.setTypeId(6);
        goods.setName("果干");
        goods.setPrice(54.0);
        goods.setCover("https://img.alicdn.com/imgextra/i1/35184104/O1CN011gBfvYh83QhGJy6_!!0-saturn_solar.jpg_220x220.jpg_.webp");
        goods.setDescription("test");
        goods.setBarcode("123457000100");
        goods.setStock(666);
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