package com.cleverwildcard.aboutme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String comment;

    public Comment() {}

    public Comment(String author, String comment) {
        this.author = author;
        this.comment = comment;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
//    void setId() {
//
//    }
//    Long getId() {
//        return id;
//    }
}
