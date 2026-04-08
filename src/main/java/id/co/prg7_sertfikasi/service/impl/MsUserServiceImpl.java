package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.constant.MsUserConstant;
import id.co.prg7_sertfikasi.model.MsUser;
import id.co.prg7_sertfikasi.repository.MsUserRepository;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.MsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class MsUserServiceImpl implements MsUserService {

    @Autowired
    private MsUserRepository msUserRepository;

    // enkripsi password sederhana menggunakan Base64
    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    @Override
    public DtoResponse getAllUsers() {
        return new DtoResponse(200, msUserRepository.findAll());
    }

    @Override
    public DtoResponse getUserById(int id) {
        MsUser user = msUserRepository.findById(id).orElse(null);
        if (user != null) {
            return new DtoResponse(200, user);
        }
        return new DtoResponse(404, null, MsUserConstant.mNotFound);
    }

    @Override
    public DtoResponse getUserByUsername(String username) {
        MsUser user = msUserRepository.findByUsr_username(username).orElse(null);
        if (user != null) {
            return new DtoResponse(200, user);
        }
        return new DtoResponse(404, null, MsUserConstant.mNotFound);
    }

    @Override
    public DtoResponse saveUser(MsUser user) {
        // validasi username dan email
        if (msUserRepository.existsByUsr_usernameOrUsr_email(user.getUsr_username(), user.getUsr_email())) {
            return new DtoResponse(409, null, MsUserConstant.mAlreadyRegistered);
        }
        try {
            user.setUsr_password(encryptPassword(user.getUsr_password()));
            msUserRepository.save(user);
            return new DtoResponse(200, user, MsUserConstant.mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, MsUserConstant.mCreateFailed);
        }
    }

    @Override
    public DtoResponse updateUser(MsUser user) {
        try {
            MsUser existing = msUserRepository.findById(user.getUsr_id()).orElse(null);
            if (existing == null) {
                return new DtoResponse(404, null, MsUserConstant.mNotFound);
            }
            // hanya update field yang tidak null
            if (user.getUsr_nama() != null) existing.setUsr_nama(user.getUsr_nama());
            if (user.getUsr_email() != null) existing.setUsr_email(user.getUsr_email());
            if (user.getUsr_username() != null) existing.setUsr_username(user.getUsr_username());
            if (user.getUsr_password() != null && !user.getUsr_password().isEmpty()) {
                existing.setUsr_password(encryptPassword(user.getUsr_password()));
            }
            if (user.getUsr_role() != null) existing.setUsr_role(user.getUsr_role());
            if (user.getUsr_status() != null) existing.setUsr_status(user.getUsr_status());
            if (user.getPro_id() != null) existing.setPro_id(user.getPro_id());
            if (user.getUsr_modiby() != null) existing.setUsr_modiby(user.getUsr_modiby());
            if (user.getUsr_modidate() != null) existing.setUsr_modidate(user.getUsr_modidate());

            MsUser updated = msUserRepository.save(existing);
            return new DtoResponse(200, updated, MsUserConstant.mUpdateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, MsUserConstant.mUpdateFailed);
        }
    }

    @Override
    public DtoResponse deleteUser(MsUser user) {
        MsUser existing = msUserRepository.findById(user.getUsr_id()).orElse(null);
        if (existing != null) {
            try {
                msUserRepository.delete(existing);
                return new DtoResponse(200, existing, MsUserConstant.mDeleteSuccess);
            } catch (Exception e) {
                return new DtoResponse(500, existing, MsUserConstant.mDeleteFailed);
            }
        }
        return new DtoResponse(404, null, MsUserConstant.mNotFound);
    }
}
