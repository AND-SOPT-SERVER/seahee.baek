package org.sopt.week3;

import jakarta.persistence.*;

//@Entity : '해당 클래스를 데이터베이스 테이블과 바인딩하겠다.'
//@Table : '해당 클래스를 어떤 테이블과 매핑하겠다.' 여기서는 sopt_member table
@Entity
@Table(name = "sopt_member")
public class SoptMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    public SoptMemberEntity(String name, int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public SoptMemberEntity(){
    }
}
