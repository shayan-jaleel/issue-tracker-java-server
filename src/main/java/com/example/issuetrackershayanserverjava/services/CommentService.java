package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Comment;
import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.User;
import com.example.issuetrackershayanserverjava.repositories.CommentRepository;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import com.example.issuetrackershayanserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    UserRepository userRepository;

    public Comment createComment(Long iid, Long uid, Comment comment) {
        Issue issue = issueRepository.findById(iid).get();
        comment.setIssue(issue);
        User user = userRepository.findById(uid).get();
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    public List<Comment> findCommentsForIssue(Long iid) {
        Issue issue = issueRepository.findById(iid).get();
        return issue.getComments();
    }

    public Page<Comment> findPaginatedCommentsForIssue(Long iid, int pageNum, int pageSize) {
        Issue issue = issueRepository.findById(iid).get();
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return commentRepository.findByIssue(issue, pageable);
    }

    public Page<Comment> findPaginatedSortedCommentsForIssue(Long iid, int pageNum, int pageSize,
                                                             String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Issue issue = issueRepository.findById(iid).get();
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return commentRepository.findByIssue(issue, pageable);
    }

    public List<Comment> findCommentsForUser(Long uid) {
        User user = userRepository.findById(uid).get();
        return user.getComments();
    }

    public List<Comment> findAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    public Comment findCommentById(Long id) {
        //TODO: See about isPresent()
        return commentRepository.findById(id).get();
    }

    public Comment updateComment(Long id, Comment newComment) {
        Comment originalComment = findCommentById(id);
        originalComment.setText(newComment.getText());
        originalComment.setEdited(true);
        return commentRepository.save(originalComment);
    }

    public Issue findIssueForComment(Long id) {
        Comment comment = commentRepository.findById(id).get();
        return comment.getIssue();
    }

    public User findUserForComment(Long id) {
        Comment comment = commentRepository.findById(id).get();
        return comment.getUser();
    }

    public Integer deleteComment(Long id) {
        commentRepository.deleteById(id);
        return 1;
    }
}
