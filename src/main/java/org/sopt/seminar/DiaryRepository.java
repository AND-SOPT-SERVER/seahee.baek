package org.sopt.seminar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

//db와 connection을 하는 역할
public class DiaryRepository {
    private final Map<Long, String> storage = new ConcurrentHashMap<>();
    private final AtomicLong numbering = new AtomicLong();

    void save(final Diary diary){
        final long id = numbering.addAndGet(1); //numbering에 1을 추가한 값을 반환하겠다는 의미.

        storage.put(id, diary.getBody());
    }

    void delete(final Long id){
        storage.remove(id);
    }


    List<Diary> findAll() {
        //diary를 담을 자료구조
        final List<Diary> diaryList = new ArrayList<>();

        //저장한 값을 불러오는 반복 구조
        for (long index = 1; index <= numbering.intValue(); index++) {
            final String body = storage.get(index);
            if (body != null) {
                diaryList.add(new Diary(index, body));
            }
        }
        //불러온 자료구조 응답
        return diaryList;
    }

}