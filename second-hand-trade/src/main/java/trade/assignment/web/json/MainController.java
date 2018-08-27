package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
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
		Member vo=(Member)session.getAttribute("login");
		
		System.out.println(vo+"??어디까지 들어온;?");

		if(vo!=null){
				model.addAttribute("list", service.mainRead(vo.getNo())); //세션 아이디값을 통해 현재 팔로우중인 유저들의 게시물정보 및 유저정보 등을 받아옴
				session.setAttribute("loginUser",vo);
				result.put("status","success");
		}
		
	
		return result;
		
	}
}
