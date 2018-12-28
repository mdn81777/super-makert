package com.soft1841.sm.service.impl;
/**
 * 实现员工服务类
 *
 * @author 孟妮
 */

import com.soft1841.sm.dao.StaffDAO;
import com.soft1841.sm.entity.Staff;
import com.soft1841.sm.service.StaffService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffDAO staffDAO = DAOFactory.getStaffDAOInstance();

    @Override
    public boolean login(Long employeeId, String password) {
        Staff staff = null;
        try {
            staff = staffDAO.getStaffByEmployeeId(employeeId);
        } catch (NullPointerException e) {
            System.err.println("登陆出现空指针异常");
        } catch (SQLException e) {
            System.err.println("登陆出现数据库异常");
        }
        if (staff != null) {
            if (password.equals(staff.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getType(Long employeeId) {
        Staff staff = null;
        try {
            staff = staffDAO.getStaffByEmployeeId(employeeId);
        } catch (SQLException e) {
            System.err.println("得到职位出现数据库异常");
        }catch (NullPointerException e){
            System.err.println("得到职位出现空指针异常");
        }
        if (staff != null) {
            int typeId = staff.getTypeId();
            return typeId;
        } else return 0;
    }

    @Override
    public Long addStaff(Staff staff) {
        long result = 0;
        try {
            result = staffDAO.insertStaff(staff);
        } catch (SQLException e) {
            System.err.println("新增员工出现异常");
        }
        return result;
    }

    @Override
    public void deleteStaff(long employId) {
        try {
            staffDAO.deleteStaffByEmployeeId(employId);
        } catch (SQLException e) {
            System.err.println("根据工号删除员工出现异常");
        }
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try {
            staffList = staffDAO.selectAllStaff();
        } catch (SQLException e) {
            System.err.println("查询所有员工出现异常");
        }
        return staffList;
    }

    @Override
    public Staff getStaffByEmployId(long employId) {
        Staff staff = new Staff();
        try {
            staff = staffDAO.getStaffByEmployeeId(employId);
        } catch (SQLException e) {
            System.err.println("根据工号查询员工出现异常");
        } catch (NullPointerException e) {
            System.err.println("根据工号查询员工出现空指针异常");
        }
        return staff;
    }

    @Override
    public boolean employeeIdRepetition(Long employeeId) {
        Staff staff = new Staff();
        try {
            staff = staffDAO.getStaffByEmployeeId(employeeId);
        } catch (NullPointerException e) {
            System.err.println("得到职位出现空指针异常");
        } catch (SQLException e) {
            System.err.println("得到职位出现数据库异常");
        }
        if(staff != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Staff> getStaffByTypeId(int typeId) {
        List<Staff> staffList = new ArrayList<>();
        try {
            staffList = staffDAO.getStaffByTypeId(typeId);
        } catch (SQLException e) {
            System.err.println("根据职位查询员工出现异常");
        }
        return staffList;
    }

    @Override
    public void updateStaff(Staff staff) {
        try {
            staffDAO.updateStaff(staff);
        } catch (SQLException e) {
            System.err.println("修改员工信息出现异常");
        }
    }

    @Override
    public List<Staff> getStaffLike(String keywords) {
        List<Staff> staffList = new ArrayList<>();
        try {
            staffList = staffDAO.getStaffsLike(keywords);
        } catch (SQLException e) {
            System.err.println("根据关键字查询员工出现异常");
        }
        return staffList;
    }

}
