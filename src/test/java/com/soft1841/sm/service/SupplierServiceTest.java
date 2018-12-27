package com.soft1841.sm.service;

import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SupplierServiceTest {
    private SupplierService supplierService = ServiceFactory.getSupplierServiceInstance();

    @Test
    public void addSuppler() {
        Supplier supplier = new Supplier();
        supplier.setSupplierAddress("beijing");
        supplier.setSupplierName("beijing");
        supplier.setSupplierPhone("13322221111");
        supplier.setLinkman("lin");
        System.out.println(supplierService.addSuppler(supplier));
    }

    @Test
    public void deleteSupplier() {
    }

    @Test
    public void updateSupplier() {
    }

    @Test
    public void getAllSupplier() {
        List<Supplier> supplierList = supplierService.getAllSupplier();
        supplierList.forEach(supplier -> System.out.println(supplier));
    }

    @Test
    public void getSupplier() {

    }
}