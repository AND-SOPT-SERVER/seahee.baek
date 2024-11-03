package org.sopt.diary.service;

import org.sopt.diary.repository.DiaryScope;
import org.sopt.diary.repository.UserEntity;

import java.time.LocalDateTime;

public class Diary {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime created_at;
    private final DiaryScope scope;
    private final UserEntity user;

    public Diary(long id, String title, String content, LocalDateTime created_at, DiaryScope scope, UserEntity user){
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.scope = scope;
        this.user = user;
    }

    public Diary(long id, String title){
        this.id=id;
        this.title=title;
        this.content=null;
        this.created_at=null;
        this.scope = null;
        this.user = null;
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

    public LocalDateTime getCreated_at(){
        return created_at;
    }

    public UserEntity getUser(){ return user; }

    public DiaryScope getScope() {return scope;}
}
