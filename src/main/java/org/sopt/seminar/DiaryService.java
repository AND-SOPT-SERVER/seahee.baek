package org.sopt.seminar;
//메서드를 만드는 곳!
import org.sopt.seminar.DiaryRepository;

import java.util.List;

public class DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepository();

    void writeDiary(final String body) {
        final Diary diary = new Diary(null, body); //요청을 다이어리 만들어서 저장.
        diaryRepository.save(diary); //레파지토리에 넘겨줌
    }

    List<Diary> getDiaryList() {
        return diaryRepository.findAll();
    }

    void deleteDiary(Long id){
        diaryRepository.delete(id);
    }
}
