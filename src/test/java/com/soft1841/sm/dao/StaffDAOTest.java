package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StaffDAOTest {
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();

    @Test
    public void insertStaff() {
    }

    @Test
    public void deleteStaff() {
    }

    @Test
    public void selectAllStaff() throws SQLException {
        List<Entity> StaffList =staffDAO.selectAllStaff();
        StaffList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getStaffById() {
    }

    @Test
    public void updateStaff() {
    }
}