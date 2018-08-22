package trade.assignment.repository;

import java.util.Map;

import trade.assignment.domain.Member;

public interface MemberRepository {

    int insert(Member member);

    Member findByEmailAndPassword(Map<String,Object> params);

	Member authenticate(String str);

	Member chkAuth(Member member);

	void userAuth(Member member);

	void successAuth(Member vo);
    


	
}
