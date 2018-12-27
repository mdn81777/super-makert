package com.soft1841.sm.service.impl;
/**
 * 职位服务实现类
 * @author 林斌涛
 */

import com.soft1841.sm.dao.PositionDAO;
import com.soft1841.sm.entity.Position;
import com.soft1841.sm.service.PositionService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionServiceImpl implements PositionService {
    private PositionDAO positionDAO = DAOFactory.getPositionDAOInstance();
    @Override
    public Long addPosition(Position position) {
        long result = 0;
        try {
            result = positionDAO.insertPosition(position);
        }catch (SQLException e){
            System.err.println("新增职位出现异常");
        }
        return result;
  }

    @Override
    public List<Position> getAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            positionList = positionDAO.selectAllPosition();
        }catch (SQLException e){
            System.err.println("查询职位出现异常！");
        }
        return positionList;
    }

    @Override
    public void deletePosition(int id) {
        try {
            positionDAO.deletePosition(id);

        }catch (SQLException e){
            System.err.println("删除职位出现异常");
        }

    }
}
