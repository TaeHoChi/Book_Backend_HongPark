package com.example.bookfirstproject.service;

import com.example.bookfirstproject.dto.ArticleForm;
import com.example.bookfirstproject.entity.Article;
import com.example.bookfirstproject.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository; // 게시글 리파지터리 객체 주입

    public List<Article> index(){
        return articleRepository.findAll();
    };

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. DTO -> 엔티티 변환하기
        Article article = dto.toEntity(); // dto를 에니티로 변환
        log.info("id: {}, article: {}", id, article.toString()); // 로그 찍기

        // 2. 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리하기
        if(target == null || id != article.getId()){ // 잘못된 요청인지 판별
            // 400, 잘못된 요청 응답
            log.info("잘못된 요청! id: {}", id, article.toString()); // 로그 찍기
            return null; // ResponseEntity 반환, 응답은 칸트롤러가 하므로 여기서는 null을 반환한다.
        }

        // 4. 업데이트 및 정상 응답(200)하기
        target.patch(article); // 기존 데이터에 새 데이터 붙이기
        Article updated = articleRepository.save(target); // article 엔티티 DB에 저장, 수정 내용 DB에 최종 저장
        return updated; // 정상 응답, 응답은 컨트롤러가 하므로 여기서는 수정 데이터만 반환한다.
    }

    public Article delete(Long id) {

        // 1. DB에서 대상 엔티티가 있는지 조회하기
        Article target = articleRepository.findById(id).orElse(null);

        // 2. 대상 엔티티가 없어서 요청 자체가 잘못됐을 경우 처리하기
        if(target == null){
            return null;
        }

        // 3. 대상 엔티티가 있으면 삭제하고 정상 응답(200) 반환하기
        articleRepository.delete(target);
        return target;
    }


    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // 1. dto 묶음을 엔티티 묶음으로 변환하기
        List<Article> articlesList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        // 2. 엔티티 묶음을 DB에 저장하기
        articlesList.stream()
                .forEach(article -> articleRepository.save(article));

        // 3. 강제 예외 발생시키기
        // id가 -1인 데이터 찾기
        articleRepository.findById(-1L)
                // 찾는 데이터가 업승면 예외 발생
                .orElseThrow(() -> new IllegalArgumentException("결제 실패 !"));

        // 4. 결과 값 반환하기
        return articlesList;
    }
}
