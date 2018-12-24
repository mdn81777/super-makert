package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;

import java.sql.SQLException;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {
    @Override
    public Long insertGoods(Goods goods) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id",goods.getTypeId())
                        .set("goods_name",goods.getName())
                        .set("goods_price",goods.getPrice())
                        .set("goods_cover",goods.getCover())
                        .set("goods_description",goods.getDescription())
                        .set("goods_barcode",goods.getBarcode())
                        .set("goods_stock",goods.getStock())
        );
    }

    @Override
    public int deleteGoods(String barcode) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("goods_barcode",barcode)
        );
    }

    @Override
    public List<Entity> selectAllGoods() throws SQLException {
        return Db.use().query("SELECT * FROM t_goods");
    }

    @Override
    public Entity getGoodsByTypeId(int typeId) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_goods WHERE type_id = ?",typeId);
    }


    @Override
    public List<Entity> selectGoodsLike(String keywords) throws SQLException {
        return Db.use().findLike("t_goods","goods_name,",keywords, Condition.LikeType.Contains);
    };


    @Override
    public int updateGoods(Goods goods) throws SQLException {
        return Db.use().update(
                Entity.create().set("goods_price",goods.getPrice())
                        .set("goods_ stock",goods.getStock()),
                Entity.create("t_goods").set("goods_barcode",goods.getBarcode())
        );
    }
}
