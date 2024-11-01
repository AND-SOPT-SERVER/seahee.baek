package org.sopt.diary.api;

import org.sopt.diary.repository.UserEntity;

public class DiaryRequest {

    private String title;
    private String content;
    private Boolean isPrivate;
    private UserEntity user;

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public Boolean getIsPrivate(){ return isPrivate; }

    public UserEntity getUser(){ return user; }

}
