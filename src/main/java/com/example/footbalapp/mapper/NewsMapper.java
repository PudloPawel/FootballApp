package com.example.footbalapp.mapper;

import com.example.footbalapp.dto.NewsDto;
import com.example.footbalapp.dto.functionDto.GetNewsDto;
import com.example.footbalapp.dto.functionDto.NewsModelDto;
import com.example.footbalapp.dto.status.Status;
import com.example.footbalapp.entity.NewsEntity;
import com.example.footbalapp.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Component
public class NewsMapper {

    @Autowired
    private final NewsRepository newsRepository;

    public NewsMapper(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public NewsModelDto addNews(NewsDto newsDto) {

        return addNewsForDataBase(newsDto);

    }

    public NewsModelDto editNews(NewsDto newsDto, Long idNews) {

        NewsModelDto newsModelDto = deleteNewsForDataBase(idNews);

        if(newsModelDto.getStatus() == Status.Validation.FAILED){
            newsModelDto.setMessage(String.format("You don't edit news id: %s because news not exist",idNews));
        }else{
            newsModelDto = addNewsForDataBase(newsDto);
            if(newsModelDto.getStatus() == Status.Validation.FAILED){
                newsModelDto.setMessage(String.format("You don't edit news id: %s",idNews));
            }else{
                newsModelDto.setMessage(String.format("You edit news id: %s",idNews));
            }
        }
        return newsModelDto;

    }

    public NewsModelDto deleteNews(Long idNews){

        return deleteNewsForDataBase(idNews);

    }

    public NewsModelDto getNews(Long idNews) {

        try{

            Optional<NewsEntity> newsEntity = this.newsRepository.findById(idNews);

            String message;
            Status.Validation status;
            NewsDto newsDto;

            if(newsEntity.isPresent()){
                status = Status.Validation.SUCCESSFUL;
                message = "You returned the news";
                newsDto = NewsDto.builder()
                        .topicNews(newsEntity.get().getTopicNews())
                        .text(newsEntity.get().getText())
                        .dateNews(newsEntity.get().getDate())
                        .author(newsEntity.get().getAuthor())
                        .build();
            }else{
                status = Status.Validation.FAILED;
                message = "You not returned the news";
                newsDto = NewsDto.builder().build();
            }

            return NewsModelDto
                    .builder()
                    .idNews(idNews)
                    .newsDto(newsDto)
                    .status(status)
                    .message(message)
                    .build();

        }catch (Exception var4){
            return NewsModelDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }
    }

    private NewsModelDto deleteNewsForDataBase(Long idNews){
        try{

            Optional<NewsEntity> newsEntity = this.newsRepository.findById(idNews);

            if(!newsEntity.isPresent()){
                return NewsModelDto
                        .builder()
                        .idNews(idNews)
                        .status(Status.Validation.FAILED)
                        .message(String.format("News id: %s not exist",idNews))
                        .build();
            }else{
                this.newsRepository.delete(newsEntity.get());
            }

            return NewsModelDto
                    .builder()
                    .idNews(idNews)
                    .status(Status.Validation.SUCCESSFUL)
                    .message(String.format("You delete news id: %s",idNews))
                    .build();

        }catch (Exception var4){
            return NewsModelDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }
    }

    private NewsModelDto addNewsForDataBase(NewsDto newsDto){

        try {

            String topic = newsDto.getTopicNews();
            String text = newsDto.getText();
            String author = newsDto.getAuthor();
            String date = newsDto.getDateNews();

            if(topic == null || text == null || author == null || date == null) return NewsModelDto.builder()
                    .status(Status.Validation.FAILED)
                    .message("Null data in dto model. Please check date")
                    .build();

            if(topic.equals("") || author.equals("") || date.equals("")){
                return NewsModelDto.builder()
                        .status(Status.Validation.FAILED)
                        .message(String.format("Please send full model Dto. Send data: Topic: %s Author: %s Date: %s",topic,author,date))
                        .build();
            }

            NewsEntity checkData = this.newsRepository.checkDataInBase(topic,text,author);

            if(checkData != null){

                return NewsModelDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("The same post exists in the database")
                        .build();
            }

            try{
                this.newsRepository.save(new NewsEntity(topic,text,author,date));
            }catch (Exception var4){
                return NewsModelDto
                        .builder()
                        .status(Status.Validation.FAILED)
                        .message("Don't add post on DateBase")
                        .build();
            }

            Long idNews = this.newsRepository.getIdNews(topic,text,author,date);

            return NewsModelDto
                    .builder()
                    .idNews(idNews)
                    .newsDto(NewsDto.builder().topicNews(topic).text(text).author(author).dateNews(date).build())
                    .status(Status.Validation.SUCCESSFUL)
                    .message("Add post on DateBase")
                    .build();



        }catch (Exception var4){
            return NewsModelDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }

    }


    public GetNewsDto getAllNews() {

        try{

            Iterable<NewsEntity> newsEntity = this.newsRepository.findAll();

            List<NewsDto> newsDto = new ArrayList();

            for (NewsEntity entity : newsEntity) {
                newsDto.add(NewsDto
                        .builder()
                        .topicNews(entity.getTopicNews())
                        .text(entity.getText())
                        .dateNews(entity.getDate())
                        .author(entity.getAuthor())
                        .build());
            }

            return GetNewsDto
                    .builder()
                    .newsDto(newsDto)
                    .message("You return List with all news")
                    .status(Status.Validation.SUCCESSFUL)
                    .build();

        }catch (Exception var4){
            return GetNewsDto
                    .builder()
                    .status(Status.Validation.FAILED)
                    .message(var4.getMessage())
                    .build();
        }

    }
}
