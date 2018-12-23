package com.soft1841.sm.dao;

import cn.hutool.db.Entity;

import javax.xml.soap.Detail;
import java.sql.SQLException;
import java.util.List;

public interface DetailDAO {
    /**
     * 新增收银明细，返回自增主键
     * @param detail
     * @return
     * @throws SQLException
     */
    Long insertDetail(Detail detail) throws SQLException;

    /**
     * 查询所有收银明细
     * @return
     * @throws SQLException
     */
    List<Entity> selectAllDetail() throws SQLException;
}
