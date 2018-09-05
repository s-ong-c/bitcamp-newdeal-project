package trade.assignment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trade.assignment.domain.Post;
import trade.assignment.domain.Tag;
import trade.assignment.dto.FollowinPostDTO;
import trade.assignment.dto.RelationDTO;
import trade.assignment.repository.PostRepository;
import trade.assignment.service.PostService;
import trade.assignment.util.HashTagHelper;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired PostRepository postRepository;
	
	@Transactional
	@Override
	public void regist(Post post) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();

		System.out.println(post.toString());
		postRepository.create(post);
		// 첨부파일 목록, filter 불러들임
		String[] files = post.getFiles();
		String[] filters = post.getFilters();
		paramMap.put("url", files);
		System.out.println(paramMap.toString());
		System.out.println("파일은?"+files.toString());
		System.out.println("파일은?"+filters);
		System.out.println(files.length+"파일길이");
		// 파일 목록 없으면 아무것도 안함
		for(int i =0; i< files.length; i++){
			//postRepository.addAttach(files[i], filters[i]);
			postRepository.addAttach(files[i]);
		}
//		List<String> hashTags = HashTagHelper.getAllHashTags(post.getCaption());
//		if (!hashTags.isEmpty()) { // exist hash tag
//			for (String tagname : hashTags) {
//				registPostAndTag(post.getId(), tagname);
//			}
//		}
	}
	//post등록 util 메서드 = insertPostedTag/insertTag메서드 사용
//	public void registPostAndTag(Integer postid, String tagname) throws Exception {
//		Tag vo = selectTagByName(tagname);
//
//		if (vo == null) {
//			// tbl_tag에 존재하지 않는 tag
//			// tbl_tag에 일단 tag를 넣는다
//			//Tag vo2 = new Tag();
//			//vo2.setName(tagname);
//			//vo2.setTagcount(0);
//			//insertTag(vo2);
//			//insertPostedTag(postid, vo2.getId());
//		} else {
//
//			//insertPostedTag(postid, vo.getId());
//		}
//	}
	
	//post 등록 메서드 사용시 자동 사용
//	@Override
//	public void insertPostedTag(int postid, int tagid) throws Exception {
//		postRepository.insertPostedTag(postid, tagid);
//	}
	// tag name검색
//	@Override
//	public Tag selectTagByName(String name) throws Exception {
//		return postRepository.selectTagByName(name);
//	}
//	//post 등록 메서드 사용시 자동 사용 (tag등록)
//	@Override
//	public void insertTag(Tag vo) throws Exception {
//		postRepository.insertTag(vo);
//	}
//	
	
	@Override
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception{
		return postRepository.mainRead(id);
	}
	
	// 특정 유저 게시물목록
	@Override
	public List<Post> read(Integer userid) throws Exception{
		return postRepository.read(userid);
	}
	
	// 특정게시물 세부내용(매개변수:postid, loginid)
	@Override
	public FollowinPostDTO detailRead(RelationDTO dto) throws Exception{
		return postRepository.detailRead(dto);
	}
	
	@Override
	public List<FollowinPostDTO> topPost() throws Exception {
		return postRepository.topPost();
	}

}
