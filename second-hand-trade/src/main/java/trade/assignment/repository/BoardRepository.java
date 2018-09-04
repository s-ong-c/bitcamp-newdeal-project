/*
 * created by 김동수 on 게시판 레포지토리
 * */

package trade.assignment.repository;

import java.util.HashMap;
import java.util.List;

import trade.assignment.domain.Board;

public interface BoardRepository {

    List<Board> findByPageAndSize(HashMap<String, Object> params);

    Board selectOne(int no);

    int update(Board board);

    int delete(int no);

    int insert(Board board);

    int countAll();
    
    /* Board findByWriterAndDateAndTitle(HashMap<String, Object> params); */
}