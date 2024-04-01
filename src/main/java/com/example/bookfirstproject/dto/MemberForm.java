package com.example.bookfirstproject.dto;

import com.example.bookfirstproject.entity.Article;
import com.example.bookfirstproject.entity.Member;

public class MemberForm {

    private String email;
    private String password;


    // 전송 받은 제목과 내용을 필드에 저장하는 생성자 추가
    public MemberForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    // 데이터를 잘 받았는지 확인할 toString() 매서드 추가


    public Member toEntity(){
        return new Member(email, password);

    }

}
