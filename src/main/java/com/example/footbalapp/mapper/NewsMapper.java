package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.functionDto.AddNewsDto;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.NewsEntity;
import com.example.footbalapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {

    @Autowired
    private final NewsRepository newsRepository;

    public NewsMapper(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public AddNewsDto addNews(NewsDto newsDto) {

        try {

            String topic = newsDto.getTopicNews();
            String text = newsDto.getText();
            String author = newsDto.getAuthor();
            String date = newsDto.getDateNews();

            if(topic == null || text == null || author == null || date == null) return AddNewsDto.builder()
                    .status(Status.Validation.FAILED)
                    .message("Null data in dto model. Please check date")
                    .build();

            if(topic.equals("") || author.equals("") || date.equals("")){
               return AddNewsDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Please send full model Dto. Send data: Topic: %s Author: %s Date: %s",topic,author,date))
                        .build();
            }

            NewsEntity checkData = this.newsRepository.checkDataInBase(topic,text,author);

            if(checkData != null){

                return AddNewsDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("The same post exists in the database")
                        .build();
            }

            try{
                this.newsRepository.save(new NewsEntity(topic,text,author,date));
            }catch (Exception var4){
                return AddNewsDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("Don't add post on DateBase")
                        .build();
            }

            Long idNews = this.newsRepository.getIdNews(topic,text,author,date);

            return AddNewsDto
                    .builder()
                    .idNews(idNews)
                    .newsDto(NewsDto.builder().topicNews(topic).text(text).author(author).dateNews(date).build())
                    .status(Status.Validation.SUCCESSFUL)
                    .message("Add post on DateBase")
                    .build();



        }catch (Exception var4){
            return AddNewsDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }

    }
}
