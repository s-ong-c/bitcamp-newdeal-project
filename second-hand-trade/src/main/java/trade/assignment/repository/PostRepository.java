package trade.assignment.repository;

import java.util.List;

import trade.assignment.dto.FollowinPostDTO;

public interface PostRepository {
	//팔로우한 유저의 post전체목록 및 유저정보
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception;
}
