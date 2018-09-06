package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
	//이메일 인증 코드 검증
	@RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
	public Object emailConfirm(Member user,Model model,RedirectAttributes rttr) throws Exception { // 이메일인증
		
		
		System.out.println("cont get user"+user);
		Member vo = new Member();
		HashMap<String, Object> result = new HashMap<>();
		
		vo=memberService.userAuth(user);
		System.out.println("vo"+vo);
		if(vo == null) {
			rttr.addFlashAttribute("msg" , "비정상적인 접근 입니다. 다시 인증해 주세요");
			return "redirect:/";
		}
		//System.out.println("usercontroller vo =" +vo);
		model.addAttribute("login",vo);
		 result.put("status", "success");
		result.put("login", vo);
		
		
		
		
		
		
		return result;
	}


}
