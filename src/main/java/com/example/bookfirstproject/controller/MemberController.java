package com.example.bookfirstproject.controller;

import com.example.bookfirstproject.dto.MemberForm;
import com.example.bookfirstproject.entity.Member;
import com.example.bookfirstproject.repository.MemberReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberReository memberReository;

    @GetMapping("/signup")
    public String newMemberForm(){
        return "member/new";
    }

    @PostMapping("/join")
    public String createMember(MemberForm form){
        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();

        // 2. 리파지터리로 엔티티를 DB에 저장
        Member saved = memberReository.save(member);

        return "";
    }

}
