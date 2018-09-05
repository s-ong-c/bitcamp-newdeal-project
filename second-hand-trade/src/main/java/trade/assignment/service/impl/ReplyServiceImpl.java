package trade.assignment.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import trade.assignment.domain.Reply;
import trade.assignment.dto.RelationDTO;
import trade.assignment.repository.ReplyRepository;
import trade.assignment.service.ReplyService;

@Service 
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyRepository replyRepository;
	
	@Override
	public void regist(Reply vo) throws Exception{
		replyRepository.create(vo);
	}
	
	@Override
	public List<Reply> read(RelationDTO dto) throws Exception{
		return replyRepository.read(dto);
	}
	
	@Override
	public void remove(Integer id) throws Exception{
		replyRepository.delete(id);
	}
	
//	@Override
//	public Integer writeCount(Reply vo) {
//		return replyRepository.writeCount(vo);
//	}
}
