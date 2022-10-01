package com.example.footbalapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "NEWS")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NEWS")
    private Long id;

    @Column(name = "TOPIC_NEWS")
    private String topicNews;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "DATE_NEWS")
    private String date;

    public NewsEntity(String topicNews, String text, String author, String date) {
        this.topicNews = topicNews;
        this.text = text;
        this.author = author;
        this.date = date;
    }
}
