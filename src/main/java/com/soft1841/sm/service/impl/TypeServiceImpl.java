package com.soft1841.sm.service.impl;


import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    @Override
    public List<Type> getAllTypes() {
        List<Type> typeList = new ArrayList<>();
        try {
            typeList = typeDAO.selectAllTypes();
        } catch (SQLException e) {
            System.err.println("查询商品类别出现异常");
        }
        return typeList;
    }

    @Override
    public Long addType(Type type) {
        long result = 0;
        try {
            result = typeDAO.insertType(type);
        } catch (SQLException e) {
            System.err.println("新增商品类别出现异常");
        }
        return result;

    }

    @Override
    public void deleteType(long id) {
        try {
            typeDAO.deleteTypeById(id);
        } catch (SQLException e) {
            System.err.println("删除商品类别出现异常");
        }
    }

    @Override
    public void updateType(Type type) {
        try {
            typeDAO.updateType(type);
        } catch (SQLException e) {
            System.err.println("修改类别出现异常");
        }
    }

    @Override
    public Type getType(int id) {
        Type type = new Type();
        try {
            type = typeDAO.getTypeByID(id);
        } catch (SQLException e) {
            System.err.println("查询单个类别出现异常");
        }
        return type;
    }
}
