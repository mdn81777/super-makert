package com.soft1841.sm.service.impl;

import com.soft1841.sm.dao.*;
//import com.soft1841.sm.dao.TypeDAO;
//import com.soft1841.sm.dao.StaffDAO;
//import com.soft1841.sm.dao.GoodsDAO;
//import com.soft1841.sm.dao.SupplierDAO;
//import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.service.AnalysisService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;


public class AnalysisServiceImpl implements AnalysisService {
    private GoodsDAO goodsDAO = DAOFactory.getGoodsDAOInstance();
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();
    private SupplierDAO supplierDAO = DAOFactory.getSupplierDAOInstance();
    @Override
    public int getGoodsCount() {
        int n = 0;
        try {
            n = goodsDAO.countGoods();
        }catch (SQLException e){
            System.out.println("统计商品总数出现异常");
        }
        return n;
    }

    @Override
    public int getTypeCount() {
        int n = 0;
        try {
            n = typeDAO.countTypes();
        }catch (SQLException e){
            System.out.println("统计类别总数出现异常");
        }
        return n;
    }

    @Override
    public int getStaffCount() {
        int n = 0;
        try {
            n= staffDAO.countStaff();
        }catch (SQLException e){
            System.out.println("统计员工总数出现异常");
        }
        return n;
    }

    @Override
    public int getMemberCount() {
        int n = 0;
        try {
            n = memberDAO.countMember();
            }catch (SQLException e){
            System.out.println("统计会员总数出现异常");
        }
        return n;
    }

    @Override
    public int getSupplierCount() {
        int n = 0;
        try {
            n = supplierDAO.countSupplier();
        }catch (SQLException e){
            System.out.println("统计供应商总数出现异常");
        }
        return n;
    }
}
