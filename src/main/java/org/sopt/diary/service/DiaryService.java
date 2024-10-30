//요청을 받아서 처리함.z

package org.sopt.diary.service;

import org.sopt.diary.repository.DiaryEntity;
import org.sopt.diary.repository.DiaryRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository){
        this.diaryRepository = diaryRepository;
    }
    //다이어리를 만드는 처리
    public void createDiary(String title, String content){
        diaryRepository.save(new DiaryEntity(title, content, LocalDate.now()));
    }


    //다이어리 가져옴
    public List<Diary> get10Diaries() {
        final List<DiaryEntity> diaryEntityList = diaryRepository.findAll();

        int size = diaryEntityList.size();
        int startIndex = Math.max(size-10, 0);
        List<DiaryEntity> selectedDiaries = diaryEntityList.subList(startIndex, size);

        return selectedDiaries.stream()
                .map(diaryEntity -> new Diary(diaryEntity.getId(), diaryEntity.getTitle()))
                .toList();
    }

    public Diary getDiary(Long id){
        DiaryEntity diaryEntity = diaryRepository.findById(id).orElseThrow(()-> new RuntimeException("예외1"));
        return new Diary(diaryEntity.getId(), diaryEntity.getTitle(), diaryEntity.getContent(), diaryEntity.getDate());
    }

    public void deleteDiary(Long id){
        diaryRepository.deleteById(id);
    }

    public void updateDiary(Long id, String title, String content){
        if (diaryRepository.existsById(id)){
            DiaryEntity diaryEntity = diaryRepository.findById(id).orElseThrow();
            diaryEntity.setTitle(title);
            diaryEntity.setContent(content);
            diaryRepository.save(diaryEntity);
        }
    }

}
