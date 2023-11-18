package com.example.inflearn.post.domain;

import lombok.Builder;
import lombok.Getter;

/*
파라미터가 한 개 일경우 serialize 에러가 발생한다...
 */
@Getter
public class PostUpdate {

    private final String content;
    private final String test; // dummy

    @Builder
    public PostUpdate(String content, String test) {
        this.content = content;
        this.test = test;
    }

}
