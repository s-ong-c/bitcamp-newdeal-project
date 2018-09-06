package trade.assignment.repository;

import java.util.HashMap;
import java.util.Map;

import trade.assignment.domain.Member;
import trade.assignment.dto.LoginDTO;
import trade.assignment.dto.RelationDTO;

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

	////profile
	public Member userRead(RelationDTO dto) throws Exception;

    int update(Member member);
    
    Member chkNick(String nickname) throws Exception;

}
