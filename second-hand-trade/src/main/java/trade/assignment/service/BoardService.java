package trade.assignment.service;

import java.util.List;

import trade.assignment.domain.Board;

public interface BoardService {
	
    public List<Board> boardRead() throws Exception;
}
