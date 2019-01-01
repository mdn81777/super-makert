package com.soft1841.sm.dao.impl;
/**
 *商品的实现类
 * @author 蔡一帆
 */

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.GoodsDAO;
import com.soft1841.sm.entity.Goods;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {

    @Override
    public Long insertGoods(Goods goods) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_goods")
                        .set("type_id", goods.getTypeId())
                        .set("goods_name", goods.getName())
                        .set("price", goods.getPrice())
                        .set("cover", goods.getCover())
                        .set("description", goods.getDescription())
                        .set("barcode", goods.getBarcode())
                        .set("stock", goods.getStock())
        );
    }

    @Override
    public int deleteGoodsByBarcode(long barcode) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("barcode", barcode)
        );
    }

    @Override
    public List<Goods> selectAllGoods() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods");
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public Goods getGoodsById(long typeId) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT *FROM t_type_id = ? ",typeId);
        return convertGoods(entity);
    }
//
//    @Override
//    public Goods getGoodsByTypeId(long typeId) throws SQLException {
//        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE type_id = ?", typeId);
//        return convertGoods(entity);
//
//    }
    @Override
    public Goods getGoodsByBarcode(long barcode) throws SQLException{
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE barcode = ?",barcode);
        return convertGoods(entity) ;
    }


    @Override
    public List<Goods> selectGoodsLike(String keywords) throws SQLException {
        List<Entity> entityList = Db.use().findLike("t_goods", "goods_name", keywords, Condition.LikeType.Contains);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity : entityList) {
           goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    ;

    @Override
    public List<Goods> selectGoodsByTypeId(long typeId) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE type_id = ?", typeId);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity : entityList) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList;
    }

    @Override
    public List<Goods> selectGoodsByBarcode(long barcode) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE barcode = ?",barcode);
        List<Goods> goodsList = new ArrayList<>();
        for (Entity entity:entityList) {
            goodsList.add(convertGoods(entity));
        }
        return goodsList ;
    }

    @Override
    public Goods getGoodsByID(long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE id = ?", id);
        return convertGoods(entity);
    }


    @Override
    public int updateGoods(Goods goods) throws SQLException {
        return Db.use().update(
                Entity.create().set("price", goods.getPrice())
                        .set("stock", goods.getStock()),
                Entity.create("t_goods").set("barcode", goods.getBarcode())
        );
    }
    @Override
    public  int countByType(long typeId) throws  SQLException{
        return  Db.use().queryNumber("SELECT COUNT(*) FROM t_goods WHERE type_id = ? ",typeId).intValue();
    }

    @Override
    public int countGoods() throws SQLException {
        return Db.use().queryNumber("SELECT COUNT(*) FROM t_goods ").intValue();
    }

    private Goods convertGoods(Entity entity) {
        Goods goods = new Goods();
        goods.setId(entity.getLong("id"));
        goods.setTypeId(entity.getLong("type_id"));
        goods.setName(entity.getStr("goods_name"));
        goods.setPrice(entity.getDouble("price"));
        goods.setCover(entity.getStr("cover"));
        goods.setBarcode(entity.getLong("barcode"));
        goods.setDescription(entity.getStr("description"));
        goods.setStock(entity.getInt("stock"));
        return goods;
    }
}
