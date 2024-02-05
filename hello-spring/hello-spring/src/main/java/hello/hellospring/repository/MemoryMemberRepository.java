package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// implements command+enter로 인터페이스 만들어논 기능(?) 가져올수있음
public class MemoryMemberRepository implements MemeberRepositoy{

    // 데이터 저장소 및 시퀀스
    private static Map<Long, Member> store = new HashMap<>(); // 회원을 저장하는 맵
    private static Long sequence = 0L; // 회원 식별을 위한 시퀀스, 고유한 id 부여


    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 시퀀스 값을 증가시켜 회원에게 할당
        store.put(member.getId(), member); // 회원을 저장소에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // id로 회원 조회
    }
    // 주어진 id에 해당하는 회원을 찾아 Optional로 반환
    // 만약 해당 id 회원이 없으면 Optional.empty()를 반환

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // 저장소의 모든 값에 대해
                .filter(member -> member.getName().equals(name)) // 이름이 일치하는 것을 찾음
                .findAny(); // 하나라도 찾으면 반환
    }
    // (람다)주어진 이름에 해당하는 회원을 찾아 Optional로 반환
    // 이름이 일치하는 첫 번째 회원을 찾아 반환

    @Override
    public List<Member> findAll() {
        return List.copyOf(store.values()); // 저장소의 모든 회원 목록 반환
    }
    // 저장소에 저장된 모든 회원 목록을 반환
    // 목록을 수정할 수 없도록 List.copyOf()를 사용하여 복사본을 반환
}
