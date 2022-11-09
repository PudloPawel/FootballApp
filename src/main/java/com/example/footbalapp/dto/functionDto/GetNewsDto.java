package com.example.footbalapp.dto.functionDto;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.status.Status;
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
