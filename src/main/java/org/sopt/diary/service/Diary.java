package org.sopt.diary.service;

import java.time.LocalDate;

public class Diary {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDate date;

    public Diary(long id, String title, String content, LocalDate date){
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = LocalDate.now();
    }

    public Diary(long id, String title){
        this.id=id;
        this.title=title;
        this.content=null;
        this.date=null;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public LocalDate getDate(){
        return date;
    }
}
