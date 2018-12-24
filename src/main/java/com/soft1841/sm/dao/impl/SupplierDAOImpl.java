package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.SupplierDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDAOImpl implements SupplierDAO {
    @Override
    public Long insertSupplier(Supplier supplier) throws SQLException {
        return Db.use().insertForGeneratedKey( Entity.create("t_supplier").set("id",supplier.get())
                        );
    }
    @Override
    public List<Entity> selectSuppler() throws SecurityException {
        return Db.use().query("") ;
    }

    @Override
    public int deleteSupplierById(long id) throws SQLException {
        return Db.use().del(Entity.create());
    }

    @Override
    public int Supplier(Supplier supplier) throws SQLException {
        return 0;
    }
}
