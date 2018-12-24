package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SupplierDAO;
import com.soft1841.sm.entity.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public Long insertSupplier(Supplier supplier) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_supplier")
                        .set("supplier_name", supplier.getSupplierName())
                        .set("supplier_address", supplier.getSupplierAddress())
                        .set("supplier_phone",supplier.getSupplierPhone())
                        .set("linkman", supplier.getLinkman())
        );
    }


    @Override
    public List<Entity> selectAllSupplier() throws SQLException {
        return Db.use().query("SELECT * FROM t_staff");
    }



    @Override
    public int deleteSupplierById(long id) throws SQLException {
        return Db.use().del(
                Entity.create("t_supplier").set("id",id));
    }

    @Override
    public int updateSupplier(Supplier supplier) throws SQLException {
        return Db.use().update(
                Entity.create().set("supplier_name", supplier.getSupplierName())
                        .set("supplier_phone", supplier.getSupplierPhone()),
                Entity.create("t_supplier").set("id", supplier.getId()));
    }
}
