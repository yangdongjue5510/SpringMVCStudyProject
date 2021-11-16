package main.java.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDAOMyBatis implements UserDAO{

    @Autowired
    SqlSessionTemplate myBatis;

    @Override
    public void insertUser(UserVO vo) {
        myBatis.insert("UserDAO.insertUser", vo);
    }

    @Override
    public void updateUser(UserVO vo) {
        myBatis.update("UserDAO.updateUser", vo);
    }

    @Override
    public void deleteUser(UserVO vo) {
        myBatis.delete("UserDAO.deleteUser", vo);
    }

    @Override
    public UserVO getUser(UserVO vo) {
        return (UserVO) myBatis.selectOne("UserDAO.getUser", vo);
    }

    @Override
    public List<UserVO> getUserList(UserVO vo) {
        return (List<UserVO>) myBatis.selectList("UserDAO.getUserList", vo);
    }
}
