package trade.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import trade.assignment.domain.Board;
import trade.assignment.repository.BoardRepository;
import trade.assignment.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired BoardRepository boardRepository;

    @Override
    public List<Board> boardRead() throws Exception {
        
        return boardRepository.openBoard();
        
    }
    

    
    

    
	

}
