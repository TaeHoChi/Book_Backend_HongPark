package com.example.bookfirstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@AllArgsConstructor
public class Member {

    @Id
    private String email;

    @Column
    private String password;

//    @Override
//    public String toString() {
//        return "Member{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }

    public Member(){
        super();
    }
//
//    public Member(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
}
