package trade.assignment.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import common.MailHandler;
import trade.assignment.domain.Member;
import trade.assignment.repository.MemberRepository;
import trade.assignment.service.MemberService;
import common.TempKey;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired MemberRepository memberRepository;
    @Autowired
	private JavaMailSender mailSender;
    
    @Override
    public int add(Member member) throws Exception {
    	
		String key = new TempKey().getKey(50,false);  // 인증키 생성
		
		System.out.println(key+"키는??");
		//memberRepository.createAuthKey(member.getEmail(),key); //인증키 db 저장
    	
		//메일 전송
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("8AZON  서비스 이메일 인증]");
		sendMail.setText(
				new StringBuffer().append("<h1>메일인증</h1>")
				.append("<a href='http://localhost:8080/auth/emailConfirm?email=")
				.append(member.getEmail()).append("&memberAuthKey=")
				.append(key).append("' target='_blank'>이메일 인증 확인</a>")
				.toString());
		sendMail.setFrom("sososososo@gmail.com", "서어비스센터 ");
		sendMail.setTo(member.getEmail());
		sendMail.send();
  
        
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
