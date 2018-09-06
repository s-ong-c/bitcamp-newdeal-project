package trade.assignment.service;

import trade.assignment.domain.Member;
import trade.assignment.dto.LoginDTO;
import trade.assignment.dto.RelationDTO;

public interface MemberService {
	
    int add(Member member) throws Exception;

    Member getMember(String email, String password);
    public Member userAuth(Member member) throws Exception;

	/* ---kgm--- */
	int update(Member member);
    
	public String authenticate(String email) throws Exception;

	public Member googleLogin(LoginDTO dto) throws Exception;
	
	public Member userRead(RelationDTO dto) throws Exception;
	// user 프로필 읽어오
	public Member read(Integer id) throws Exception; //회원정보읽기
	
	Member checkPassWord(int id, String password) throws Exception; //비밀번호 체크
	
	public void modifypassUser(Member vo) throws Exception; //비밀번호 수정
	
	//public void modifyPhoto(Integer id, String fileName) throws Exception; //프로필 사진 변경
	public void modifyPhoto(int no, String profilephoto) throws Exception;
}
