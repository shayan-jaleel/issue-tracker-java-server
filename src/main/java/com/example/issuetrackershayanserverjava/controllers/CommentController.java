package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.dtos.CommentsPage;
import com.example.issuetrackershayanserverjava.dtos.CommentsPageImpl;
import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    CommentService service;

    //TODO: Should I add project to endpoint?
    @PostMapping("/api/issues/{iid}/users/{uid}/comments")
    public Comment createComment(
            @PathVariable("iid") Long pid,
            @PathVariable("uid") Long uid,
            @RequestBody Comment comment) {
        return service.createComment(pid, uid, comment);
    }

//    @GetMapping("/api/issues/{iid}/comments")
//    public List<Comment> findCommentsForIssue(
//            @PathVariable("iid") Long id){
//        return service.findCommentsForIssue(id);
//    }

    @GetMapping("/api/issues/{iid}/comments")
    public CommentsPage findCommentsForIssue(
            @PathVariable("iid") Long id,
            @RequestParam(defaultValue = "1") Integer pageNum,
//            @RequestParam(defaultValue = "id") String sortBy)
            @RequestParam(defaultValue = "5") Integer pageSize){
                Page<Comment> commentPage = service.findPaginatedCommentsForIssue(id, pageNum-1, pageSize);
                List<Comment> comments = commentPage.getContent();
//                List<Comment> sortedList = comments.stream()
//                        .sorted((Comment a, Comment b) -> (int) (b.getId() - a.getId())).collect(Collectors.toList());
                CommentsPage commentsPage = new CommentsPageImpl(comments, pageNum,
                        commentPage.getTotalPages(), commentPage.getTotalElements(), pageSize);
                return commentsPage;
    }

    @GetMapping("/api/users/{uid}/comments")
    public List<Comment> findCommentsForUser(
            @PathVariable("uid") Long id){
        return service.findCommentsForUser(id);
    }

    @GetMapping("/api/comments")
    public List<Comment> findAllComments() {
        return service.findAllComments();
    }

    @GetMapping("/api/comments/{cid}")
    public Comment findCommentById(
            @PathVariable("cid") Long id) {
        return service.findCommentById(id);
    }

    @DeleteMapping("/api/comments/{cid}")
    public Integer deleteComment(@PathVariable("cid") Long id) {
        return service.deleteComment(id);
    }

    @PutMapping("/api/comments/{cid}")
    public Comment updateComment(
            @PathVariable("cid") Long id,
            @RequestBody Comment comment) {
        return service.updateComment(id, comment);
    }
}
