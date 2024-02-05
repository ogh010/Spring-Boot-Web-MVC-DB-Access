package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc") // localhost:8080/hello-mvc/?name=오가희 해가지구 오가희가져오는구
    public  String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string") // 이고는 헬로 뒤에 name 붙이는공 아..ㅅ 그럴걸 ㄷ
    @ResponseBody //http body 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello"+name; // 문자가 그대로 내려감
    }

    /* 데이터를 내놓을 때 객체 */
    @GetMapping("hello-api") // 요거능 객체형태로 데이터 뿌리는고 우웅 웅마자용
    @ResponseBody // json 반환하는게 디폴트!
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); // 객체를 만듦!!
        hello.setName(name);
        return hello;
    }

    // 없더
    static class Hello{ // 근뎅 여기에다가 getter setter 처리행..! 아 웅
        // 게터 세터
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
