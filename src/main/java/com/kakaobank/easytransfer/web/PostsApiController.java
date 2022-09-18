package com.kakaobank.easytransfer.web;

import com.kakaobank.easytransfer.service.posts.PostsService;
import com.kakaobank.easytransfer.web.dto.PostsListResponseDto;
import com.kakaobank.easytransfer.web.dto.PostsResponseDto;
import com.kakaobank.easytransfer.web.dto.PostsSaveRequestDto;
import com.kakaobank.easytransfer.web.dto.PostsUpdateRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

  private final PostsService postsService;

  @PostMapping("/api/v1/posts")
  public Long save(@RequestBody PostsSaveRequestDto requestDto){
    return postsService.save(requestDto);
  }

  @PutMapping("/api/v1/posts/{id}")
  public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
    return postsService.update(id, requestDto);
  }

  @GetMapping("/api/v1/posts/{id}")
  public PostsResponseDto findById(@PathVariable Long id){
    return postsService.findById(id);
  }

  @DeleteMapping("/api/v1/posts/{id}")
  public Long delete(@PathVariable Long id){
    postsService.delete(id);
    return id;
  }

  @GetMapping("/api/v1/posts/list")
  public List<PostsListResponseDto> findAll() {
    return postsService.findAllDesc();
  }

}
