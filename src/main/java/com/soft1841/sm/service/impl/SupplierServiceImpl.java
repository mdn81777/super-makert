package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.SupplierDAO;
import com.soft1841.sm.entity.Supplier;
import com.soft1841.sm.service.SupplierService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();

    @Override
    public Long addSuppler(Supplier supplier) {
        long result = 0;
        try {
            result = supplierDAO.insertSupplier(supplier);
        } catch (SQLException e) {
            System.err.println("新增供货商异常");
        }
        return result;
    }

    @Override
    public void deleteSupplier(long id) {
        try {
            supplierDAO.deleteSupplierById(id);
        } catch (SQLException e) {
            System.err.println("删除供货商异常");
        }
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        try {
            supplierDAO.updateSupplier(supplier);
        } catch (SQLException e) {
            System.err.println("修改供货商信息出现异常");
        }
    }

    @Override
    public List<Supplier> getAllSupplier() {
        List<Supplier> supplierList = new ArrayList<>();
        try {
            supplierList = supplierDAO.selectAllSupplier();
        } catch (SQLException e) {
            System.err.println("查询供货商出现异常");
        }
        return supplierList;
    }
}
