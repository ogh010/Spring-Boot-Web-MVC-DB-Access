package hello.hellospring.domain;

public class Member {
    private Long id;
    private String name;


    // commane+enter 로 게터 세터 만들깅
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
