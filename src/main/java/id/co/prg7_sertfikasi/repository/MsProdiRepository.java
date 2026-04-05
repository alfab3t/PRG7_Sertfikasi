package id.co.prg7_sertfikasi.repository;

import id.co.prg7_sertfikasi.model.MsProdi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsProdiRepository extends JpaRepository<MsProdi, Integer> {
}
