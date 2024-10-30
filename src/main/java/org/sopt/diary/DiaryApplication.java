//스프링부트를 띄우는 것을 시작하는 시작점 역할.
//자바 실행. 여기서 역할은 끝!!

package org.sopt.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiaryApplication.class, args);
        //실행버튼 누르고 제대로 실행되면 tomcat과 bean들이 띄워진 상태. 요청을 받을 수 있는 상태임.
    }
}
