package com.soft1841.sm.service.impl;

import cn.hutool.db.Entity;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;
import com.soft1841.sm.service.MemberService;
import com.soft1841.sm.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberServiceImpl implements MemberService {
    private MemberDAO memberDAO = DAOFactory.getMemberDAOInstance();

    @Override
    public Long addMember(Member member) {
        long result = 0;
        try {
            result = memberDAO.insertMember(member);
        } catch (SQLException e) {
            System.err.println("新增会员信息出现异常");
        }
        return result;
    }

    @Override
    public void deleteMember(long memberId) {
        try {
            memberDAO.deleteMemberByMemberId(memberId);
        } catch (SQLException e) {
            System.err.println("删除会员信息出现异常");
        }

    }

    @Override
    public List<Member> getAllMember() {
        List<Member> memberList = new ArrayList<>();
        try {
            memberList = memberDAO.selectAllMember();
        } catch (SQLException e) {
            System.err.println("查询所有会员信息出现异常");
        }
        return memberList;
    }

    @Override
    public Member getMember(long memberId) {
        Member member = new Member();
        try {
            member = memberDAO.getMemberByMemberId(memberId);
        } catch (SQLException e) {
            System.err.println("根据id查询会员信息");
        }
        return member;
    }


    @Override
    public List<Member> getMemberLike(String keywords) {
        List<Member> memberList = new ArrayList<>();
        try {
            memberList = memberDAO.selectMemberLike(keywords);
        } catch (SQLException e) {
            System.err.println("根据关键字查询会员信息出现异常");
        }
        return memberList;
    }
}
