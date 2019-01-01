package com.soft1841.sm.dao;

import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {
    /**
     * 新增会员
     *
     * @param member
     * @return
     * @throws SQLException
     */
    Long insertMember(Member member) throws SQLException;

    /**
     * 删除会员
     *
     * @param memberId
     * @return
     * @throws SQLException
     */
    int deleteMemberByMemberId(long memberId) throws SQLException;

    /**
     * 查询会员
     *
     * @return
     * @throws SQLException
     */
    List<Member> selectAllMember() throws SQLException;

    /**
     * 通过会员id查询
     *
     * @param memberId
     * @return Member
     * @throws SQLException
     */
    Member getMemberByMemberId(long memberId) throws SQLException;

    /**
     * 通过关键词查询会员
     *
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<Member> selectMemberLike(String keywords) throws SQLException;


    /**
     * 更新会员信息
     *
     * @param member
     * @return
     * @throws SQLException
     */
    int updateMember(Member member) throws SQLException;
    /**
     * @param
     * @return
     * @throws SQLException
     */
    int countMember() throws SQLException;


}
