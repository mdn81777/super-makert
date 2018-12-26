package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SupplierDAOTest {
    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();

    @Test
    public void insertSupplier() throws SQLException {
        Supplier supplier = new Supplier();
        supplier.setSupplierAddress("");
        supplier.setSupplierName("");
        supplier.setSupplierPhone("");
        supplier.setLinkman("");
        System.out.println(supplierDAO.insertSupplier(supplier));
    }

    @Test
    public void selectAllSupplier() throws SQLException {
    }

    @Test
    public void deleteSupplierById() throws SQLException {
        supplierDAO.deleteSupplierById(1);
    }

    @Test
    public void updateSupplier() throws SQLException{
        Supplier supplier = new Supplier();
        supplier.setId(1l);
        supplier.setSupplierAddress("");
        supplier.setSupplierPhone("");
        supplierDAO.updateSupplier(supplier);
    }
}