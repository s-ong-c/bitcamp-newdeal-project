package trade.assignment.web.json;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.domain.Reply;
import trade.assignment.dto.RelationDTO;
import trade.assignment.repository.MemberRepository;
import trade.assignment.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	
	@Inject
	private ReplyService service;
//	
//	@Inject
//	private MemberRepository memberRepository;
	/*댓글 등록 - rest방식*/
	
	@ResponseBody
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> rplRegister(@RequestBody Reply vo, HttpServletRequest request, HttpServletResponse response){

		ResponseEntity<String> entity=null;
		System.out.println(vo);
		int count = 1;
				//service.writeCount(vo);
		//System.out.println(count);
		if(count>=3) {
			System.out.println("here is coming ");
			try {
				 response.setContentType("text/html; charset=UTF-8");
	             PrintWriter out = response.getWriter();
	             out.println("<script>alert('하루 글 작성 가능 개수는 5개까지입니다.');history.go(-1);</script>");
	             out.flush();
	             System.out.println(request.getRemoteAddr());
	             System.out.println(request.getRemoteAddr());
	             //userDao.insert_ip_ban(request.getRemoteAddr()); --하면 정지먹음
	             
			}
			catch(Exception e) {
				System.out.println(e);
			}

		}
		else {
			
			System.out.println("댓글작성하러 왔");
		
			try{	
				service.regist(vo);
				entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}catch(Exception e){
				e.printStackTrace();
				entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		return entity;
	}
	
	/*댓글 삭제 - rest방식*/
	@ResponseBody
	@RequestMapping(value="/{replyid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> rplRegister(@PathVariable("replyid") Integer id){
		ResponseEntity<String> entity=null;
		System.out.println(id);
		try{
			service.remove(id);
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*게시물에 대한 댓글 조회 - JSON객체(LIST배열에 담아서 던져줌)*/
	@ResponseBody
	@RequestMapping(value="/post/{postid}", method=RequestMethod.GET)
	public ResponseEntity<List<Reply>> rplList(@PathVariable("postid") Integer postid, HttpServletRequest request){
		
		//차단or차단당한 유저일경우 빼기위해 로그인값 확인
		Member vo=(Member)request.getSession().getAttribute("loginUser");
		RelationDTO dto=new RelationDTO();
		dto.setLoginid(vo.getNo());
		dto.setPostid(postid);
	
		ResponseEntity<List<Reply>> entity=null;
		try{
			entity=new ResponseEntity<>(service.read(dto), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}