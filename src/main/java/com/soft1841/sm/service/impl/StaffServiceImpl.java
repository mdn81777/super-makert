package com.soft1841.sm.service.impl;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.service.StaffServiceDAO;
import com.soft1841.sm.utils.DAOFactory;


import java.sql.SQLException;

public class StaffServiceImpl implements StaffServiceDAO {
    private  StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();
    @Override
    public boolean login(Long employeeId, String password) {
        Entity staff = null;
        try {
            staff = staffDAO.getStaffById(employeeId);

        }catch (SQLException e){
            e.printStackTrace();
        }
        if (staff != null){
            if (password.equals(staff.）{
                return true;
            }
        }
        return false;
    }
}
