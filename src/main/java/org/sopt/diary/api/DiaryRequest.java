package org.sopt.diary.api;

import org.sopt.diary.repository.DiaryScope;

public class DiaryRequest {

    private String title;
    private String content;
    private DiaryScope scope;
    private Long user_id;

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public DiaryScope getScope(){ return scope; }

    public Long getUser_id(){ return user_id; }

}
