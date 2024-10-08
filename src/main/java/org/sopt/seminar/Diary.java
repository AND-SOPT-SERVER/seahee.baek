package org.sopt.seminar;

public class Diary {
    private Long id;
    private final String body;

    public Diary(Long id, String body){
        this.id=id;
        this.body=body;
    }

    public Long getId() {
        return id;
    }

    public final String getBody(){
        return body;
    }


}