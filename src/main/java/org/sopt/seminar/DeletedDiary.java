package org.sopt.seminar;
import java.time.LocalDateTime; //시간 관련 연산

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

    public final LocalDateTime getDelTime() { return delTime; }

}
