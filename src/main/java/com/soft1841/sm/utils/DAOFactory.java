package com.soft1841.sm.utils;

import com.soft1841.sm.dao.*;
import com.soft1841.sm.dao.impl.*;

public class DAOFactory {
    public static DetailDAO getDetailDAOInstance(){ return new DetailDAOImpl(); }
    public static GoodsDAO getGoodsDAOInstance(){ return new GoodsDAOImpl(); }
    public static MemberDAO getMemberDAOInstance(){ return new MemberDAOImpl(); }
    public static PositionDAO getPositionDAOInstance(){ return new PositionDAOImpl(); }
    public static ReceiptDAO getReceiptDAOInstance(){ return new ReceiptDAOImpl(); }
    public static StaffDAO getStaffDAOInstance(){ return new StaffDAOImpl(); }
    public static SupplierDAO getSupplierDAOInstance(){ return new SupplierDAOImpl(); }
    public static TypeDAO getTypeDAOInstance(){
        return new TypeDAOImpl();
    }
}
