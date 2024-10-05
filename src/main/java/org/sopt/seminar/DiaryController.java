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
    final List<String> getList() {
        return null;
    }

    final void post(final String body) {

    }

    final void delete(final String id) {

    }

    final void patch(final String id, final String body) {

    }

    enum Status {
        READY,
        RUNNING,
        FINISHED,
        ERROR,
    }
}