package org.sopt.diary.api;

public class UsersRequest {

    private String name;
    private String password;
    private String nickname;
    private String email;

    public String getName(){
        return name;
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
