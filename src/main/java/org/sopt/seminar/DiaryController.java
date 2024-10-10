package org.sopt.seminar;

import java.util.List;

public class DiaryController {
    private Status status = Status.READY;
    private final DiaryService diaryService = new DiaryService();

    Status getStatus() {
        return status;
    }

    void boot() {
        this.status = Status.RUNNING;
    }

    void finish() {
        this.status = Status.FINISHED;
    }

    // APIS
    final List<Diary> getList() {
        return diaryService.getDiaryList();
    }

    final List<DeletedDiary> getDeletedDiary(){
        return diaryService.getDeletedDiaryList();
    }

    final void post(final String body) {
        diaryService.writeDiary(body);

    }

    final void delete(final String id) {
        diaryService.deleteDiary(Long.parseLong(id));
    }

    final void patch(final String id, final String body) {
        diaryService.modifyDiary(Long.parseLong(id), body);
    }

    final void restore(final String id){
        diaryService.restoreDiary(Long.parseLong(id));
    }

    final void delExpiredDiary(){
        diaryService.delExpiredDiary();
    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}