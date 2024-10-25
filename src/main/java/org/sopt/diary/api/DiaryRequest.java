package org.sopt.diary.api;

public class DiaryRequest {

    private String title;
    private String content;

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public void setDiary(String title, String content){
        this.title = title;
        this.content = content;
    }
}
