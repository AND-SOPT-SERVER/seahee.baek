//db에 있는 것을 클래스로 매칭시켜주는

package org.sopt.diary.repository;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String title;

    @Column
    public String content;

    @Column
    public LocalDate date;


    public DiaryEntity() {

    }

    public DiaryEntity(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public long getId(){
        return this.id;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }
}
