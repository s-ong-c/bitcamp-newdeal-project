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
    
	

}
