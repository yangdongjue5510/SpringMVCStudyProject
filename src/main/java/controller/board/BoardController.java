package main.java.controller.board;

import main.java.biz.board.BoardService;
import main.java.biz.board.BoardVO;
import main.java.biz.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/insertBoardView.do")
    public String insertBoardView(){
        return "insertBoard";
    }

    @RequestMapping("/insertBoard.do")
    public String insertBoard(BoardVO vo) {
        boardService.insertBoard(vo);
        return "forward:getBoardList.do";
    }

    @RequestMapping("/updateBoard.do")
    public String updateBoard(BoardVO vo) {
        boardService.updateBoard(vo);
        return "forward:getBoardList.do";
    }

    @RequestMapping("/deleteBoard.do")
    public String deleteBoard(BoardVO vo) {
        boardService.deleteBoard(vo);
        return "forward:getBoardList.do";
    }

    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, HttpSession session, Model model) {
        model.addAttribute("board", boardService.getBoard(vo));
        return "getBoard";
    }

    @RequestMapping("/getBoardList.do")
    public String getBoardList(BoardVO vo, HttpSession session, Model model) {


        UserVO user = (UserVO) session.getAttribute("user");
        if(user == null) {
            return "login";
        } else {
            // Null Check
            if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
            if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

            //세션에 큰 객체를 저장하는 건 미친짓, 서버 메모리에 저장하는 데,
            //세션은 각 브라우저마다 하나씩 생성 , 브라우저 종료 전까지 유지된다.
            //일회용으로 사용되는 request 객체(Model)에 저장하는게 맞다.
            //모델에 저장해주면 request에 자동으로 저장된다.

            //session.setAttribute("boardList", boardService.getBoardList(vo));
            //session.setAttribute("search", vo);

            model.addAttribute("boardList", boardService.getBoardList(vo));
            model.addAttribute("search", vo);
            return "getBoardList";
        }
    }
}