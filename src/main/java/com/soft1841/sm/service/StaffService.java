package com.soft1841.sm.service;

import com.soft1841.sm.entity.Staff;

import java.util.List;

/**员工的业务逻辑接口
 * @author 孟妮
 */
public interface StaffService {
    /**
     * 登录功能
     * @author 孟妮
     * @param employeeId
     * @param password
     * @return
     */
    /**
     * 员工登录
     * @param employeeId
     * @param password
     * @return
     */
    boolean login(Long employeeId, String password);

    /**
     * 根据工号得到种类
     * @param employeeId
     * @return
     */
    int getType(Long employeeId);

    /**
     * 新增一个员工，返回自增主键
     * @param staff
     * @return
     */
    Long addStaff(Staff staff);

    /**
     * 根据工号删除员工
     * @param employId
     */
    void deleteStaff(long employId);

    /**
     * 查询所有员工信息
     * @return
     */
    List<Staff> getAllStaff();

    /**
     * 根据工号查询某一员工
     * @param employId
     * @return
     */

    Staff getStaff(long employId);

    /**id
     * 根据职位查询某一职位的员工
     * @param typeId
     * @return
     */
    Staff getStaff(int typeId);

    /**
     * 根据工号更新员工数据
     * @param employId
     */
    void  updateStaff (long employId);


}

