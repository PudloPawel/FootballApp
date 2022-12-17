package com.example.footballapp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NewsDto {

    private String topicNews;
    private String text;
    private String dateNews;
    private String author;

}
