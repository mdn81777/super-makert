package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务实现类
 * author@蔡一帆
 */

public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();
    @Override
    public Long addGoods(Goods goods) {
        long result = 0;
        try {
            result = goodsDAO.insertGoods(goods);
        } catch (SQLException e) {
           System.err.println("新增商品出现异常");
        }
        return result;
    }

    @Override
    public void deleteGoods(long barcode) {
        try {
            goodsDAO.deleteGoodsByBarcode(barcode);
        } catch (SQLException e) {
            System.err.println("删除商品出现异常");
        }
    }

    @Override
    public void updateGoods(Goods goods) {
        try {
            goodsDAO.updateGoods(goods);
        } catch (SQLException e) {
            System.err.println("修改商品出现的异常");
        }
    }

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectAllGoods();
        } catch (SQLException e) {
            System.err.println("查询所有商品信息出现异常");
        }
        return goodsList;
    }

    @Override
   public List<Goods> getGoodsByTypeId(long typeId){
        List<Goods> goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectGoodsByTypeId(typeId);
        } catch (SQLException e) {
            System.err.println("根据类别查询商品");
        }
        return goodsList;
    }


    @Override
    public List<Goods> getGoodsLike(String keywords) {
        List<Goods> goodsList = new ArrayList<>();
        try {
            goodsList = goodsDAO.selectGoodsLike(keywords);
        } catch (SQLException e) {
            System.err.println("根据关键词查询商品信息出现异常");
        }
        return goodsList;
    }
}
