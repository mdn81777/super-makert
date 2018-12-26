package com.soft1841.sm.utils;

import com.soft1841.sm.entity.Receipt;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.service.impl.MemberServiceImpl;
import com.soft1841.sm.service.impl.StaffServiceImpl;
import com.soft1841.sm.service.impl.TypeServiceImpl;

public class ServiceFactory {
    public static StaffService getStaffServiceInstance() {
        return new StaffServiceImpl();
    }
    public static TypeService getTypeServiceInstance(){ return new TypeServiceImpl();}
    public  static MemberService getMemberServiceInstance(){ return new MemberServiceImpl();
    }

}
