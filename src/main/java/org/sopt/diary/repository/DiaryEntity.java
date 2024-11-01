//db에 있는 것을 클래스로 매칭시켜주는

package org.sopt.diary.repository;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="diary")
public class DiaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String title;

    @Column
    public String content;

    @Column
    public LocalDate created_at;

    @Column
    public Boolean isPrivate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public DiaryEntity() {

    }

    public DiaryEntity(String title, String content, LocalDate created_at, Boolean isPrivate, UserEntity user) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.isPrivate = isPrivate;
        this.user = user;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public Long getId(){
        return this.id;
    }

    public LocalDate getCreated_at(){
        return created_at;
    }

    public Boolean getIsPrivate(){ return isPrivate; }

    public UserEntity getUser(){ return user; }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }
}
