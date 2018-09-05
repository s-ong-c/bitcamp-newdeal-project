package trade.assignment.repository;

import java.util.List;

import trade.assignment.domain.Reply;
import trade.assignment.dto.RelationDTO;

public interface ReplyRepository {
	public void create(Reply vo) throws Exception;
	
	public List<Reply> read(RelationDTO dto) throws Exception;
	
	public void delete(Integer id) throws Exception;
	
	//개인 하루 글 작성 개수 계산
	//public Integer writeCount(Reply vo);
}
