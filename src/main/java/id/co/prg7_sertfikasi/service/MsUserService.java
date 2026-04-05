package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.model.MsUser;
import id.co.prg7_sertfikasi.response.DtoResponse;

public interface MsUserService {
    DtoResponse getAllUsers();
    DtoResponse getUserById(int id);
    DtoResponse getUserByUsername(String username);
    DtoResponse saveUser(MsUser user);
    DtoResponse updateUser(MsUser user);
    DtoResponse deleteUser(MsUser user);
}
