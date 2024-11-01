package org.sopt.diary.repository;
import jakarta.persistence.*;

@Entity
@Table(name="user")
public class UserEntity {

    public UserEntity(){
        //기본생성자
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String name;

    @Column
    public String password;

    @Column
    public String nickname;

    @Column(unique = true)
    public String email;

    public UserEntity(String name, String password, String nickname, String email){
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public String getPassword(){
        return password;
    }

    public String getNickname(){
        return nickname;
    }

    public String getEmail(){
        return email;
    }
}
