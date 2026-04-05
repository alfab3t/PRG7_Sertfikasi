package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.model.MsProdi;
import id.co.prg7_sertfikasi.response.DtoResponse;

public interface MsProdiService {
    DtoResponse getAllProdis();
    DtoResponse getProdiById(int id);
    DtoResponse saveProdi(MsProdi prodi);
    DtoResponse updateProdi(MsProdi prodi);
    DtoResponse deleteProdi(MsProdi prodi);
}
