package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Goods;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TypeDAOTest {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    @Test
    public void insertType() throws SQLException{
        Type type = new Type();
        type.setTypeName("");
        type.setTypeCover("");
        System.out.println(typeDAO.insertType(type));
    }

    @Test
    public void deleteTypeById() throws SQLException {
        typeDAO.deleteTypeById(1);
    }

    @Test
    public void selectAllTypes() throws SQLException {
        List<Type> typeList = typeDAO.selectAllTypes();
        typeList.forEach(type -> System.out.println(type.getTypeName()));
    }

    @Test
    public void getTypeByID()throws SQLException {

    }

    @Test
    public void updateType() throws SQLException{
        Type type = new Type();
        type.setId(1);
        type.setTypeName("");
        type.setTypeCover("");
        typeDAO.updateType(type);
    }
}