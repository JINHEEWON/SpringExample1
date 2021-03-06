package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //ApplicationContext - 스프링 컨테이너. 모든걸 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);  //AppConfig에 있는 환경 설정 정보를 가지고 스프링이 모든 메소드를 스프링 컨테이너에 집어넣어 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //이름(메소드 네임), 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
