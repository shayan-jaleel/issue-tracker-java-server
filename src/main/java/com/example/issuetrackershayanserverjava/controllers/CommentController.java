package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.dtos.ItemsPage;
import com.example.issuetrackershayanserverjava.dtos.CommentsPage;
import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/issues/{iid}/comments")
    public ItemsPage findCommentsForIssue(
            @PathVariable("iid") Long id,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "desc") String sortDir) {
        Page<Comment> commentPage = service.findPaginatedSortedCommentsForIssue(id, pageNum - 1,
                pageSize, sortField, sortDir);
        List<Comment> comments = commentPage.getContent();
        ItemsPage commentsPage = new CommentsPage(comments, pageNum,
                commentPage.getTotalPages(), commentPage.getTotalElements(), pageSize);
        return commentsPage;
    }

    @GetMapping("/api/users/{uid}/comments")
    public List<Comment> findCommentsForUser(
            @PathVariable("uid") Long id) {
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
