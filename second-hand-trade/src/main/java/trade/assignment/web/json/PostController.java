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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trade.assignment.domain.Member;
import trade.assignment.domain.Post;
import trade.assignment.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

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
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object registerPOST(Model model, HttpServletRequest request) throws Exception {
		System.out.println("register post..............");
		
		System.out.println("글올리기 폼정@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
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
				System.out.println("jsonObject"+jsonObject);
				jArray.add(jsonObject);
			}
			
			System.out.println("사진 폼으로 전송은??");
			System.out.println(jArray.toJSONString());
			model.addAttribute("files", jArray);
			result.put("files", jArray.toJSONString());
			 session.setAttribute("files", jArray);
			 result.put("status", "success");
		}
		System.out.println(Arrays.toString(files));
		
		return result;
	}
	
	/*게시물 등록 - model방식*/
	@RequestMapping(value = "/register/submit", method = RequestMethod.POST)
	public Object registerSubmit(Post post, RedirectAttributes rttr, @RequestParam("files") String[] files, HttpServletRequest request) throws Exception {
		System.out.println("regist submit POST..............");
		System.out.println("regist submit POST..............");
		System.out.println("regist submit POST..............");
		System.out.println("regist submit POST..............");
		System.out.println("regist submit POST..............");
		System.out.println("regist submit POST..............");
		System.out.println("regist submit POST..............");
		
		System.out.println(post.toString());
		HashMap<String, Object> result = new HashMap<>();
		HttpSession session = request.getSession();
		if(session !=null){
			Member vo = (Member)session.getAttribute("loginUser");
			System.out.println("글올리기 폼정");
			System.out.println(vo.toString());
		}
		
		//String[] files = request.getParameterValues("files");
/*
		if(files != null){
			JSONArray jArray = new JSONArray();

			for(int i=0; i<files.length;i++){
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = (JSONObject) jsonParser.parse(files[i]);
				jArray.add(jsonObject);
				System.out.println(jsonObject);
			}
			System.out.println("사진 폼으로 전송은??");
			System.out.println(jArray.toJSONString());
			System.out.println("===111");
			result.put("files", jArray);
			System.out.println("===222"); 
			session.setAttribute("files", jArray);
			System.out.println("===333"); 
			 result.put("status", "success");
		}
		*/
		System.out.println("-------555");
		System.out.println(files);
		System.out.println("===444"); 
		//System.out.println(Arrays.toString(post.getFilters()));
		System.out.println("===555"); 
		Member user = (Member)session.getAttribute("loginUser");
		System.out.println("==============================");
		System.out.println(user.toString());
		System.out.println("===666"); 
		post.setUserid(user.getNo());
		System.out.println("===777"+Arrays.toString(files)); 
		System.out.println(post.toString());
		service.regist(post);
		result.put("status", "success");
		rttr.addFlashAttribute("msg", "SUCCESS");

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
	