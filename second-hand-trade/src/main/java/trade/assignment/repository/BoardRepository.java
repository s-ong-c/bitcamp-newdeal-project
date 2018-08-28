/*
 * created by 김동수 on 게시판 레포지토리
 * */

package trade.assignment.repository;

import java.util.HashMap;
import java.util.List;

import trade.assignment.domain.Board;

public interface BoardRepository {

    int insert(Board board);

    Board findByWriterAndDateAndTitle(HashMap<String, Object> params);

    Board selectOne(int no);

    List<Board> findByPageAndSize(HashMap<String, Object> params);

    int totalPage(int size);
}