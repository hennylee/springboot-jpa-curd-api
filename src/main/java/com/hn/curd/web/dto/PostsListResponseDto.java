package com.hn.curd.web.dto;

import com.hn.curd.domain.posts.Posts;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PostsListResponseDto {
  private Long id;
  private String title;
  private String author;
  private LocalDateTime modifiedDate;

  public PostsListResponseDto(Posts entitiy){
    this.id = entitiy.getId();
    this.title = entitiy.getTitle();
    this.author = entitiy.getAuthor();
    this.modifiedDate = entitiy.getModifiedDate();
  }
}
