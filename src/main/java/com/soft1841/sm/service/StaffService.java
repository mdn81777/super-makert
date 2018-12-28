package com.soft1841.sm.service;

import com.soft1841.sm.entity.Staff;

import java.util.List;

/**
 * 员工的业务逻辑接口
 *
 * @author 孟妮
 */
public interface StaffService {

    /**
     * 员工登录
     *
     * @param employeeId
     * @param password
     * @return
     */
    boolean login(Long employeeId, String password);

    /**
     * 根据工号得到种类
     *
     * @param employeeId
     * @return
     */
    int getType(Long employeeId);

    /**
     * 新增一个员工，返回自增主键
     *
     * @param staff
     * @return
     */
    Long addStaff(Staff staff);

    /**
     * 根据工号删除员工
     *
     * @param employId
     */
    void deleteStaff(long employId);

    /**
     * 查询所有员工信息
     *
     * @return
     */
    List<Staff> getAllStaff();

    /**
     * 根据工号查询某一员工
     *
     * @param employId
     * @return
     */

    Staff getStaffByEmployId(long employId);

    /**
     * 判断工号是否已存在
     *
     * @param employeeId
     * @return
     */
    boolean employeeIdRepetition(Long employeeId);

    /**
     * id
     * 根据职位查询员工
     *
     * @param typeId
     * @return
     */
    List<Staff> getStaffByTypeId(int typeId);


    /**
     * @param staff
     */
    void updateStaff(Staff staff);

    /**
     * 根据人名模糊查询员工
     *
     * @param keywords
     * @return
     */
    List<Staff> getStaffLike(String keywords);
}

