package com.soft1841.sm.dao;

/**
 * 会员测试
 * @author蔡一帆
 */

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class MemberDAOTest {
    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();

    @Test
    public void insertMember() throws SQLException {
        Member member = new Member();
        member.setId("");
        member.setName("");
        member.setAddress("");
        member.setPhone("");
        member.setIntegral(1);
        System.out.println(memberDAO.insertMember(member));
    }

    @Test
    public void deleteMember() throws SQLException {
    memberDAO.deleteMemberByMemberId(1);
    }

    @Test
    public void selectAllMember() throws SQLException {
        List<Entity> MemberList = memberDAO.selectAllMember();
        MemberList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void getMemberByMemberId()throws SQLException  {
        Entity entity = memberDAO.getMemberByMemberId(1);
        System.out.println(entity);
    }

    @Test
    public void selectMemberLike() throws SQLException{
        List<Entity> memberList = memberDAO.selectMemberLike("");
        memberList.forEach(entity -> System.out.println(entity.getStr("name")));
    }

    @Test
    public void updateMember() throws SQLException{
        Member member = new Member();
        member.setName("");
        member.setAddress("");
        member.setPhone("");
        memberDAO.updateMember(member);
    }
}