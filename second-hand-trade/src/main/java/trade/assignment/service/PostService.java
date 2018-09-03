package trade.assignment.service;

import java.util.List;

import trade.assignment.domain.Post;
import trade.assignment.domain.Tag;
import trade.assignment.dto.FollowinPostDTO;

public interface PostService {
	// 메인피드 게시물 리스트(매개변수:postid, loginid)
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception;
	
	// 특정 유저 게시물목록
	public List<Post> read(Integer userid) throws Exception;
	
	// POST등록(사진/태그 Transaction)
		public void regist(Post post) throws Exception;
		
	// registPostAndTag에서 사용
    public void insertTag(Tag vo) throws Exception;
    
	// regist에서 사용
	public void registPostAndTag(Integer postid, String tagname) throws Exception;
	
	// registPostAndTag에서 사용
	public void insertPostedTag(int postid, int tagid) throws Exception;
	
	// tag name검색
	public Tag selectTagByName(String name) throws Exception;

}
