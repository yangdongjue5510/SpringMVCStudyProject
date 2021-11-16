package main.java.biz.user;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserDAO{

    @Autowired
    UserDAO userDAO;

    @Override
    public void insertUser(UserVO vo) {
        userDAO.insertUser(vo);
    }

    @Override
    public void updateUser(UserVO vo) {
        userDAO.updateUser(vo);
    }

    @Override
    public void deleteUser(UserVO vo) {
        userDAO.deleteUser(vo);
    }

    @Override
    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }

    @Override
    public List<UserVO> getUserList(UserVO vo) {
        return userDAO.getUserList(vo);
    }
}
