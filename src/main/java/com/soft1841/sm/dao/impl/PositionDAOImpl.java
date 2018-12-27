package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.PositionDAO;
import com.soft1841.sm.entity.Position;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOImpl implements PositionDAO {

    @Override
    public Long insertPosition(Position position) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_position")
                .set("PositionController",position.getPosition())
        );
    }

    @Override
    public List<Position> selectAllPosition() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_position");
        List<Position> positionList = new ArrayList<>();
        for (Entity entity:entityList){
            positionList.add(convertPosition(entity));
        }
        return positionList;
    }

    @Override
    public int deletePosition(int id) throws SQLException {
        return Db.use().del(
                Entity.create("t_position").set("id", id)
        );
    }

    private Position convertPosition(Entity entity){
        Position position = new Position();
        position.setId(entity.getInt("id"));
        position.setPosition(entity.getStr("position"));
        return position;
    }
}
