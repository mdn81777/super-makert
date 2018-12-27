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
        member.setId(223);
        member.setName("hkbk");
        member.setAddress("vjgh");
        member.setPhone("gjvbn");
        member.setIntegral(1);
        System.out.println(memberDAO.insertMember(member));
    }

    @Test
    public void deleteMember() throws SQLException {
        memberDAO.deleteMemberByMemberId(1);
    }

    @Test
    public void selectAllMember() throws SQLException {
        List<Member> memberList = memberDAO.selectAllMember();
        memberList.forEach(member -> System.out.println(member));
    }

    @Test
    public void getMemberByMemberId() throws SQLException {
    }

    @Test
    public void selectMemberLike() throws SQLException {
        List<Member> memberList = memberDAO.selectMemberLike("李");
        memberList.forEach(member -> System.out.println(member.getName()));
    }
}
