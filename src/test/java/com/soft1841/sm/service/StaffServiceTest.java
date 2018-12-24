package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffServiceTest {
    private StaffService staffService = ServiceFactory.getStaffServiceInstance();
    @Test
    public void login(){
        Boolean flag = staffService.login(Long.valueOf(113),"123");
        System.out.println(flag);
    }


}