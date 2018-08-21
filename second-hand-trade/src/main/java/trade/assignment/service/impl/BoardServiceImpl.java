package trade.assignment.service.impl;

import java.util.HashMap;
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
    public int add(Board board) {
        return boardRepository.insert(board);
    }
    
    @Override
    public Board getBoard(Board board) {
        HashMap<String ,Object> params = new HashMap<>();
        params.put("Board", board);
        return boardRepository.findByWriterAndDateAndTitle(params);
    }
    
    @Override
    public Board get(int no) {
        return boardRepository.selectOne(no);
    }
    
    @Override
    public List<Board> list(int page, int size) {
        HashMap<String ,Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        return boardRepository.findByPageAndSize(params);
    }
    
    @Override
    public int getTotalPage(int size) {
        return boardRepository.totalPage(size);
    }
}
