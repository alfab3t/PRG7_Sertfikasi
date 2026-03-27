package id.co.prg7_sertfikasi.dao.impl;

import id.co.prg7_sertfikasi.constant.ProdiConstant;
import id.co.prg7_sertfikasi.dao.ProdiDao;
import id.co.prg7_sertfikasi.model.Prodi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdiDaoImpl implements ProdiDao {

    @Override
    public Prodi getProdiById(int id) {
        for (Prodi prodi : ProdiConstant.prodis) {
            if (prodi.getId() == id) return prodi;
        }
        return null;
    }

    @Override
    public List<Prodi> getAllProdis() {
        return ProdiConstant.prodis;
    }

    @Override
    public void saveProdi(Prodi prodi) {
        ProdiConstant.prodis.add(prodi);
    }

    @Override
    public void updateProdi(Prodi prodi) {
        for (Prodi existing : ProdiConstant.prodis) {
            if (existing.getId() == prodi.getId()) {
                existing.setProdi(prodi.getProdi());
                existing.setSingkatan(prodi.getSingkatan());
                existing.setJurusan(prodi.getJurusan());
                existing.setStatus(prodi.getStatus());
                return;
            }
        }
    }

    @Override
    public void deleteProdi(int id) {
        ProdiConstant.prodis.removeIf(prodi -> prodi.getId() == id);
    }
}
