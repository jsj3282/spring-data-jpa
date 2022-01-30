package com.example.springdatajpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

//@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
//public interface CommentRepository extends MyRepository<Comment, Long> {
public interface CommentRepository extends JpaRepository<Comment, Long> {
//    //Comment save(Comment comment);
//
//    //List<Comment> findAll();
//
//    @Query(value = "SELECT c FROM Comment AS c", nativeQuery = true)
//    List<Comment> findByCommentContains(String keyword);
//
//    // Paging은 Sorting까지 포함된 개념임
//    Page<Comment> findByLikeGreaterThanAndPostOOrderByCreatedDesc(int likeCount, Post post, Pageable pageable);
//    List<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Sort sort);

//    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);

//    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);
//      Page<Comment> findByCommentContainsIgnoreCase(String Keyword, Pageable pageable);
//      Stream<Comment> findByCommentContainsIgnoreCase(String Keyword, Pageable pageable);

//      @Async
//      Future<List<Comment>> findByCommentContainsIgnoreCase(String Keyword, Pageable pageable);

      @Async
      ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String Keyword, Pageable pageable);

}
