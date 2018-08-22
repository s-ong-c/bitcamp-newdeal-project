package trade.assignment.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trade.assignment.domain.Member;
import trade.assignment.repository.MemberRepository;
import trade.assignment.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired MemberRepository memberRepository;
    
    @Override
    public int add(Member member) {
        
        return memberRepository.insert(member);
        
    }
    
    @Override
    public Member getMember(String email,String password) {
            
        System.out.println("getMemeber 하러 왔다/");
        HashMap<String, Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password",password);
        return memberRepository.findByEmailAndPassword(params);
    }
    //이메일 아이디 중복 관련 코드 전송
   
    
    @Override
    public String authenticate(String str) throws Exception {
    	
    	
    	Member vo =
    	 	
    		memberRepository.authenticate(str);
    		System.out.println("dao vo:"+vo);
    		if(vo == null) {
    			return "T";
    		}else if(vo.getPrilevel() == 0){
    			return "F";
    		}else{
    			return "D";
    		}
    

    }
    
    
    
	//이메일 인증 키 검증
    @Override
    public Member userAuth(Member member) throws Exception {
        Member vo =new Member();
  		System.out.println(member+"user");
          vo=memberRepository.chkAuth(member);
          //System.out.println("ser.userAuth.chkauth"+vo);
          if(vo!=null){
              try{
              	System.out.println(vo+"vo");
              	memberRepository.userAuth(member);
                  memberRepository.successAuth(vo);
              }catch (Exception e) {
                  e.printStackTrace();
              }}
          return vo;
    }
    
 
    
	

}
