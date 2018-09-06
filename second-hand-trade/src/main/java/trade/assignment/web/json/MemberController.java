package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    
    @Autowired 
    MemberService memberService;
    @PostMapping("signUp")
    public Object signUp(Member member) {
        
       System.out.println(member);
        HashMap<String, Object> result = new HashMap<>();
        
        try {
        		memberService.add(member);
            result.put("status", "success");
        }catch (Exception e) {
            result.put("status", "faile");
            result.put("message", e.getMessage());
        }
            
            
            return result;
    }
    
    /* 수정 */
    @PostMapping("update")
    public Object update(Member member, HttpSession session) throws Exception{
        
        Member loginUser = (Member) session.getAttribute("loginUser");
        System.out.println(loginUser);
        
        member.setNo(loginUser.getNo());
        memberService.update(member);
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }

}
