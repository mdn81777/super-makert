package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;

public  interface TypeDAO {

   /**
      * 新增商品类别，返回自增主键（Long）
      * @param type
      * @return
      */
   public abstract Long insertType(Type type) throws SQLException;
   /**
     * 根据id删除类别
     * @param  id
     * @return
     */
   public abstract int deleteTypeById(long id)throws  SQLException;

    /**
     * 查询所有类别
     * @return
     */
    public abstract List<Entity> selectAllTypes() throws SQLException;

    /**
     * 根据id查询类别信息
     * @param id
     * @return
     * @throws SQLException
     */
    public abstract Entity getTypeByID(int id) throws  SQLException;

    /**
     *
     * @param type
     * @return
     * @throws SQLException
     */
    public abstract int updateType(Type type) throws  SQLException;

}
