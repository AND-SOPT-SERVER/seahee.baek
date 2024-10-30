package org.sopt.diary.api;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

//null인 field는 반환하지 않음
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiaryResponse {

    private long id;
    private String title;
    private String content;
    private LocalDate date;

    //get /diaries/{id} 를 처리하기 위한 생성자
    public DiaryResponse(long id, String title, String content, LocalDate date){
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;

    }

    //get /diaries 를 처리하기 위한 생성자
    public DiaryResponse(long id, String title){
        this.id = id;
        this.title = title;
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
