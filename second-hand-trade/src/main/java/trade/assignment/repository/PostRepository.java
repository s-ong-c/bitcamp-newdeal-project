package trade.assignment.repository;

import java.util.List;

import trade.assignment.domain.Post;
import trade.assignment.domain.Tag;
import trade.assignment.dto.FollowinPostDTO;
import trade.assignment.dto.RelationDTO;

public interface PostRepository {
	//팔로우한 유저의 post전체목록 및 유저정보
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception;
	
	//특정유저의 전체 포스트
	public List<Post> read(Integer userid) throws Exception;
	
	//게시물 생성
	public void create(Post vo)throws Exception;
	//파일첨부
	public void addAttach(String fullName) throws Exception;
	
	//게시물의 세부디테일 정보
	public FollowinPostDTO detailRead(RelationDTO dto) throws Exception;
	
	
	//tag등록
//	public void insertTag(Tag vo) throws Exception; 
//	
//	//tag name으로 찾기
//	public Tag selectTagByName(String name) throws Exception;
//	
//	//postid와 tagid 등록
//	public void insertPostedTag(int postid, int tagid) throws Exception;
}
