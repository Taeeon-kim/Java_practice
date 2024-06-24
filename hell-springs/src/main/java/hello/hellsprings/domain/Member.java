package hello.hellsprings.domain;

import jakarta.persistence.*;

@Entity // NOTE: JPA가 관리하는 Entity
public class Member {

    @Id // NOTE: pk 만들기
    @GeneratedValue(strategy = GenerationType.IDENTITY) // NOTE: identity 전략
    private Long id;

//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
