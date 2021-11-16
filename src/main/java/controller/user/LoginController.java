package main.java.controller.user;

import main.java.biz.user.UserDAOMyBatis;
import main.java.biz.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/loginView.do")
    public String loginView(){
        return "login";
    }
    @RequestMapping("/login.do")
    public String login(UserVO vo, UserDAOMyBatis userDAO, HttpSession session) {
        UserVO user = userDAO.getUser(vo);
        if(user != null) {
            session.setAttribute("user", user);
            return "forward:getBoardList.do";
        } else {
            return "login";
        }
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}