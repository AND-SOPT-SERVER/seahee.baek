package org.sopt.diary.api;

import org.sopt.diary.exception.UnauthorizatedException;
import org.sopt.diary.repository.DiaryRepository;
import org.sopt.diary.repository.UserEntity;
import org.sopt.diary.service.Diary;
import org.sopt.diary.service.DiaryService;
import org.sopt.diary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sopt.diary.exception.DiaryLengthException;

import java.util.List;
import java.util.Objects;

@RestController
public class DiaryController {

    private final DiaryService diaryService;
    private final UserService userService;

    public DiaryController(DiaryService diaryService, UserService userService) {
        this.diaryService = diaryService;
        this.userService = userService;
    }

    @PostMapping("/diaries")
    public ResponseEntity<ApiResponse>  post(@RequestHeader("user_id") String user_id, @RequestBody DiaryRequest diaryRequest) {

            if (diaryRequest.getTitle().length() > 15) {
                throw new DiaryLengthException(true);
            }
            else if(diaryRequest.getContent().length()>30){
                throw new DiaryLengthException(false);
            }
            else {

                Long writer_id = diaryRequest.getUser_id();
                UserEntity user = userService.findUserById(writer_id)
                                .orElseThrow(()-> new RuntimeException("일치하는 유저가 없습니다."));
                diaryService.createDiary(diaryRequest.getTitle(), diaryRequest.getContent(), diaryRequest.getScope(), user);

                ApiResponse response = new ApiResponse(201, "일기 작성 완료", null);
                return ResponseEntity.ok(response);
            }

    }

    @GetMapping("/diaries")
    public ResponseEntity<List<DiaryResponse>> get10Diaries() {
        return ResponseEntity.ok(
                diaryService.get10Diaries().stream()
                        .map(diary -> new DiaryResponse(diary.getId(), diary.getTitle()))
                        .toList()
        );
    }

    @GetMapping("/diaries/{id}")
    public ResponseEntity<DiaryResponse> get(@PathVariable Long id){
        Diary diary = diaryService.getDiary(id);

        return ResponseEntity.ok(
                new DiaryResponse(diary.getId(), diary.getTitle(), diary.getContent(), diary.getCreated_at(), diary.getScope(), diary.getUser())
        );
    }


    @PatchMapping("/diaries/{id}")
    public void updateDiary(@RequestHeader("user_id") String user_id, @PathVariable Long id, @RequestBody DiaryRequest diaryRequest){

        Diary diary = diaryService.getDiary(id);

        if (!diary.getUser().getId().equals(Long.valueOf(user_id))){
            throw new UnauthorizatedException();
        }
        else{
            diaryService.updateDiary(id, diaryRequest.getTitle(), diaryRequest.getContent(), diaryRequest.getScope());
        }
    }

    @DeleteMapping("/diaries/{id}")
    public void delete(@RequestHeader("user_id") String user_id, @PathVariable Long id){
        Diary diary = diaryService.getDiary(id);

        if (!diary.getUser().getId().equals(Long.valueOf(user_id))){
            throw new UnauthorizatedException();
        }
        else{
            diaryService.deleteDiary(id);
        }
    }

}

