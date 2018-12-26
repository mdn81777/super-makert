package com.soft1841.sm.service;
/**
 * 职位的业务逻辑接口
 * @author 孟妮
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Position;

import java.util.List;

public interface PositionService {
    /**
     * 新增员工，返回自增主键
     * @param position
     * @return
     */
    Long addPosition(Position position);

    /**
     * 查询所有职位
     * @return
     */
    List<Entity> getAllPosition();

    /**
     * 删除职位
     * @param id
     */
    void deletePosition(int id);

}
