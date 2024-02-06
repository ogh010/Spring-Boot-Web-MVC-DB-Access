package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemeberRepositoy {
    Member save(Member member); // 1. 저장하기

    Optional<Member> findById(Long id); // null 처리 대시 Optional로..! 2. id로 찾기

    Optional<Member> findByName(String name); // 3. name으로 찾기

    List<Member> findAll(); // 4. 회원 리스트 가져오기
}

// 도메인 -> 리포지토리