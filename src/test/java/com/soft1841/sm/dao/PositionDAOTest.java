package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Position;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PositionDAOTest {
    private PositionDAO positionDAO = DAOFactory.getPositionDAOInstance();

    @Test
    public void insertPosition() throws SQLException{
        Position position = new Position();
        position.setPosition("");
        System.out.println(positionDAO.insertPosition(position));
    }

    @Test
    public void selectAllPosition() throws SQLException {
        List<Entity> PositionList = positionDAO.selectAllPosition();
        PositionList.forEach(entity -> System.out.println(entity.getStr("name")));
    }
}