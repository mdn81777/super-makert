package com.soft1841.sm.service.impl;
/**
 * 实现员工服务类
 * @author 孟妮
 */

import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.entity.Staff;
import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.utils.DAOFactory;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class StaffServiceImpl implements StaffService {
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();

    @Override
    public boolean login(Long employeeId, String password) {
        Staff staff = null;
        try {
            staff = staffDAO.getStaffByEmployeeId(employeeId);
        } catch (NullPointerException e) {

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

    @Override
    public int getType(Long employeeId) {
        Staff staff = null;
        try {
            staff = staffDAO.getStaffByEmployeeId(employeeId);
        } catch (NullPointerException e) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (staff != null) {
            int typeId = staff.getTypeId();
            return typeId;
        } else return 0;
    }

}
