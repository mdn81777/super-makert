package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Staff;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StaffDAOTest {
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();

    @Test
    public void insertStaff() throws SQLException {
        Staff staff = new Staff();
        staff.setTypeId(1);
        staff.setEmployeeId(1l);
        staff.setPassWord("");
        staff.setName("");
        staff.setCover("");
        staff.setAddress("");
        System.out.println(staffDAO.insertStaff(staff));
    }

    @Test
    public void deleteStaff() throws SQLException {
        staffDAO.deleteStaffByEmployeeId(1);
    }

    @Test
    public void selectAllStaff() throws SQLException {
        List<Entity> StaffList =staffDAO.selectAllStaff();
        StaffList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getStaffByEmployeeId()throws SQLException {
        Staff entity = staffDAO.getStaffByEmployeeId(1L);
        System.out.println(entity);
    }

    @Test
    public void updateStaff() throws SQLException{
        Staff staff = new Staff();
        staff.setEmployeeId(12l);
        staff.setTypeId(12);
        staff.setPassWord("");
        staffDAO.updateStaff(staff);
    }
}