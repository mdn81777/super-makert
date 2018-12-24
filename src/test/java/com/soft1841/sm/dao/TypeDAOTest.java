package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
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
        List<Entity> TypesList =typeDAO.selectAllTypes();
        TypesList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getTypeByID()throws SQLException {
        Entity entity = typeDAO.getTypeByID(1);
        System.out.println(entity);
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