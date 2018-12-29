package com.soft1841.sm.service;

import com.soft1841.sm.entity.Member;
import com.soft1841.sm.entity.Type;
import com.soft1841.sm.utils.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MemberServiceTest {
    private MemberService memberService = ServiceFactory.getMemberServiceInstance();

    @Test
    public void addMember() {
        Member member = new Member();
        member.setId(223);
        member.setName("");
        member.setAddress("");
        member.setPhone("");
        member.setIntegral(1);
        memberService.addMember(member);
    }

    @Test
    public void deleteMember() {
        memberService.deleteMember(7);
    }

    @Test
    public void getAllMember() {
        List<Member> memberList = memberService.getAllMember();
        memberList.forEach(member -> System.out.println(member));
    }

    @Test
    public void getMember() {
        System.out.println(memberService.getAllMember());
    }

    @Test
    public void getMemberLike() {
        List<Member> memberList = memberService.getMemberLike("");
        memberList.forEach(member -> System.out.println(member.getName()));
    }
}