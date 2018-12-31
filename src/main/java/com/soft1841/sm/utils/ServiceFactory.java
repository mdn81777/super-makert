package com.soft1841.sm.utils;
import com.soft1841.sm.service.*;
import com.soft1841.sm.service.impl.*;
/**
 * 业务逻辑类工厂
 */
public class ServiceFactory {
    public static StaffService getStaffServiceInstance() {
        return new StaffServiceImpl();
    }

    public static TypeService getTypeServiceInstance() {
        return new TypeServiceImpl();
    }

    public static MemberService getMemberServiceInstance() {
        return new MemberServiceImpl();
    }

    public static SupplierService getSupplierServiceInstance() {
        return new SupplierServiceImpl();
    }

    public static ReceiptService getReceiptServiceInstancw() {
        return new ReceiptServiceImpl();
    }

    public static PositionService getPositionServiceInstance() {
        return new PositionServiceImpl();
    }

    public static GoodsService getGoodsServiceInstance() {
        return new GoodsServiceImpl();
    }

    public static DetailService getDetailServiceInstance() {
        return new DetailServiceImpl();
    }
}
