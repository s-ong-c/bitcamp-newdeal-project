package trade.assignment.web.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.domain.Post;
import trade.assignment.dto.FollowinPostDTO;
import trade.assignment.service.PostService;

@RestController
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	PostService service;
	
	@RequestMapping(value = "/mainTest", method = RequestMethod.GET)
	public Object main(HttpServletRequest request, Model model)throws Exception{
		
		
		 HashMap<String, Object> result = new HashMap<>();
		System.out.println("main이다");
		
		HttpSession session=request.getSession();
		System.out.println(session.toString());
		System.out.println("======");
		Member loginUser=(Member)session.getAttribute("loginUser");
		System.out.println(session);
		System.out.println(loginUser+"??어디까지 들어온;?");
		
		 session.setAttribute("loginUser",loginUser);

		if(loginUser!=null){
				model.addAttribute("list", service.mainRead(loginUser.getNo())); //세션 아이디값을 통해 현재 팔로우중인 유저들의 게시물정보 및 유저정보 등을 받아옴
				List<FollowinPostDTO> list = service.mainRead(loginUser.getNo());
				System.out.println(list.toString());
				result.put("loginUser",loginUser);
				result.put("list",list);
				result.put("status","success");
		}
		
	
		return result;
		
	}
}
