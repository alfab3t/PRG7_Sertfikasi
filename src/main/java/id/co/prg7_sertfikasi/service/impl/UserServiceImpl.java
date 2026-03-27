package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.dao.UserDao;
import id.co.prg7_sertfikasi.model.User;
import id.co.prg7_sertfikasi.service.UserService;
import id.co.prg7_sertfikasi.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserVo getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserVo getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<UserVo> getUsers() {
        return userDao.getAllUsers();
    }
}
