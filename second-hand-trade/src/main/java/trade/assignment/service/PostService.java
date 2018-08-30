package trade.assignment.service;

import java.util.List;

import trade.assignment.domain.Post;
import trade.assignment.dto.FollowinPostDTO;

public interface PostService {
	// 메인피드 게시물 리스트(매개변수:postid, loginid)
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception;
	
	// 특정 유저 게시물목록
	public List<Post> read(Integer userid) throws Exception;

}
