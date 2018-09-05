package trade.assignment.service;

import java.util.List;

import trade.assignment.domain.Reply;
import trade.assignment.dto.RelationDTO;

public interface ReplyService {
	public void regist(Reply vo) throws Exception;
	
	public List<Reply> read(RelationDTO dto) throws Exception;
	
	public void remove(Integer id) throws Exception;
	
	//public Integer writeCount(Reply vo);
}
