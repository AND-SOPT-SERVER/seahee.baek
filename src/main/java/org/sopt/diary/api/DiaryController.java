package org.sopt.diary.api;

import org.sopt.diary.service.Diary;
import org.sopt.diary.service.DiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/diaries")
    void post(@RequestBody DiaryRequest diaryRequest) {
        diaryService.createDiary(diaryRequest.getTitle(), diaryRequest.getContent());
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
                new DiaryResponse(diary.getId(), diary.getTitle(), diary.getContent(), diary.getDate())
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

