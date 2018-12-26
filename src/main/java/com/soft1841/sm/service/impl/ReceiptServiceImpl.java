package com.soft1841.sm.service.impl;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.ReceiptDAO;
import com.soft1841.sm.entity.Receipt;
import com.soft1841.sm.service.ReceiptService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private  ReceiptDAO receiptDAO = DAOFactory.getReceiptDAOInstance();
    @Override
    public List<Entity> getAllReceipt() {
        List<Entity> receiptList = new ArrayList<>();
        try {
            receiptList = receiptDAO.selectAllReceipt();
        }catch (SQLException e){
            System.err.println("查询所有收银明细出现异常");
        }
        return receiptList;
    }
  
    @Override
    public Entity getReceiptById(long id) {
        return null;
    }

    @Override
    public Long addReceipt(Receipt receipt) {
        return null;
    }
}
