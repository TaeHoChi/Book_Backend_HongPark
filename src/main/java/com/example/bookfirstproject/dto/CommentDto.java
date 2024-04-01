package com.example.bookfirstproject.dto;

import com.example.bookfirstproject.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {

    private Long id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {

        return new CommentDto(
                // 댓글 엔티티의 id
                comment.getId(),
                // 댓글 엔티티가 속한 부모 게시글의 id
                comment.getArticle().getId(),
                // 댓글 엔티티의 nickname
                comment.getNickname(),
                // 댓글 엔티티의 body
                comment.getBody()
        );

    }



}
