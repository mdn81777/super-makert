package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.entity.Staff;

import java.sql.SQLException;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {
    @Override
    public Long insertStaff(Staff staff) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_staff")
                .set("type_id",staff.getTypeId())
                .set("employee_id",staff.getEmployeeId())
                .set("password",staff.getPassWord())
                .set("name",staff.getName())
                .set("cover",staff.getCover())
                .set("address",staff.getAddress())
        );
    }

    @Override
    public int deleteStaff(long staffId) throws SQLException {
        return 0;
    }

    @Override
    public List<Entity> selectAllStaff() throws SQLException {
        return null;
    }

    @Override
    public Entity getStaffById(long staffId) throws SQLException {
        return null;
    }

    @Override
    public int updateStaff(long staffID) throws SQLException {
        return 0;
    }
}
