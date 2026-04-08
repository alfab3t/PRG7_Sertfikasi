package id.co.prg7_sertfikasi.repository;

import id.co.prg7_sertfikasi.model.TrSertifikasi;
import id.co.prg7_sertfikasi.model.TrSertifikasiPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrSertifikasiRepository extends JpaRepository<TrSertifikasi, TrSertifikasiPK> {
}
