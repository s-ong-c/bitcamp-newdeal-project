package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trade.assignment.domain.Member;
import trade.assignment.dto.RelationDTO;
import trade.assignment.service.MemberService;

@Controller
@RequestMapping("/edit")
public class ProfileController {
	 @Autowired 
	 MemberService memberService;
	 
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
