package com.example.footballapp.models.functionDto;

import com.example.footballapp.models.NewsDto;
import com.example.footballapp.models.status.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class GetNewsDto {


    private List<NewsDto> newsDto;
    private Status.Validation status;
    private String message;
}
