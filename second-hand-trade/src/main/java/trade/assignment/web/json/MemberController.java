package trade.assignment.web.json;

import java.util.HashMap;

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
    //@RequestMapping(value ="singUp", method=RequestMethod.POST)
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

}
