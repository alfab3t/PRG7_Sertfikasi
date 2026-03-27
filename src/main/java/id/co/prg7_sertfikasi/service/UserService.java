package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.model.User;
import id.co.prg7_sertfikasi.vo.UserVo;

import java.util.List;

public interface UserService {
    UserVo getUserById(int id);
    UserVo getUserByUsername(String username);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<UserVo> getUsers();
}
