package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SupplierDAOTest {
    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();

    @Test
    public void insertSupplier() {
    }

    @Test
    public void selectAllSupplier() throws SQLException {
        List<Entity> SupplierList =supplierDAO.selectAllSupplier();
        SupplierList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void deleteSupplierById() {
    }

    @Test
    public void updateSupplier() {
    }
}