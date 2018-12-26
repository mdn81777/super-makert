package com.soft1841.sm.service.impl;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.ReceiptDAO;
import com.soft1841.sm.entity.Receipt;
import com.soft1841.sm.service.ReceiptService;
import com.soft1841.sm.utils.DAOFactory;

import javax.xml.transform.Result;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private  ReceiptDAO receiptDAO = DAOFactory.getReceiptDAOInstance();
    @Override
    public List<Receipt> getAllReceipt() {
        List<Receipt> receiptList = new ArrayList<>();
        try {
            receiptList = receiptDAO.getAllReceipt();
        }catch (SQLException e){
            return receiptList;
        }
        return result;
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
