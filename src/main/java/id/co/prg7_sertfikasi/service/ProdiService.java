package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.model.Prodi;

import java.util.List;

public interface ProdiService {
    Prodi getProdiById(int id);
    List<Prodi> getProdis();
    void saveProdi(Prodi prodi);
    void updateProdi(Prodi prodi);
    void deleteProdi(int id);
}
