package trade.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trade.assignment.dto.FollowinPostDTO;
import trade.assignment.repository.PostRepository;
import trade.assignment.service.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired PostRepository postRepository;
	@Override
	public List<FollowinPostDTO> mainRead(Integer id) throws Exception{
		return postRepository.mainRead(id);
	}

}
