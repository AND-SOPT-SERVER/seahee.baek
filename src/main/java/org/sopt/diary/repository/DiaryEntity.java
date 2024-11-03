//db에 있는 것을 클래스로 매칭시켜주는

package org.sopt.diary.repository;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="diary_jpa_entity")
public class DiaryEntity {

    @Id
    @Column(name = "diary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name="diary_title")
    public String title;

    @Column
    public String content;

    @Column
    public LocalDateTime created_at;

    //@Column
    //public Boolean isPrivate;

    @Column
    @Enumerated(value = EnumType.STRING)
    public DiaryScope scope;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public UserEntity user;

    public DiaryEntity() {

    }

    public DiaryEntity(String title, String content, LocalDateTime created_at, DiaryScope scope, UserEntity user) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.scope = scope;
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

    public LocalDateTime getCreated_at(){
        return created_at;
    }

    public DiaryScope getScope(){ return scope; }

    public UserEntity getUser(){ return user; }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setScope(DiaryScope scope){ this.scope = scope; }

    public void setUser(UserEntity user){ this.user = user; }
}
