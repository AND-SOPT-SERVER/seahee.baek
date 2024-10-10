package org.sopt.seminar;
import java.time.LocalDateTime; //시간 관련 연산
import java.time.format.DateTimeFormatter; //시간 관련 형식 포매터

public class DeletedDiary {
    private final Long id;
    private final String body;
    private final LocalDateTime delTime;

    public DeletedDiary(Long id, String body, LocalDateTime delTime){
        this.id = id; this.body = body; this.delTime = delTime;
    }

    public Long getId() {
        return id;
    }

    public final String getBody(){
        return body;
    }

    public String getDelTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String ftime = delTime.format(formatter);
        return ftime;
    }
}
