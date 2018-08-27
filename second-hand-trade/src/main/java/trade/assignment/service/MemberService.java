package trade.assignment.service;

import trade.assignment.domain.Member;
import trade.assignment.dto.LoginDTO;
import trade.assignment.dto.RelationDTO;

public interface MemberService {
	
    int add(Member member) throws Exception;

    Member getMember(String email, String password);
    public Member userAuth(Member member) throws Exception;

	public String authenticate(String email) throws Exception;

	public Member googleLogin(LoginDTO dto) throws Exception;
	
	public Member userRead(RelationDTO dto) throws Exception;
	// user 프로필 읽어오
}
