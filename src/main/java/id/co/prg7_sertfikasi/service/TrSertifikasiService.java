package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.model.TrSertifikasi;
import id.co.prg7_sertfikasi.response.DtoResponse;

public interface TrSertifikasiService {
    DtoResponse getAllSertifikasi();
    DtoResponse saveSertifikasi(TrSertifikasi trSertifikasi);
}
