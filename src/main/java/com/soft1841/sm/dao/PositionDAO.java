package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Position;

import javax.swing.text.html.parser.Entity;
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
