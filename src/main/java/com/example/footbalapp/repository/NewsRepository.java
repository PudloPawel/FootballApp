package com.example.footbalapp.repository;

import com.example.footbalapp.entity.NewsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<NewsEntity,Long> {

    @Query("SELECT nm FROM NewsEntity as nm WHERE nm.topicNews=:topic" +
            " AND nm.text=:text " +
            " AND nm.author=:author ")
    NewsEntity checkDataInBase(@Param("topic") String topic,@Param("text")  String text,@Param("author")  String author);

    @Query("SELECT n.id FROM NewsEntity AS n " +
            "WHERE n.topicNews=:topic " +
            "AND n.text=:text " +
            "AND n.author=:author " +
            "AND n.date=:date")
    Long getIdNews(@Param("topic") String topic,
                     @Param("text") String text,
                     @Param("author") String author,
                     @Param("date") String date);

}
