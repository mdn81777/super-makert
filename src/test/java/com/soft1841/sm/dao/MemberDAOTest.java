package com.soft1841.sm.dao;


import cn.hutool.db.Entity;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class MemberDAOTest {
    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();

    @Test
    public void insertMember() {
    }

    @Test
    public void deleteMember() {
    }

    @Test
    public void selectAllMember() throws SQLException {
        List<Entity> MemberList = memberDAO.selectAllMember();
        MemberList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getMemberByMemberId() {
    }

    @Test
    public void selectMemberLike() {
    }

    @Test
    public void updateMember() {
    }
}