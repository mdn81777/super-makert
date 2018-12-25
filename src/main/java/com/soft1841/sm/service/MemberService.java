package com.soft1841.sm.service;

import com.soft1841.sm.entity.Member;

import java.util.List;

/**
 * 会员的业务逻辑接口
 * @author孟妮
 */

public interface MemberService {
    /**
     * 新增会员，返回自增主键
     * @param member
     * @return
     */
    Long addMember(Member member);

    /**
     * 根据id删除会员
     * @param member
     */
    void deleteMember(Member member);

    /**
     * 查询所有会员
     * @return
     */
    List<Member> getAllMember();

    /**
     * 根据id查询会员
     * @param memberId
     * @return
     */
    Member getMember(long memberId);
    /**
     * 根据关键词模糊查询图书
     * @param keywords
     * @return List<Book>
     */

    List<Member> getMemberLike(String keywords);

}
