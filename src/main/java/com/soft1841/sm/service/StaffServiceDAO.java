package com.soft1841.sm.service;

public interface StaffServiceDAO {
    /**
     * 登录功能
     * @param employeeId
     * @param password
     * @return
     */
    boolean login (Long employeeId,String password);
}
