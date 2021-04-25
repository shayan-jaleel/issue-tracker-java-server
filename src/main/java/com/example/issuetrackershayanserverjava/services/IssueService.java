package com.example.issuetrackershayanserverjava.services;

import com.example.issuetrackershayanserverjava.models.Issue;
import com.example.issuetrackershayanserverjava.models.Project;
import com.example.issuetrackershayanserverjava.repositories.IssueRepository;
import com.example.issuetrackershayanserverjava.repositories.ProjectRepository;
import com.example.issuetrackershayanserverjava.repositories.UserIssues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Service
public class IssueService {
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    // implement CRUD operations
    public Issue createIssueForProject(Long pid, Issue issue) {
        Project project = projectRepository.findById(pid).get();
        issue.setProject(project);
        return issueRepository.save(issue);
    }
    //Should this be implemented here?
    public List<Issue> findIssuesForProject(Long pid){
        Project project = projectRepository.findById(pid).get();
        return project.getIssues();
    }
    public List<Issue> findAllIssues() {
        return (List<Issue>)issueRepository.findAll();
    }
    public Issue findIssueById(Long id) {
        //TODO: See about isPresent()
        return issueRepository.findById(id).get();
    }
    public Integer updateIssue(Long id, Issue newIssue) {
        Issue originalIssue = findIssueById(id);
        originalIssue.setDescription(newIssue.getDescription());
        originalIssue.setPriority(newIssue.getPriority());
        originalIssue.setStatus(newIssue.getStatus());
        originalIssue.setType(newIssue.getType());
        //TODO:set comments?
//        originalIssue.setProject(newIssue.getProject());
        issueRepository.save(originalIssue);
        return 1;
    }
    public List<UserIssues> findIssueForUser(Long userId){
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Query query = entityManager.createQuery("SELECT\n" +
//                "    users.id as 'user_id',\n" +
//                "    users.username as 'username',\n" +
//                "    projects.id as 'project_id',\n" +
//                "    issues.id as 'issue_id',\n" +
//                "    issues.description as 'description',\n" +
//                "    issues.priority as 'priority',\n" +
//                "    issues.status as 'status'\n" +
//                "    FROM User users\n" +
//                "    left join project_users\n" +
//                "    on users.id = project_users.user_id\n" +
//                "    left join projects\n" +
//                "    on project_users.project_id = projects.id\n" +
//                "    left join issues\n" +
//                "    on projects.id = issues.project_id\n" +
//                "    where\n" +
//                "    users.id = :uid");
        List<UserIssues> returnedList = issueRepository.findIssuesForUser(userId);
        return returnedList;
    }
    public Project findProjectForIssue(Long id){
        Issue issue = issueRepository.findById(id).get();
        return issue.getProject();
    }
    public Integer deleteIssue(Long id) {
        issueRepository.deleteById(id);
        return 1;
    }
}