package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 파라미터 조회해서 Member 객체 만들기
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 2. Member 객체 생성 후 MemberRepository로 저장
        Member member = new Member(username, age);
        memberRepository.save(member);
        System.out.println("member = " + member);

        // 3. Model에 데이터 보관
        request.setAttribute("member", member);

        // 4. 해당 경로의 뷰로 이동
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}