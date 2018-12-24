package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffDAO {
    /**
     * 写入新员工
     * @param staff
     * @return
     * @throws SQLException
     */
    Long insertStaff(Staff staff) throws SQLException;

    /**
     * 根据员工号删除员工
     * @param employeeId
     * @return
     * @throws SQLException
     */
    int deleteStaff(long employeeId)throws SQLException;

    /**
     * 查询所有员工
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllStaff()throws SQLException;

    /**
     * 通过员工号查询某一员工
     * @param employeeId
     * @return
     * @throws SQLException
     */
    Entity getStaffById(long employeeId)throws SQLException;

    /**
     * 根据员工号更新员工数据
     * @param staff
     * @return
     * @throws SQLException
     */
    int updateStaff(Staff staff)throws SQLException;
     List<Staff> selectAllById(long emloyeeId)throws  SQLException;


}
