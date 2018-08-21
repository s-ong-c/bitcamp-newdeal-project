package trade.assignment.service;

import trade.assignment.domain.Member;

public interface MemberService {
	
    int add(Member member);

    Member getMember(String email, String password);
    

}
