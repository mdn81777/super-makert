package com.soft1841.sm.dao.impl;
/**
 * 实现类别类
 *
 * @author 孟妮
 */

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAOImpl implements TypeDAO {
    @Override
    public Long insertType(Type type) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_type")
                        .set("type_name", type.getTypeName())
                        .set("type_cover", type.getTypeCover())
        );
    }

    @Override
    public int deleteTypeById(long id) throws SQLException {
        return Db.use().del(Entity.create("t_type").set("id", id));
    }

    @Override
    public List<Type> selectAllTypes() throws SQLException {
        List<Entity> entityList = Db.use().query("SELECT * FROM t_type");
        List<Type> typeList = new ArrayList<>();
        for (Entity entity : entityList) {
            typeList.add(convertType(entity));
        }
        return typeList;
    }

    @Override
    public Type getTypeByID(int id) throws SQLException {
        Entity entity = Db.use().queryOne("SELECT * FROM t_type WHERE id = ?", id);
        return convertType(entity);
    }

    @Override
    public int updateType(Type type) throws SQLException {
        return Db.use().update(
                Entity.create().set("type_name", type.getTypeName())
                        .set("type_cover", type.getTypeCover()),
                Entity.create("t_type").set("id", type.getId())
        );
    }

    private Type convertType(Entity entity) {
        Type type = new Type();
        type.setId(entity.getLong("id"));
        type.setTypeName(entity.getStr("type_name"));
        type.setTypeCover(entity.getStr("type_cover"));
        return type;
    }
}
