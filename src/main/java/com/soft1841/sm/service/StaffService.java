package com.soft1841.sm.service;

import java.sql.SQLException;

public interface StaffService {
    /**
     * 登录功能
     * @param employeeId
     * @param password
     * @return
     */
    boolean login (Long employeeId,String password);
}
