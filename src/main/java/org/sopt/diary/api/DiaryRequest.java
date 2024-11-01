package org.sopt.diary.api;

import org.sopt.diary.repository.UsersEntity;

public class DiaryRequest {

    private String title;
    private String content;
    private Boolean isPrivate;
    private UsersEntity user;

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public Boolean getIsPrivate(){ return isPrivate; }

    public UsersEntity getUser(){ return user; }

}
