package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.ReceiptDAO;
import com.soft1841.sm.entity.Receipt;

import java.sql.SQLException;
import java.util.List;

public class ReceiptDAOImpl implements ReceiptDAO {
    @Override
    public Long insertReceipt(Receipt receipt) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_receipt")
                        .set("employee_id", receipt.getEmployeeId())
                        .set("member_id", receipt.getMemberId())
                        .set("total", receipt.getTotal())
        );

    }

    @Override
    public Entity getReceiptById(long id) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_receipt WHERE id = ?",id);
    }

    @Override
    public List<Entity> getAllReceipt() throws SQLException {
        return Db.use().query("SELECT * FROM t_receipt");
    }
}
