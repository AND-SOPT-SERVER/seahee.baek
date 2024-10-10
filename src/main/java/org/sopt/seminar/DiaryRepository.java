package org.sopt.seminar;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.sopt.seminar.DeletedDiary;
import java.time.LocalDateTime;

//db와 connection을 하는 역할
public class DiaryRepository {
    private final Map<Long, String> storage = new ConcurrentHashMap<>();
    private final Map<Long, DeletedDiary> delStorage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    void save(final Diary diary){
        final long id = numbering.addAndGet(1); //numbering에 1을 추가한 값을 반환하겠다는 의미.

        storage.put(id, diary.getBody());
    }

    void del(final Long id){
        String body = storage.remove(id);
        delStorage.put(id, new DeletedDiary(id, body, LocalDateTime.now()));
    }

    void mod(Long id, String body){
        if(storage.get(id)==null){
            System.out.println("잘못된 요청입니다!!");
        } else {
            storage.put(id, body);
        }
    }

    void rest(Long id){
        DeletedDiary deletedDiary = delStorage.remove(id);
        storage.put(id, deletedDiary.getBody());
    }

    public void expire(){
        LocalDateTime now = LocalDateTime.now(); //현재 시간을 불러오기
        delStorage.entrySet().removeIf(entry -> {
            //entrySet : Map의 모든 항목 Set으로 반환.
            //removeIf : 조건 만족하는(return이 True인) 항목 삭제.
            //entry -> {...} : 람다 표현식.
            DeletedDiary deletedDiary = entry.getValue();
            return deletedDiary.getDelTime().plusDays(2).isBefore(now);
            //deletedDiary 객체의 deltime을 가져오고, 이틀을 더한 시간이 현재 시간보다 전이라면 => 삭제된지 이틀이 지났다면
        });
    }

    List<DeletedDiary> findDelAll() {
        List<DeletedDiary> delDiaryList = new ArrayList<>();
        delStorage.forEach((id, deletedDiary) -> delDiaryList.add(deletedDiary));  // 각 DeletedDiary 객체를 리스트에 추가
        return delDiaryList;
    }


    List<Diary> findAll() {
        List<Diary> diaryList = new ArrayList<>();
        storage.forEach((id, body) -> diaryList.add(new Diary(id, body)));  // storage의 각 항목을 Diary 객체로 변환하여 리스트에 추가
        return diaryList;
    }

}