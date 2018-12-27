package com.soft1841.sm.service;

import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;



public class StaffServiceTest {
    private StaffService staffService = ServiceFactory.getStaffServiceInstance();

    @Test
    public void login(){
        Boolean flag;
        flag = staffService.login(123l,"123");
        System.out.println(flag);
    }


}