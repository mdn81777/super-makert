package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.PositionDAO;
import com.soft1841.sm.entity.Position;

import java.sql.SQLException;
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
    public List<Entity> selectAllPosition() throws SQLException {
        return Db.use().query("SELECT * FROM t_position");
    }

    @Override
    public int deletePosition(int id) throws SQLException {
        return Db.use().del(
                Entity.create("t_position").set("id", id)
        );
    }
}
