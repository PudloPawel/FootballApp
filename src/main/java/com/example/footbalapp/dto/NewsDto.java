package com.example.footbalapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class NewsDto {

    private String topicNews;
    private String text;
    private String dateNews;
    private String author;

}
