package com.soft1841.sm.utils;

import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.dao.impl.StaffDAOImpl;

public class ServiceFactory {
    public  static StaffDAO getStaffDAOInstance(){
        return  new StaffDAOImpl();
    }
}
