package com.example.bookfirstproject.dto;

import com.example.bookfirstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // 생성자 자동으로 추가해준다.
@ToString // ToString을 자동으로 추가해준다.
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    // 전송 받은 제목과 내용을 필드에 저장하는 생성자 추가
//    public ArticleForm(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

    // 데이터를 잘 받았는지 확인할 toString() 매서드 추가

//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
    public Article toEntity(){
        return new Article(id, title, content);

    }
}
