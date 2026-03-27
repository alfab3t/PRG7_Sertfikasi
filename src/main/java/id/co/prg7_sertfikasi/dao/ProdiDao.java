package id.co.prg7_sertfikasi.dao;

import id.co.prg7_sertfikasi.model.Prodi;

import java.util.List;

public interface ProdiDao {
    Prodi getProdiById(int id);
    List<Prodi> getAllProdis();
    void saveProdi(Prodi prodi);
    void updateProdi(Prodi prodi);
    void deleteProdi(int id);
}
