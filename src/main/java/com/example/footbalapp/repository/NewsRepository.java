package com.example.footbalapp.repository;

import com.example.footbalapp.entity.NewsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<NewsEntity,Long> {

    @Query("SELECT nm FROM NewsEntity as nm WHERE nm.topicNews=:topic" +
            " AND nm.text=:text " +
            " AND nm.author=:author ")
    NewsEntity checkDataInBase(String topic, String text, String author);
}
