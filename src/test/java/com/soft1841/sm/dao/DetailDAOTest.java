package com.soft1841.sm.dao;
/**
 * 小票测试
 * @author蔡一帆
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Detail;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DetailDAOTest {
    private DetailDAO detailDAO = DAOFactory.getDetailDAOInstance();

    @Test
    public void insertDetail() throws SQLException {
        Detail detail = new Detail();
        detail.setAmount(12);
        detail.setBarcode(12);
        detail.setReceiptId(12);
        System.out.println(detailDAO.insertDetail(detail));
    }

    @Test
    public void getDetailByReceiptId() throws SQLException{
        Entity entity = detailDAO.getDetailByReceiptId(1);
        System.out.println(entity);
}

    @Test
    public void getAllDetail() {
    }
}