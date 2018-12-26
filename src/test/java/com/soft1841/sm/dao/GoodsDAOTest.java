package com.soft1841.sm.dao;
/**
 * 商品测试
 * @author蔡一帆
 */

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
        goods.setName("df");
        goods.setPrice(20);
        goods.setCover("sd");
        goods.setDescription("测试吗");
        goods.setBarcode("123");
        goods.setStock(123);
        System.out.println(goodsDAO.insertGoods(goods));
    }

    @Test
    public void deleteGoods() throws SQLException {
    goodsDAO.deleteGoodsByBarcode(888889000);
    }

    @Test
    public void selectAllGoods() throws SQLException {
        List<Goods> goodsList = goodsDAO.selectAllGoods();
        goodsList.forEach(goods -> System.out.println(goods.getName()));
    }

    @Test
    public void selectGoodsByTypeId() throws SQLException {
        List<Goods> goodsList = goodsDAO.selectGoodsByTypeId(1);
        goodsList.forEach(goods -> System.out.println(goods.getName()));
    }
    @Test
    public void selectGoodsLike() throws SQLException{
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