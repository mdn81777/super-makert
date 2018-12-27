package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Position;

import java.sql.SQLException;
import java.util.List;

public interface PositionDAO {
    /**
     * 新增员工职位
     *
     * @param position
     * @return
     * @throws SQLException
     */
    Long insertPosition(Position position) throws SQLException;

    /**
     * 查询员工职业
     *
     * @return
     * @throws SQLException
     */
    List<Position> selectAllPosition() throws SQLException;

    /**
     * 根据ID删除职位
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int deletePosition(int id) throws SQLException;
}
