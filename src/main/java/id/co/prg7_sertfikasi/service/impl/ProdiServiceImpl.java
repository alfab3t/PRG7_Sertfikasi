package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.dao.ProdiDao;
import id.co.prg7_sertfikasi.model.Prodi;
import id.co.prg7_sertfikasi.service.ProdiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdiServiceImpl implements ProdiService {

    private final ProdiDao prodiDao;

    public ProdiServiceImpl(ProdiDao prodiDao) {
        this.prodiDao = prodiDao;
    }

    @Override
    public Prodi getProdiById(int id) {
        return prodiDao.getProdiById(id);
    }

    @Override
    public List<Prodi> getProdis() {
        return prodiDao.getAllProdis();
    }

    @Override
    public void saveProdi(Prodi prodi) {
        prodiDao.saveProdi(prodi);
    }

    @Override
    public void updateProdi(Prodi prodi) {
        prodiDao.updateProdi(prodi);
    }

    @Override
    public void deleteProdi(int id) {
        prodiDao.deleteProdi(id);
    }
}
