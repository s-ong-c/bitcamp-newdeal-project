package trade.assignment.web.json.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import trade.assignment.domain.Member;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        System.out.printf("loginUser:%s\n", loginUser);

        if (loginUser == null) { // 로그인을 하지 않았으면 로그인 폼으로 보낸다.
            HashMap<String,Object> result = new HashMap<>();
            result.put("status", "fail");
            result.put("message", "사용 권한이 없습니다.");

            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();

            ObjectMapper mapper = new ObjectMapper();
            out.print(mapper.writeValueAsString(result));
            return false;
        }

        return true;
    }
}