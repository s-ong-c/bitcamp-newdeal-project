/*
 * created by 김동수 on 게시판 서비스
 * */

package trade.assignment.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import trade.assignment.domain.Board;

public interface BoardService {

    int add(Board board, MultipartFile photo);

    //Board getBoard(Board board);

    Board get(int no);

    List<Board> list(int page, int size);

    int getTotalPage(int size);
}