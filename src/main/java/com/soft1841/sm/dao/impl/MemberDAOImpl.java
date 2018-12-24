package com.soft1841.sm.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import com.soft1841.sm.dao.MemberDAO;
import com.soft1841.sm.entity.Member;

import java.sql.SQLException;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public Long insertMember(Member member) throws SQLException {
        return Db.use().insertForGeneratedKey(
                Entity.create("t_member")
                        .set("member_id", member.getMemberId())
                        .set("member_name", member.getName())
                        .set("member_address", member.getAddress())
                        .set("member_phone", member.getPhone())
                        .set("member_integral", member.getIntegral())
        );
    }

    @Override
    public int deleteMemberByMemberId(long memberId) throws SQLException {
        return Db.use().del(
                Entity.create("t_member").set("member_Id",memberId)
        );
    }

    @Override
    public List<Entity> selectAllMember() throws SQLException {
        return Db.use().query("SELECT * FROM t_member");
    }

    @Override
    public Entity getMemberByMemberId(long memberId) throws SQLException {
        return Db.use().queryOne("SELECT * FROM t_member WHERE member_id = ?",memberId);
    }

    @Override
    public List<Entity> selectMemberLike(String keywords) throws SQLException {
        return Db.use().findLike("t_member", "member_name,", keywords, Condition.LikeType.Contains);
    }

    @Override
    public int updateMember(Member member) throws SQLException {
        return Db.use().update(
                Entity.create().set("member_address", member.getAddress())
                        .set("member_phone", member.getPhone()),
                Entity.create("t_member").set("member_name", member.getMemberId())
        );

    }
}
