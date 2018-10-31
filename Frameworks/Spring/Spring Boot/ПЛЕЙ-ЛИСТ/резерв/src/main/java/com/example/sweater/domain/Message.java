package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    public Message(){}
    public Message(String text, String rag) {
        this.text = text;
        this.tag = rag;
    }
    public Integer getId() {
        return id;
    }
    public String getText() {
        return text;
    }
    public String getRag() {
        return tag;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setRag(String rag) {
        this.tag = rag;
    }
}