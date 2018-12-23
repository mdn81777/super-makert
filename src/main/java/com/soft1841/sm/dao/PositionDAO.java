package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDAO {
    /**
     * 新增员工职位
     * @param position
     * @return
     * @throws SQLException
     */
    Long insertPosition(Position position) throws SQLException;

    /**
     * 查询员工职业
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllPosition() throws SQLException;
}
