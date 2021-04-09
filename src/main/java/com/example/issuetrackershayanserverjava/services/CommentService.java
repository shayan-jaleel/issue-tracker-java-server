package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.repositories.CommentRepository;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    IssueRepository issueRepository;

    // implement CRUD operations
    public Comment createCommentForIssue(Long iid, Comment comment) {
        Issue issue = issueRepository.findById(iid).get();
        comment.setIssue(issue);
        return commentRepository.save(comment);
    }

    public List<Comment> findCommentsForIssue(Long iid){
        Issue issue = issueRepository.findById(iid).get();
        return issue.getComments();
    }
    public List<Comment> findAllComments() {
        return (List<Comment>)commentRepository.findAll();
    }
    public Comment findCommentById(Long id) {
        //TODO: See about isPresent()
        return commentRepository.findById(id).get();
    }
    public Integer updateComment(Long id, Comment newComment) {
        Comment originalComment = findCommentById(id);
        originalComment.setText(newComment.getText());
        commentRepository.save(originalComment);
        return 1;
    }
    public Issue findIssueForComment(Long id){
        Comment comment = commentRepository.findById(id).get();
        return comment.getIssue();
    }
    public Integer deleteComment(Long id) {
        commentRepository.deleteById(id);
        return 1;
    }
}
