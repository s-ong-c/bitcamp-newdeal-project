package trade.assignment.web.json;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import common.TempKey;
import trade.assignment.domain.Member;
import trade.assignment.dto.LoginDTO;
import trade.assignment.dto.RelationDTO;
import trade.assignment.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    
    @Autowired 
    MemberService memberService;
   @PostMapping("signIn")
    public Object signUp(String email, String password,boolean saveEmail,HttpSession session) {
        
        HashMap<String, Object> result = new HashMap<>();
        
        try {
            Member loginUser = memberService.getMember(email,password);
            
            System.out.println(loginUser);
            if(loginUser ==null) {
               throw new Exception("이메일 또는 비밀번호를 확인하세요 ");
            }
           
            session.setAttribute("loginUser",loginUser);
            result.put("status","success");
                
            
        }catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
            
            
            return result;
    }
   //유저 email 중복 체크
  	//@PostMapping(value = "/authenticate" ,  produces = "application/json; charset=utf-8")
	@RequestMapping(value = "/authenticate" , method = RequestMethod.POST, produces = "application/json; charset=utf-8")
  	public @ResponseBody
  	String checkDuplicate(HttpServletResponse response, @RequestParam("email") String email, Model model)throws Exception {
		
		
		System.out.println("이메일 중복체크를 하러 왔다");
  		String msg = memberService.authenticate(email);
  		
  		String responseMsg;
  		if(msg == "T") {
  			responseMsg = "T";
  					//"{\"msg\":\""+"사용가능한 이메일 입니다."+"\",\"chk\":\""+"T"+"\"}";
  		}else if(msg == "F"){
  			responseMsg = "F";
  					//"{\"msg\":\""+"인증 대기중인 이메일 입니다. 인증해주세요."+"\"}";
  		}else{
  			responseMsg = "TF";
  		}
  		URLEncoder.encode(responseMsg , "UTF-8");
  		return responseMsg;
  	}
	
	
	////////////////////////////////////////////
	/* GoogleLogin */
	@Inject
	private GoogleConnectionFactory googleConnectionFactory;
	@Inject
	private OAuth2Parameters googleOAuth2Parameters;



	@RequestMapping(value = "/googleLogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String doGoogleSignInActionPage(HttpServletResponse response, Model model) throws Exception{
        OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();

//		googleOAuth2Parameters.setRedirectUri("http://localhost:8080/user/googleLogincallback");
        String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
       // System.out.println("/user/googleLogincallback, url : " + url);
        model.addAttribute("url",url);

        return "user/googleLogin";

    }


    @RequestMapping(value = "/googleSignInCallback")
    public String doSessionAssignActionPage(HttpServletRequest request, Model model)throws Exception{
     //System.out.println("/user/googleLogincallback");
    System.out.println("야 왜 안되냐 뒤질래 가자1");
        String code = request.getParameter("code");

		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code , googleOAuth2Parameters.getRedirectUri(),
				null);
	    System.out.println("야 왜 안되냐 뒤질래 가자2");
		String accessToken = accessGrant.getAccessToken();
		System.out.println("야 왜 안되냐 뒤질래 가자22");
		Long expireTime = accessGrant.getExpireTime();
		System.out.println("야 왜 안되냐 뒤질래 가자33");
		if (expireTime != null && expireTime < System.currentTimeMillis()) {
			accessToken = accessGrant.getRefreshToken();
			System.out.printf("accessToken is expired. refresh token = {}", accessToken);
			
			   System.out.println("야 왜 안되냐 뒤질래 가자3");
		}
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		   System.out.println("야 왜 안되냐 뒤질래 가자4");
		PlusOperations plusOperations = google.plusOperations();
		Person person = plusOperations.getGoogleProfile();

//		System.out.println("UserVO 전");
//		System.out.println("person getId: "+person.getId());

	
		
        LoginDTO dto = new LoginDTO();
		TempKey TK = new TempKey();

  //      System.out.println(person.getDisplayName());
		dto.setEmail("google"+"#"+TK.generateNumber(6));
        dto.setName(person.getDisplayName()+"#"+TK.generateNumber(5));
        dto.setSnsID("g"+person.getId());
        HttpSession session = request.getSession();
//		System.out.println("controller dto: "+dto);

    	Member member = new Member();
		try {
			member = memberService.googleLogin(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}


		if(member != null) {
			session.setAttribute("login", member );
			//response.sendRedirect("/");
			//System.out.println(userVO);
			Object dest = session.getAttribute("dest");
			if(dest=="user/socialLoginPost"){
				session.setAttribute("dest","/");
			}
			//System.out.println("postHandle dest: "+dest);
			if(dest==null){
				session.setAttribute("dest","/");
			}
		}else{
			session.setAttribute("dest","/user/login");
		}



//        session.setAttribute("login", vo );
//		model.addAttribute("userVO",vo);
		//System.out.println("getAattributeNames"+session.getAttribute(savedest));
        return "redirect:/user/socialLoginPost";
    }
    
    ///////////
    
	@RequestMapping(value="{name}", method=RequestMethod.GET)
    public Object get(@PathVariable("name") String name,HttpSession session ) throws Exception {
        
        Member vo = 
                (Member)session.getAttribute("loginUser");
        
        System.out.println(vo);
        RelationDTO dto=new RelationDTO();
        dto.setLoginid(vo.getNo());
        dto.setName(vo.getName());
        Member member = memberService.userRead(dto);
        
        System.out.println(member);
        System.out.println("=======");
        HashMap<String, Object> result = new HashMap<>();
       result.put("status", "success"); 
       result.put("data", member);
      // result.put("list", list); 
       
        return result;
        
    }

}
