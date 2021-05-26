package com.example.app_template_java.core.post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PostService {

    @GET("posts")
    Observable<List<Post>> getPosts();

}
