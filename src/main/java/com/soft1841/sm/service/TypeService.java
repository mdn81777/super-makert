package com.soft1841.sm.service;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Type;

import java.util.List;

/**
 * 商品类别的业务逻辑接口
 * @author 孟妮
 */
public interface TypeService {
    /**
     * 获取所有类别
     * @return
     */
    List<Type> getAllTypes();

    /**
     * 添加类别
     * @param type
     * @return
     */
    Long addType(Type type);

    /**
     * 删除类别
     * @param id
     */
    void deleteType(long id);

    /**
     * 更新商品信息
     * @param type
     */
    void updateType(Type type);

    /**
     * 根据id查询类别
     * @param id
     * @return
     */
   Type getType(int id);


}
