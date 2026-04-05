package id.co.prg7_sertfikasi.dao.impl;

import id.co.prg7_sertfikasi.dao.SkemaDao;
import id.co.prg7_sertfikasi.model.Skema;
import id.co.prg7_sertfikasi.repository.SkemaRepository;
import id.co.prg7_sertfikasi.vo.SkemaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SkemaDaoImpl implements SkemaDao {

    @Autowired
    private SkemaRepository skemaRepository;

    @Override
    public List<SkemaVo> getAllSkemas() {
        Iterable<Skema> skemas = skemaRepository.findAll();
        List<SkemaVo> skemaVos = new ArrayList<>();
        for (Skema item : skemas) {
            SkemaVo skemaVo = new SkemaVo(item);
            skemaVos.add(skemaVo);
        }
        return skemaVos;
    }

    @Override
    public List<SkemaVo> getSkemaActive() {
        Iterable<Skema> skemas = skemaRepository.findByStatus(1);
        List<SkemaVo> skemaVos = new ArrayList<>();
        for (Skema item : skemas) {
            SkemaVo skemaVo = new SkemaVo(item);
            skemaVos.add(skemaVo);
        }
        return skemaVos;
    }
}
