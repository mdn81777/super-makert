package com.soft1841.sm.service;

import org.junit.Test;



public class StaffServiceTest {
    private StaffService staffService = ServiceFactory.getStaffServiceInstance();
    @Test
    public void login(){
        Boolean flag;
        flag = staffService.login(113l,"123");
        System.out.println(flag);
    }


}