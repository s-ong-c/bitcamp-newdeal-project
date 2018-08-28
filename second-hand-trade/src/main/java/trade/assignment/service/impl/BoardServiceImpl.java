package trade.assignment.service.impl;

/*
 * created by 김동수 on 게시판 서비스 구현
 * */

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import trade.assignment.domain.Board;
import trade.assignment.repository.BoardRepository;
import trade.assignment.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired BoardRepository boardRepository;
    @Autowired ServletContext sc;

    @Override
    public int add(Board board, MultipartFile photo) {
        String newfilename = UUID.randomUUID().toString();
        String path = sc.getRealPath("/files/" + newfilename);
        try {
            photo.transferTo(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardRepository.insert(board);
    }

    @Override
    public Board getBoard(Board board) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("Board", board);
        return boardRepository.findByWriterAndDateAndTitle(params);
    }

    @Override
    public Board get(int no) {
        return boardRepository.selectOne(no);
    }

    @Override
    public List<Board> list(int page, int size) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("page", page);
        params.put("size", size);
        return boardRepository.findByPageAndSize(params);
    }

    @Override
    public int getTotalPage(int size) {
        return boardRepository.totalPage(size);
    }
}