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
        supplier.setSupplierAddress("nanjing");
        supplier.setSupplierName("hello");
        supplier.setSupplierPhone("13322221111");
        supplier.setLinkman("nanjing");
        System.out.println(supplierDAO.insertSupplier(supplier));
    }

    @Test
    public void selectAllSupplier() throws SQLException {
        List<Supplier> supplierList = supplierDAO.selectAllSupplier();
        supplierList.forEach(supplier -> System.out.println(supplier));
    }

    @Test
    public void deleteSupplierById() throws SQLException {
        supplierDAO.deleteSupplierById(1L);
    }

    @Test
    public void updateSupplier() throws SQLException{
        Supplier supplier = new Supplier();
        supplier.setId(1l);
        supplier.setSupplierAddress("aaaaaa");
        supplier.setSupplierPhone("11111111");
        supplierDAO.updateSupplier(supplier);
    }

    @Test
    public void insertSupplier1() {
    }

    @Test
    public void selectAllSupplier1() {
    }

    @Test
    public void deleteSupplierById1() {
    }

    @Test
    public void getSupplierByID() {
    }

    @Test
    public void countByType() {
    }

    @Test
    public void updateSupplier1() {
    }
}