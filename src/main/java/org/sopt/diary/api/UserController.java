package org.sopt.diary.api;

import org.sopt.diary.exception.EmailFormatException;
import org.sopt.diary.exception.IncorrectPasswordException;
import org.sopt.diary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    void post(@RequestBody UsersRequest usersRequest){
        userService.createUser(usersRequest.getName(),usersRequest.getPassword(),usersRequest.getNickname(),usersRequest.getEmail());
    }

    @PostMapping("/user/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UsersLogInRequest usersLogInRequest){
        if (!usersLogInRequest.getEmail().contains("@")) {
            throw new EmailFormatException();
        }
        return userService.login(usersLogInRequest.getEmail(), usersLogInRequest.getPassword())
                .map(userId -> {
                    ApiResponse response = new ApiResponse(200, "로그인되었습니다.", userId);
                    return ResponseEntity.ok(response);
                })
                .orElseThrow(IncorrectPasswordException::new);  // 로그인 실패 시 예외 처리
    }
}
