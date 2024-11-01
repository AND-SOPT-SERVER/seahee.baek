package org.sopt.diary.api;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.sopt.diary.repository.DiaryScope;
import org.sopt.diary.repository.UserEntity;
import org.sopt.diary.service.Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

//null인 field는 반환하지 않음
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiaryResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private DiaryScope scope;
    private UserEntity user;

    //get /diaries/{id} 를 처리하기 위한 생성자
    public DiaryResponse(Long id, String title, String content, LocalDateTime created_at, DiaryScope scope, UserEntity user){
        this.id = id;
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.scope = scope;
        this.user = user;


    }

    //get /diaries 를 처리하기 위한 생성자
    public DiaryResponse(Long id, String title){
        this.id = id;
        this.title = title;
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public DiaryScope getScope(){
        return scope;
    }

    public UserEntity getUser(){
        return user;
    }

    public LocalDateTime getCreated_at(){
        return created_at;
    }

}
