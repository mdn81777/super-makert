package com.soft1841.sm.dao.impl;
/**
 * 实现供应商类
 *
 * @author 孟妮
 */

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SupplierDAO;
import com.soft1841.sm.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {


    @Override
    public Long insertSupplier(Supplier supplier) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_supplier")
                        .set("supplier_name", supplier.getSupplierName())
                        .set("supplier_address", supplier.getSupplierAddress())
                        .set("supplier_phone", supplier.getSupplierPhone())
                        .set("linkman", supplier.getLinkman()));

    }

    @Override
    public List<Supplier> selectAllSupplier() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_supplier");
        List<Supplier> supplierList = new ArrayList<>();
        for (Entity entity : entityList){
            supplierList.add(convertSupplier(entity));
        }
        return supplierList;
    }


    @Override
    public int deleteSupplierById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_supplier").set("id", id));
    }

    @Override
    public Supplier getSupplierByID(long id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_goods WHERE id = ?", id);
        return convertSupplier(entity);
    }

    @Override
    public int countByType(long typeId) throws SQLException {
        return  Db.use().queryNumber("SELECT COUNT(*) FROM t_supplier WHERE type_id = ? ",typeId).intValue();
    }

    @Override
    public int updateSupplier(Supplier supplier) throws SQLException {
        return Db.use().update(
                Entity.create().set("supplier_name", supplier.getSupplierName())
                        .set("supplier_phone", supplier.getSupplierPhone())
                        .set("supplier_address", supplier.getSupplierAddress())
                        .set("linkman", supplier.getLinkman()),
                Entity.create("t_supplier").set("id", supplier.getId()));
    }



    private Supplier convertSupplier(Entity entity) {
        Supplier supplier = new Supplier();
        supplier.setId(entity.getLong("id"));
        supplier.setSupplierName(entity.getStr("supplier_name"));
        supplier.setSupplierAddress(entity.getStr("supplier_address"));
        supplier.setSupplierPhone(entity.getStr("supplier_phone"));
        supplier.setLinkman(entity.getStr("linkman"));
        return supplier;
    }
}
