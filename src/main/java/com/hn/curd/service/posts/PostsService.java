package com.hn.curd.service.posts;

import com.hn.curd.domain.posts.Posts;
import com.hn.curd.domain.posts.PostsRepository;
import com.hn.curd.web.dto.PostsListResponseDto;
import com.hn.curd.web.dto.PostsResponseDto;
import com.hn.curd.web.dto.PostsSaveRequestDto;
import com.hn.curd.web.dto.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository;

  public Long save(PostsSaveRequestDto requestDto){
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id)
                                 .orElseThrow(
                                    () -> new IllegalArgumentException("해당 게시글이 없습니다. id + " + id));
    posts.update(requestDto.getTitle(), requestDto.getContent());
    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id)
                                  .orElseThrow(
                                      () -> new IllegalArgumentException("해당 게시글이 없습니다. id + " + id));
    return new PostsResponseDto(entity);
  }

  public void delete(Long id){
    Posts posts = postsRepository.findById(id)
                                 .orElseThrow(
                                      () -> new IllegalArgumentException("해당 게시글이 없습니다. id + " + id));

    postsRepository.delete(posts);
  }

  @Transactional(readOnly = true)
  public List<PostsListResponseDto> findAllDesc(){
    return postsRepository.findAllByDesc().stream()
                                          .map(PostsListResponseDto::new)
                                          .collect(Collectors.toList());
  }

}
