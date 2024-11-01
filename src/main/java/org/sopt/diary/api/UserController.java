package org.sopt.diary.api;

import org.sopt.diary.exception.EmailFormatException;
import org.sopt.diary.exception.IncorrectPasswordException;
import org.sopt.diary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    void post(@RequestBody UserRequest usersRequest){
        userService.createUser(usersRequest.getName(),usersRequest.getPassword(),usersRequest.getNickname(),usersRequest.getEmail());
    }

    @PostMapping("/user/login")

    public ResponseEntity<ApiResponse> login(@RequestBody UserLogInRequest usersLogInRequest) {
        if (!usersLogInRequest.getEmail().contains("@")) {
            throw new EmailFormatException();
        }

        Optional<Long> userIdOptional = userService.login(usersLogInRequest.getEmail(), usersLogInRequest.getPassword());

        if (userIdOptional.isPresent()) {
            Long user_id = userIdOptional.get();
            ApiResponse response = new ApiResponse(200, "로그인되었습니다.", String.valueOf(user_id));
            return ResponseEntity.ok(response);
        } else {
            throw new IncorrectPasswordException();
        }
    }
}
