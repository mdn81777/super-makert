package com.soft1841.sm.dao;

import cn.hutool.db.Entity;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public interface TypeDAO {
    /**
     * 新增商品类别，返回自增主键（Long）
     * @param type
     * @return
     */
    Long insertType(Type type) throws SQLException;
    /**
     * 根据id删除类别
     * @param  id
     * @return
     */
    int deleteTypeById(long id)throws  SQLException;

    /**
     * 查询所有类别
     * @return
     */
    List<Entity> selectAllTypes() throws SQLException;

    /**
     * 根据id查询类别信息
     * @param id
     * @return
     * @throws SQLException
     */
    Entity getTypeByID(int id) throws  SQLException;

    /**
     * 更新类别信息
     * @param id
     * @return
     * @throws SQLException
     */
    int updateTypeById(int id) throws  SQLException;

}
