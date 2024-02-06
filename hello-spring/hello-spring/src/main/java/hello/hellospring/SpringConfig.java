package hello.hellospring;

import hello.hellospring.repository.MemeberRepositoy;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memeberRepositoy());
    }

    @Bean
    public MemeberRepositoy memeberRepositoy(){
        return new MemoryMemberRepository();
    }
}
