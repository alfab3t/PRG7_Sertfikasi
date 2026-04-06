package id.co.prg7_sertfikasi.repository;

import id.co.prg7_sertfikasi.model.MsUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MsUserRepository extends JpaRepository<MsUser, Integer> {

    @Query("SELECT u FROM MsUser u WHERE u.usr_username = :username")
    Optional<MsUser> findByUsr_username(@Param("username") String username);

    @Query("SELECT u FROM MsUser u WHERE u.usr_email = :email")
    Optional<MsUser> findByUsr_email(@Param("email") String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM MsUser u WHERE u.usr_username = :username OR u.usr_email = :email")
    boolean existsByUsr_usernameOrUsr_email(@Param("username") String username, @Param("email") String email);
}
