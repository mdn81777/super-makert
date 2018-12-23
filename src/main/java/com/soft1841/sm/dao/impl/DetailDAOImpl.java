package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.DetailDAO;
import com.soft1841.sm.entity.Detail;

import java.sql.SQLException;
import java.util.List;

public class DetailDAOImpl implements DetailDAO {
    @Override
    public Long insertDetail(Detail detail) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_detail")
                        .set("receipt_id",detail.getReceiptId())
                        .set("barcode",detail.getBarcode())
                        .set("amount",detail.getAmount())

        );
    }

    @Override
    public List<Entity> selectAllDetail() throws SQLException {
        return Db.use().query("SELECT * FROM t_book ");
    }
}