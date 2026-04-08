package id.co.prg7_sertfikasi.dao.impl;

import id.co.prg7_sertfikasi.dao.DetailSkemaDao;
import id.co.prg7_sertfikasi.model.DetailSkema;
import id.co.prg7_sertfikasi.model.MsProdi;
import id.co.prg7_sertfikasi.model.Skema;
import id.co.prg7_sertfikasi.repository.DetailSkemaRepository;
import id.co.prg7_sertfikasi.repository.MsProdiRepository;
import id.co.prg7_sertfikasi.repository.SkemaRepository;
import id.co.prg7_sertfikasi.vo.DetailSkemaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Repository
public class DetailSkemaDaoImpl implements DetailSkemaDao {

    @Autowired
    private DetailSkemaRepository detailSkemaRepository;

    @Autowired
    private SkemaRepository skemaRepository;

    @Autowired
    private MsProdiRepository prodiRepository;

    @Override
    public List<DetailSkemaVo> getAllDetailSkemas() {
        Iterable<DetailSkema> detailSkemas = detailSkemaRepository.findAll();
        List<DetailSkemaVo> detailSkemaVos = new ArrayList<>();
        for (DetailSkema item : detailSkemas) {
            DetailSkemaVo detailSkemaVo = new DetailSkemaVo(item);

            Skema skema = skemaRepository.findById(detailSkemaVo.getSkmId()).orElseThrow();
            detailSkemaVo.setSkmDesc(skema.getSkm_nama());

            MsProdi prodi = prodiRepository.findById(detailSkemaVo.getProId()).orElseThrow();
            detailSkemaVo.setProDesc(prodi.getPro_nama());

            detailSkemaVos.add(detailSkemaVo);
        }
        return detailSkemaVos;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetailSkemaVo> getDetailSkemaActive() {
        Iterable<DetailSkema> detailSkemas = detailSkemaRepository.findByStatus(1);
        List<DetailSkemaVo> detailSkemaVos = new ArrayList<>();
        for (DetailSkema item : detailSkemas) {
            DetailSkemaVo detailSkemaVo = new DetailSkemaVo(item);

            Skema skema = skemaRepository.findById(detailSkemaVo.getSkmId()).orElseThrow();
            detailSkemaVo.setSkmDesc(skema.getSkm_nama());

            MsProdi prodi = prodiRepository.findById(detailSkemaVo.getProId()).orElseThrow();
            detailSkemaVo.setProDesc(prodi.getPro_nama());

            detailSkemaVos.add(detailSkemaVo);
        }
        return detailSkemaVos;
    }
}
