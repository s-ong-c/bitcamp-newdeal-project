package trade.assignment.service;

import java.util.List;

import trade.assignment.domain.Board;

public interface BoardService {

    int add(Board board);
    Board getBoard(Board board);
    Board get(int no);
    List<Board> list(int page, int size);
    int getTotalPage(int size);
}
