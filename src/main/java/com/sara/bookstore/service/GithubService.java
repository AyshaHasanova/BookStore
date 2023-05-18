package com.sara.bookstore.service;

import com.sara.bookstore.client.GithubClient;
import com.sara.bookstore.client.model.Topics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubService {
    private final GithubClient githubClient;

    public Topics getGithubTopics(String query){
        return githubClient.getGithubTopics(query);
    }
}
