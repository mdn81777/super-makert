package com.soft1841.sm.utils;

import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.service.impl.StaffServiceImpl;

public class ServiceFactory {
    public static StaffService getStaffServiceInstance() {
        return new StaffServiceImpl();
    }
}
