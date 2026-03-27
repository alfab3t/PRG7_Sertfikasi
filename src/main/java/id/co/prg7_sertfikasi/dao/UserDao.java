package id.co.prg7_sertfikasi.dao;

import id.co.prg7_sertfikasi.model.User;
import id.co.prg7_sertfikasi.vo.UserVo;

import java.util.List;

public interface UserDao {
    UserVo getUserById(int id);
    UserVo getUserByUsername(String username);
    List<UserVo> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
