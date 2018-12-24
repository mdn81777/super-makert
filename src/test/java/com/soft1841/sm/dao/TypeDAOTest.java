package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TypeDAOTest {
    private TypeDAO typeDAO = DAOFactory.getTypeDAOInstance();

    @Test
    public void insertType() {
    }

    @Test
    public void deleteTypeById() {
    }

    @Test
    public void selectAllTypes() throws SQLException {
        List<Entity> TypesList =typeDAO.selectAllTypes();
        TypesList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getTypeByID() {
    }

    @Test
    public void updateType() {
    }
}