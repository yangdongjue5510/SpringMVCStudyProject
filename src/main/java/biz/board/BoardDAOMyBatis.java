package main.java.biz.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public class BoardDAOMyBatis implements BoardDAO{

    @Autowired //MyBatis의 컨테이너를 의미
    SqlSessionTemplate myBatis;

    //myBatis method 규칙 -> MyBatis로 매핑한 namespave, input값
    public void insertBoard(BoardVO vo) {
        System.out.println("===> myBatis insertBoard()");
        //namespace의 아이디이름, 인풋객체
        myBatis.insert("BoardDAO.insertBoard", vo);
    }

    public void updateBoard(BoardVO vo) {
        System.out.println("===> myBatis updateBoard()");
        myBatis.update("BoardDAO.updateBoard", vo);
    }

    public void deleteBoard(BoardVO vo) {
        System.out.println("===> myBatis deleteBoard()");
        myBatis.delete("BoardDAO.deleteBoard", vo);
    }

    public BoardVO getBoard(BoardVO vo) {
        System.out.println("===> myBatis getBoard()");
        return (BoardVO) myBatis.selectOne("BoardDAO.getBoard", vo);
    }

    public List<BoardVO> getBoardList(BoardVO vo) {
        System.out.println("===> myBatis getBoardList()");
        return (List<BoardVO>) myBatis.selectList("BoardDAO.getBoardList", vo);
    }
}
