package com.example.issuetrackershayanserverjava.controllers;

import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    CommentService service;

    //TODO: Should I add project to endpoint?
    @PostMapping("/api/issues/{iid}/comments")
    public Comment createCommentForIssue(
            @PathVariable("iid") Long pid,
            @RequestBody Comment comment) {
        return service.createCommentForIssue(pid, comment);
    }

    @GetMapping("/api/issues/{iid}/comments")
    public List<Comment> findCommentsForIssue(
            @PathVariable("iid") Long id){
        return service.findCommentsForIssue(id);
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
    public Integer updateComment(
            @PathVariable("cid") Long id,
            @RequestBody Comment comment) {
        return service.updateComment(id, comment);
    }
}
