package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import trade.assignment.domain.Member;
import trade.assignment.dto.RelationDTO;
import trade.assignment.service.MemberService;

@RestController
@RequestMapping("/edit3")
public class ProfileController2 {
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
       
       /* 닉네임 중복 체크 */       
       @GetMapping("auth/chkNick")
       @ResponseBody
       public Object chkNick(@RequestParam String nickname) throws Exception{
           System.out.println("닉네임 중복 검사");
           
           System.out.println("nickName: "+ nickname);
           Member member = memberService.chkNick(nickname);
           if(member == null) {
               System.out.println("0");
               return 0;
           }else {
               System.out.println("1");
               return 1;
           }
       }
       
}
