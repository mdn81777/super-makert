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
    public int deleteGoodsByBarcode(long barcode) throws SQLException {
        return Db.use().del(
                Entity.create("t_goods").set("goods_barcode",barcode)
        );
    }

    @Override
    public List<Goods> selectAllGoods() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods");
        List<Goods> goodsList = new ArrayList<>();
        return goodsList;
    }

    @Override
    public Goods getGoodsByTypeId(long typeId) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE type_id = ?",typeId );
        return convertGoods(entity);
    }
    private Goods convertGoods(Entity entity){
        Goods goods = new Goods();
        return  goods;
    }


    @Override
    public List<Goods> selectGoodsLike(String keywords) throws SQLException {
        List<Entity> entityList = Db.use().findLike("t_goods","name",keywords,Condition.LikeType.Contains);
        List<Goods> goodsList = new ArrayList<>();
        return goodsList;
    };
    @Override
    public List<Goods> selectGoodsByTypeId(long typeId) throws SQLException{
        List<Entity> entityList = Db.use().query("SELECT * FROM t_goods WHERE type_id = ?",typeId);
        List<Goods> goodsList = new ArrayList<>();
        return goodsList;
    }

    @Override
    public Goods getGoodsByID(long id) throws SQLException{
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE id = ?",id);
        return convertGoods(entity);
    }

    ;

    @Override
    public int updateGoods(Goods goods) throws SQLException {
        return Db.use().update(
                Entity.create().set("goods_price",goods.getPrice())
                        .set("goods_ stock",goods.getStock()),
                Entity.create("t_goods").set("goods_barcode",goods.getBarcode())
        );

    }
}
