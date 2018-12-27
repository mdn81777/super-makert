package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.entity.Staff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements StaffDAO {

    @Override
    public Long insertStaff(Staff staff) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_staff")
                        .set("type_id", staff.getTypeId())
                        .set("employee_id", staff.getEmployeeId())
                        .set("password", staff.getPassWord())
                        .set("name", staff.getName())
                        .set("cover", staff.getCover())
                        .set("address", staff.getAddress())
        );
    }

    @Override
    public int deleteStaffByEmployeeId(long employeeId) throws SQLException {
        return Db.use().del(
                Entity.create("t_staff").set("employee_id", employeeId));
    }

    @Override
    public List<Staff> selectAllStaff() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_staff");
        List<Staff> staffList = new ArrayList<>();
        for (Entity entity : entityList) {
            staffList.add(convertStaff(entity));
        }
        return staffList;
    }

    @Override
    public Staff getStaffByEmployeeId(long employeeId) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_staff WHERE employee_id = ?", employeeId);
        return convertStaff(entity);
    }

    @Override
    public List<Staff> getStaffByTypeId(int typeId) throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_staff WHERE type_id = ?", typeId);
        List<Staff> staffList = new ArrayList<>();
        for (Entity entity : entityList) {
            staffList.add(convertStaff(entity));
        }
        return staffList;
    }


    @Override
    public int updateStaff(Staff staff) throws SQLException {
        return Db.use().update(
                Entity.create().set("type_id", staff.getTypeId())
                        .set("password", staff.getPassWord()),
                Entity.create("t_staff").set("employee_id", staff.getEmployeeId()));
    }

    private Staff convertStaff(Entity entity) {
        Staff staff = new Staff(entity.getInt("id"),
                entity.getInt("type_id"),
                entity.getLong("employee_id"),
                entity.getStr("password"),
                entity.getStr("name"),
                entity.getStr("cover"),
                entity.getStr("address"));

        return staff;
    }

}
