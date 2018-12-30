package com.soft1841.sm.dao.impl;
/**
 * 小票接口实现类
 * author蔡一帆
 */

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.DetailDAO;
import com.soft1841.sm.entity.Detail;
import com.soft1841.sm.entity.Goods;
import sun.plugin2.message.Conversation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailDAOImpl implements DetailDAO {
    @Override
    public Long insertDetail(Detail detail) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_detail")
                        .set("receipt_id", detail.getReceiptId())
                        .set("barcode", detail.getBarcode())
                        .set("amount", detail.getAmount())

        );
    }

    @Override
     public Detail getDetailByReceiptId(long receiptId) throws SQLException {
     Entity entity = Db.use().queryOne("SELECT * FROM t_detail WHERE receipt_id = ?",receiptId);
     return convertDetail(entity);
    }

    @Override
    public List<Entity> getAllDetail() throws SQLException {
        return Db.use().query("SELECT * FROM t_detail ");
    }

    @Override
    public List<Detail> selectAllDetail() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_detail");
        List<Detail> detailList = new ArrayList<>();
        return detailList;
    }

    @Override
    public int updateDetail(Detail detail) throws SQLException {
        return Db.use().update(
                Entity.create().set("amount", detail.getAmount()),
                Entity.create("t_detail").set("barcode", detail.getBarcode())
        );
    }

    @Override
    public List<Detail> selectDetailByReceiptId(long receiptId) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_detail WHERE receipt_id = ?",receiptId);
        List<Detail> detailList = new ArrayList<>();
        for (Entity entity:entityList) {
            detailList.add(convertDetail(entity));
        }
        return detailList ;
    }

    private Detail convertDetail(Entity entity){
        Detail detail = new Detail();
        detail.setId(entity.getLong("id"));
        detail.setReceiptId(entity.getLong("receipt_id"));
        detail.setBarcode(entity.getLong("barcode"));
        detail.setAmount(entity.getDouble("amount"));
        return detail;
    }
}