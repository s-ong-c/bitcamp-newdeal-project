package trade.assignment.service;

import trade.assignment.domain.Member;

public interface memberService {
    int add(Member member);

    Member getMember(String email, String password);

}
