package id.co.prg7_sertfikasi.repository;

import id.co.prg7_sertfikasi.constant.SkemaConstant;
import id.co.prg7_sertfikasi.model.Skema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkemaRepository extends JpaRepository<Skema, Integer> {

    @Query(value = SkemaConstant.qAllDataActive, nativeQuery = true)
    List<Skema> findByStatus(int status);
}
