package com.soft1841.sm.service.impl;
/**
 * Detail实现类
 * author@蔡一帆
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.DetailDAO;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Detail;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.service.DetailService;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailServiceImpl implements DetailService {
    private DetailDAO detailDAO = DAOFactory.getDetailDAOInstance();
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();


    @Override
    public Double getSubtotal(Detail detail) {
        Double price = 0.0;
        try {
            price = goodsDAO.getGoodsByBarcode(detail.getBarcode()).getPrice();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Double subtotal = price*detail.getAmount();
        return subtotal;
    }

    @Override
    public List<Detail> getAllDetail() {
        List<Detail> detailList = new ArrayList<>();
        try {
            detailList =detailDAO.selectAllDetail();
        } catch (SQLException e) {
            System.err.println("查询所有小票明细出现的异常");
        }
        return detailList;
    }

    @Override
    public Long addDetail(Detail detail) {
        long result = 0;
        try {
            result = detailDAO.insertDetail(detail);
        } catch (SQLException e) {
            System.err.println("新增小票出现异常");
        }
        return result ;
    }

    @Override
    public List<Detail> getDetailByReceiptId(long receiptId) {
       List<Detail> detailList = new ArrayList<>();
       try {
           detailList = detailDAO.selectDetailByReceiptId(receiptId);
       } catch (SQLException e) {
         System.err.println("根据收银小票号查询明细出现的异常");
       }
        return detailList;
    }


}
