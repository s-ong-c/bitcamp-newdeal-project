package trade.assignment.web.json;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    
    @Autowired 
    MemberService memberService;
   @PostMapping("signIn")
    public Object signUp(String email, String password,boolean saveEmail) {
        
        HashMap<String, Object> result = new HashMap<>();
        
        try {
            Member loginUser = memberService.getMember(email,password);
            
            System.out.println(loginUser);
            if(loginUser ==null) {
               throw new Exception("이메일 또는 비밀번호를 확인하세요 ");
            }
           
           // session.setAttribute("loginUser",loginUser);
            result.put("status","success");
                
            
        }catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
            
            
            return result;
    }
   //유저 email 중복 체크
  	@PostMapping(value = "/authenticate" ,  produces = "application/json; charset=utf-8")
  	public @ResponseBody
  	String checkDuplicate(HttpServletResponse response, @RequestParam("email") String email, Model model)throws Exception {

  		String msg = memberService.authenticate(email);
  		String responseMsg;
  		if(msg == "T") {
  			responseMsg = "{\"msg\":\""+"사용가능한 이메일 입니다."+"\",\"chk\":\""+"T"+"\"}";
  		}else if(msg == "F"){
  			responseMsg = "{\"msg\":\""+"인증 대기중인 이메일 입니다. 인증해주세요."+"\"}";
  		}else{
  			responseMsg = "{\"msg\":\""+"사용이 불가한 이메일 입니다."+"\"}";
  		}
  		URLEncoder.encode(responseMsg , "UTF-8");
  		//System.out.println(userEmail);
  		//System.out.println(responseMsg);
  		return responseMsg;
  	}

}
