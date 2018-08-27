package trade.assignment.service;

import java.util.List;

import trade.assignment.dto.FollowinPostDTO;

public interface PostService {
	// 메인피드 게시물 리스트(매개변수:postid, loginid)
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception;
}
