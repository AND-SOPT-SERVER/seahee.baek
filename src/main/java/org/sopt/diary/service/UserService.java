package org.sopt.diary.service;

import org.sopt.diary.api.UsersRequest;
import org.sopt.diary.repository.UsersEntity;
import org.sopt.diary.repository.UsersRepository;

import java.util.Objects;
import java.util.Optional;

public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(String name, String password, String nickname, String email){
        usersRepository.save(new UsersEntity(name, password, nickname, email));
    }

    public Optional<Long> login(String email, String password){
        Optional<UsersEntity> user = usersRepository.findUser(email);
        // == 대신 'equals' 사용하기
        if (user.isPresent() && Objects.equals(user.get().getPassword(), password)){
            return Optional.of(user.get().getId());
        }
        else{
            //예외 설정하기
        }
    }
}
