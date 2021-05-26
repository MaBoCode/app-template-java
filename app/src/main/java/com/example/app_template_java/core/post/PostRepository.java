package com.example.app_template_java.core.post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class PostRepository {

    @Inject
    protected PostService postService;

    public Observable<List<Post>> getPosts() {
        return postService.getPosts();
    }
}
