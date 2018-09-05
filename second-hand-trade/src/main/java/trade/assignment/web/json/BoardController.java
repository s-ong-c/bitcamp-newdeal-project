package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.service.BoardService;
import trade.assignment.service.PostService;

@RestController
@RequestMapping("/main")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping
	public Object mainBoard(Model model)throws Exception{
		
		 HashMap<String, Object> result = new HashMap<>();
		 result.put("list", boardService.boardRead());
		System.out.println("main에 board출력 : " + boardService.boardRead());

		return result;
		
	}
}
