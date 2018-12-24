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
    public int deleteStaff(long employeeId) throws SQLException {
        return Db.use().del(
                Entity.create("t_staff").set("employee_id",employeeId));
    }

    @Override
    public List<Entity> selectAllStaff() throws SQLException {
        return Db.use().query("SELECT * FROM t_staff");
    }

    @Override
    public Entity getStaffById(long employeeId) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_staff WHERE employee_id = ?",employeeId);
    }

    @Override
    public int updateStaff(Staff staff) throws SQLException {
        return Db.use().update(
                Entity.create().set("type_id", staff.getTypeId())
                        .set("password", staff.getPassWord()),
                Entity.create("t_staff").set("employee_id", staff.getEmployeeId()));
    }

    @Override
    public List<Staff> selectAllById(long emloyeeId) throws SQLException {
        return null;
    }

    private  Staff converStaff(Entity entity){
        Staff staff = new Staff(
                entity.getLong("typeId"),
                entity.getLong("employeeId"),
                entity.getStr("name"),
                entity.getStr("passWord"),
                entity.getStr("address"),
                entity.getStr("cover"));

        return  staff;
    }

}
