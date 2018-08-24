package trade.assignment.repository;

import java.util.Map;

import trade.assignment.domain.Member;
import trade.assignment.dto.LoginDTO;

public interface MemberRepository {

    int insert(Member member);

    Member findByEmailAndPassword(Map<String,Object> params);

	Member authenticate(String email);

	Member chkAuth(Member member);

	void userAuth(Member member);

	void successAuth(Member vo);
	
	void createAuthKey(String Email, String memberAuthKey) ; // 인증키 발
    
	public void naverInsertUser(LoginDTO dto) throws Exception; // 네이버 등

	public Member naverReadUser(LoginDTO dto) throws Exception; // 네이버 유저읽기( 아직 안됨)

	
}
