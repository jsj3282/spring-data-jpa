package com.example.springdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    public void createComment(int likeCount, String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        commentRepository.save(newComment);
    }

    @Test
    public void crud() throws ExecutionException, InterruptedException {

        this.createComment(100, "spring data jpa");
        this.createComment(55, "HIBERNATE SPRING");
        commentRepository.flush();

        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "likeCount"));

        ListenableFuture<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
        System.out.println("========");
        System.out.println("is done?" + future.isDone());

        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }

            @Override
            public void onSuccess(@Nullable List<Comment> result) {
                System.out.println("===== Async ====");
                result.forEach(System.out::println);
                System.out.println(result.size());
            }
        });

        Thread.sleep(5000L);

//        Future<List<Comment>> future = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
//        System.out.println("=============");
//        System.out.println("is done?" + future.isDone());
//
//        List<Comment> comments = future.get();
//        comments.forEach(System.out::println);
//        try (Stream<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest)) {
//            Comment firstComment = comments.findFirst().get();
//            assertThat(firstComment.getLikeCount()).isEqualTo(100);
//        }


//        Page<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("spring", pageRequest);
//        assertThat(comments.getNumberOfElements()).isEqualTo(2);
//        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100);

//        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseOrderByLikeCountDesc("spring");
//        assertThat(comments.size()).isEqualTo(2);
//        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount", 100);


//        List<Comment> comments = commentRepository.findByCommentContainsIgnoreCaseAndLikeCountGreaterThan("Spring", 10);
//        assertThat(comments.size()).isEqualTo(1);

//        Comment comment = new Comment();
//        comment.setComment("Hello Comment");
//        commentRepository.save(comment);
//
//        List<Comment> all = commentRepository.findAll();
//        assertThat(all.size()).isEqualTo(1);
//
//        long count = commentRepository.count();
//        assertThat(count).isEqualTo(1);
//
////        Optional<Comment> byId = commentRepository.findById(100L);
////        assertThat(byId).isEmpty();
////        Comment comment1 = byId.orElseThrow(IllegalArgumentException::new);
//
//        Comment comment1 = commentRepository.findById(100L);
//        if (comment1 == null) {
//            throw new IllegalArgumentException();
//        }
//        List<Comment> comments = commentRepository.findAll();
//        assertThat(comments).isEmpty();
//
//        commentRepository.save(null);


    }

}