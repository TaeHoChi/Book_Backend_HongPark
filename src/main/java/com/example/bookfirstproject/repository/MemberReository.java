package com.example.bookfirstproject.repository;

import com.example.bookfirstproject.entity.Article;
import com.example.bookfirstproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberReository extends CrudRepository<Member, String> {

}
