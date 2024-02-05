package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemeberRepositoy repositoy = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repositoy.save(member);
        Member result = repositoy.findById(member.getId()).get();
        Assertions.assertEquals(result,member);
    }

    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");
        repositoy.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repositoy.save(member2);

        // when
        Member result = repositoy.findById(member1.getId()).orElse(null);

        // then
        assertThat(result).isEqualTo(member1);

    }

}
