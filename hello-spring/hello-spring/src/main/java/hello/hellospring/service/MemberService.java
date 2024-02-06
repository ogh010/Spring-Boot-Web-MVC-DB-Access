package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemeberRepositoy;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// command + shift + t 테스트 자동으로 생성
@Service
public class MemberService { // 비즈니스적으로 네이밍

    private final MemeberRepositoy memeberRepositoy;

    @Autowired
    public MemberService(MemeberRepositoy memeberRepositoy) {
        this.memeberRepositoy = memeberRepositoy;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        // 비즈니스 로직 : 같은 이름이 있는 중복 회원 x
        validateDuplicateMember(member); // 중복 회원 검증 메서드
        memeberRepositoy.save(member);
        return member.getId();
    }
    //메서드 컨트롤 + t
    private void validateDuplicateMember(Member member) {
        memeberRepositoy.findByName(member.getName())
            .ifPresent(m ->{
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }


    // command + enter 주석 자동 생성
    /**
     *
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memeberRepositoy.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memeberRepositoy.findById(memberId);
    }
}

