package org.sopt.diary.api;

import org.sopt.diary.repository.UserEntity;
import org.sopt.diary.service.Diary;
import org.sopt.diary.service.DiaryService;
import org.sopt.diary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sopt.diary.exception.DiaryLengthException;

import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;
    private final UserService userService;

    public DiaryController(DiaryService diaryService, UserService userService) {
        this.diaryService = diaryService;
        this.userService = userService;
    }

    @PostMapping("/diaries")
    void post(@RequestBody DiaryRequest diaryRequest) {
            if (diaryRequest.getContent().length() > 30) {
                throw new DiaryLengthException();
            }
            else {
                UserEntity user = userService.findUserById(diaryRequest.getUser_id())
                                .orElseThrow(()-> new RuntimeException("일치하는 유저가 없습니다."));
                diaryService.createDiary(diaryRequest.getTitle(), diaryRequest.getContent(), diaryRequest.getScope(), user);
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
    public void updateDiary(@PathVariable Long id, @RequestBody DiaryRequest diaryRequest){
        diaryService.updateDiary(id, diaryRequest.getTitle(), diaryRequest.getContent());
    }

    @DeleteMapping("/diaries/{id}")
    public void delete(@PathVariable Long id){
        diaryService.deleteDiary(id);
    }

}

