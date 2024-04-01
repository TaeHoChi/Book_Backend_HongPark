package com.example.bookfirstproject.repository;

import com.example.bookfirstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

// < 안에 관리 대상 엔티티 클래스, 대상 엔티티의 대푯값 타입>
public interface ArticleRepository extends CrudRepository<Article, Long> {

    @Override
    ArrayList<Article> findAll();


}
