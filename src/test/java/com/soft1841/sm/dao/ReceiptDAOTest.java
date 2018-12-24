package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Receipt;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ReceiptDAOTest {
    private ReceiptDAO receiptDAO = DAOFactory.getReceiptDAOInstance();

    @Test
    public void insertReceipt()throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setEmployeeId(1);
        receipt.setMemberId(1);
        receipt.setTotal(1);
    }

    @Test
    public void getReceiptById() throws SQLException {
        Entity entity = receiptDAO.getReceiptById(1);
        System.out.println(entity);
    }

    @Test
    public void getAllReceipt() throws SQLException {
        List<Entity> entity = receiptDAO.getAllReceipt();
        System.out.println(entity);
    }
}