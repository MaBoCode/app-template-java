package com.example.app_template_java.core.post;

import java.io.Serializable;

public class Post implements Serializable {

    public Long id;
    public Long userId;
    public String title;
    public String body;

    public Post(Long id, Long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
