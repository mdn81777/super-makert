package com.soft1841.sm.service.impl;


import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.entity.Staff;
import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;

public class StaffServiceImpl implements StaffService {

    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();

    @Override
    public boolean login(Long employeeId, String password) {
        Staff staff = null;
        try {
            staff = staffDAO.getStaffByEmployeeId(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (staff != null) {
            if (password.equals(staff.getPassWord())) {
                return true;
            }
        }
        return false;
    }
}
