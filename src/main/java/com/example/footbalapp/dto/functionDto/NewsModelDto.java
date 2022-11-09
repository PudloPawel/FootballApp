package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NewsModelDto {

    private Long idNews;
    private NewsDto newsDto;
    private Status.Validation status;
    private String message;

}
