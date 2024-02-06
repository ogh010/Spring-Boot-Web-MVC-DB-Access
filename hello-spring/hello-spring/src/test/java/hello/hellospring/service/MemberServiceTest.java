package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



// 테스트는 한글로 적어도 됨
class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //given 뭔가 주어졌는데
        Member member = new Member();
        member.setName("hello");

        //when 이거를 실행했을때
//        Long saveId = memberService.join(member);
//
//        //then 결과가 이게 나와야함
//        Member findMember = memberService.findOne(saveId).get();
//        memberService.findOne(saveId)
//        Assertions.assertThat()

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}