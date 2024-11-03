package org.sopt.diary.service;

import org.sopt.diary.exception.IncorrectPasswordException;
import org.sopt.diary.repository.UserEntity;
import org.sopt.diary.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, String password, String nickname, String email){
        userRepository.save(new UserEntity(name, password, nickname, email));
    }

    public Optional<Long> login(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (user.isPresent() && Objects.equals(user.get().getPassword(), password)) {
            return Optional.of(user.get().getId());
        } else {
            throw new IncorrectPasswordException();
        }
    }

    public Optional<UserEntity> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
