package trade.assignment.web.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.domain.Post;
import trade.assignment.service.PostService;

@RestController
@RequestMapping("/ajax")
public class PostController2 {

	@Inject
	private PostService service;
	
	/*게시물 등록창 읽기*/
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET(Model model, HttpServletRequest request) throws Exception {
		System.out.println("register get..............");
		
		HttpSession session = request.getSession();
		if(session !=null){
			Member vo = (Member)session.getAttribute("loginUser");
			System.out.println("===================");
			System.out.println(vo.toString());
			model.addAttribute("Member", vo);
		}
		
	 return "redirect:/html/register.html";  
	}

	/*게시물 등록 - model방식*/
	@RequestMapping("/register")
	public Object registerPOST(Model model, HttpServletRequest request) throws Exception {
		System.out.println("register post..............");
		
		
		HashMap<String, Object> result = new HashMap<>();
		HttpSession session = request.getSession();
		if(session !=null){
			Member vo = (Member)session.getAttribute("loginUser");
			System.out.println("글올리기 폼정");
			System.out.println(vo.toString());
			model.addAttribute("Member", vo);
		}
		
		String[] files = request.getParameterValues("files");

		if(files != null){
			JSONArray jArray = new JSONArray();

			for(int i=0; i<files.length;i++){
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(files[i]);
				jArray.add(jsonObject);
			}
			
			System.out.println("사진 폼으로 전송은??");
			System.out.println(jArray.toJSONString());
			model.addAttribute("files", jArray);
			result.put("files", jArray);
		}
		System.out.println(Arrays.toString(files));
		
		return result;
	}
	
	@RequestMapping(value="/{userid}", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> list(@PathVariable("userid") Integer userid){
		ResponseEntity<List<Post>> entity=null;
		try{
			entity=new ResponseEntity<>(service.read(userid), HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
	