package id.co.prg7_sertfikasi.repository;

import id.co.prg7_sertfikasi.model.MsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MsUserRepository extends JpaRepository<MsUser, Integer> {
    Optional<MsUser> findByUsr_username(String username);
    Optional<MsUser> findByUsr_email(String email);
    boolean existsByUsr_usernameOrUsr_email(String username, String email);
}
