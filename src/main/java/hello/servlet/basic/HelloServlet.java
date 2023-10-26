package hello.servlet.basic;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // 서블릿이 호출되면 서비스 메서드가 호출됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 쿼리 파라미터 조회
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 헤더(content-type) 설정
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // 응답 바디 설정
        response.getWriter().write("hello " + username);
    }
}

