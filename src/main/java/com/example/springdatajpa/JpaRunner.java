package com.example.springdatajpa;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    PostRepository postRepository;

//    @Autowired
//    SeonJu seonJu;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        postRepository.findAll().forEach(System.out::println);
//        System.out.println("=====================");
//        System.out.println(seonJu.getName());

        Post post = new Post();
        post.setTitle("spring");

        Comment comment = new Comment();
        comment.setComment("hello");

        postRepository.save(post);



//        entityManager.createNamedQuery("all_post", Post.class);

//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);

//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Post> query = builder.createQuery(Post.class);
//        Root<Post> root = query.from(Post.class);
//        query.select(root);
//
//        List<Post> posts = entityManager.createQuery(query).getResultList();
//        posts.forEach(System.out::println);
//
//          List<Post> posts = entityManager.createNativeQuery("select * from Post", Post.class).getResultList();
//          posts.forEach(System.out::println);


//        Account account = new Account();
//        account.setUsername("jsj");
//        account.setPassword("hibernate");
//
//        Study study = new Study();
//        study.setName("Spring Data JPA");
////        study.setOwner(account);
//
////        entityManager.persist(account);
//
////        account.getStudies().add(study);  // optional : ????????????????????? ??????????????? ???????????? ???
////        study.setOwner(account);
//
//        account.addStudy(study);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(account);
//        session.save(study);
//
//        Account jsj = session.load(Account.class, account.getId());
//        jsj.setUsername("jeongseonju");
//        jsj.setUsername("jsj");
//        System.out.println("==========");
//        System.out.println(jsj.getUsername());

//        Post post = new Post();
//        post.setTitle("Spring Data JPA ?????? ??????..");
//
//        Comment comment = new Comment();
//        comment.setComment("?????? ?????? ?????????.");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("??? ??????????????????.");
//        post.addComment(comment1);
//
//        Session session = entityManager.unwrap(Session.class);
//        session.save(post);

//
//        Session session = entityManager.unwrap(Session.class);
//        /*
//            get??? ????????? DB?????? ?????????, load??? ????????? ????????? ????????? ?????? ??????
//         */
//        Post post1 = session.get(Post.class, 1L);
//        System.out.println("=======================");
//        System.out.println(post1.getTitle());
//
//        post1.getComments().forEach(c -> {
//            System.out.println("===============");
//            System.out.println(c.getComment());
//        });

//        Comment comment = session.get(Comment.class, 2L);
//        System.out.println("=================");
//        System.out.println(comment.getComment());
//        System.out.println(comment.getPost().getTitle());

//        Session session = entityManager.unwrap(Session.class);
//        Post post = session.get(Post.class, 1L);
//        session.delete(post);
    }
}
