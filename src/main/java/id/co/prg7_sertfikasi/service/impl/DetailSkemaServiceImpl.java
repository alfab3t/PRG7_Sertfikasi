package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.constant.DetailSkemaConstant;
import id.co.prg7_sertfikasi.dao.DetailSkemaDao;
import id.co.prg7_sertfikasi.model.DetailSkema;
import id.co.prg7_sertfikasi.model.DetailSkemaPK;
import id.co.prg7_sertfikasi.repository.DetailSkemaRepository;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.DetailSkemaService;
import id.co.prg7_sertfikasi.vo.DetailSkemaVo;
import id.co.prg7_sertfikasi.vo.DetailSkemaVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailSkemaServiceImpl implements DetailSkemaService {

    @Autowired
    private DetailSkemaDao detailSkemaDao;

    @Autowired
    private DetailSkemaRepository detailSkemaRepository;

    @Autowired
    private id.co.prg7_sertfikasi.repository.SkemaRepository skemaRepository;

    @Autowired
    private id.co.prg7_sertfikasi.repository.MsProdiRepository msProdiRepository;

    @Override
    public DtoResponse getAllDetailSkemas() {
        return new DtoResponse(200, detailSkemaDao.getAllDetailSkemas());
    }

    @Override
    public DtoResponse getDetailSkemaActive() {
        if (detailSkemaDao.getDetailSkemaActive() != null) {
            return new DtoResponse(200, detailSkemaDao.getDetailSkemaActive());
        }
        return new DtoResponse(200, null, DetailSkemaConstant.mEmptyData);
    }

    @Override
    public DtoResponse saveDetailSkema(DetailSkemaVoForm detailSkemaVoForm) {
        try {
            // validasi skm_id dan pro_id
            boolean skmExists = skemaRepository.findById(detailSkemaVoForm.getSkmId()).isPresent();
            boolean proExists = msProdiRepository.findById(detailSkemaVoForm.getProId()).isPresent();
            if (!skmExists || !proExists) {
                return new DtoResponse(400, null, "Scheme or Study Program is invalid");
            }
            DetailSkemaPK detailSkemaPK = new DetailSkemaPK();
            detailSkemaPK.setPro_id(detailSkemaVoForm.getProId());
            detailSkemaPK.setSkm_id(detailSkemaVoForm.getSkmId());

            List<DetailSkemaVo> listData = detailSkemaDao.getAllDetailSkemas();
            if (listData.isEmpty()) {
                detailSkemaPK.setDsk_id(1);
            } else {
                DetailSkemaVo lastData = listData.get(listData.size() - 1);
                detailSkemaPK.setDsk_id(lastData.getDskId() + 1);
            }

            DetailSkema detailSkema = new DetailSkema();
            detailSkema.setDetailSkemaPK(detailSkemaPK);
            detailSkema.setDsk_tanggal_mulai(detailSkemaVoForm.getTanggalMulai());
            detailSkema.setDsk_tanggal_berakhir(detailSkemaVoForm.getTanggalBerakhir());
            detailSkema.setDsk_total_peserta(detailSkemaVoForm.getTotalPeserta());
            detailSkema.setDsk_kompeten(detailSkemaVoForm.getKompeten());
            detailSkema.setDsk_belum_kompeten(detailSkemaVoForm.getBelumKompeten());
            detailSkema.setDsk_tidak_hadir(detailSkemaVoForm.getTidakHadir());
            detailSkema.setDsk_status(detailSkemaVoForm.getStatus());
            detailSkema.setDsk_creaby(detailSkemaVoForm.getCreaby());
            detailSkema.setDsk_creadate(detailSkemaVoForm.getCreadate());
            detailSkema.setDsk_modiby(detailSkemaVoForm.getModiby());
            detailSkema.setDsk_modidate(detailSkemaVoForm.getModidate());

            id.co.prg7_sertfikasi.model.DetailSkema saved = detailSkemaRepository.save(detailSkema);
            return new DtoResponse(200, saved, DetailSkemaConstant.mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, detailSkemaVoForm, DetailSkemaConstant.mCreateFailed);
        }
    }

    @Override
    public DtoResponse updateDetailSkema(DetailSkemaVoForm detailSkemaVoForm) {
        try {
            DetailSkemaPK detailSkemaPK = new DetailSkemaPK(
                detailSkemaVoForm.getDskId(),
                detailSkemaVoForm.getSkmId(),
                detailSkemaVoForm.getProId()
            );

            DetailSkema detailSkema = new DetailSkema();
            detailSkema.setDetailSkemaPK(detailSkemaPK);
            detailSkema.setDsk_tanggal_mulai(detailSkemaVoForm.getTanggalMulai());
            detailSkema.setDsk_tanggal_berakhir(detailSkemaVoForm.getTanggalBerakhir());
            detailSkema.setDsk_total_peserta(detailSkemaVoForm.getTotalPeserta());
            detailSkema.setDsk_kompeten(detailSkemaVoForm.getKompeten());
            detailSkema.setDsk_belum_kompeten(detailSkemaVoForm.getBelumKompeten());
            detailSkema.setDsk_tidak_hadir(detailSkemaVoForm.getTidakHadir());
            detailSkema.setDsk_status(detailSkemaVoForm.getStatus());
            detailSkema.setDsk_creaby(detailSkemaVoForm.getCreaby());
            detailSkema.setDsk_creadate(detailSkemaVoForm.getCreadate());
            detailSkema.setDsk_modiby(detailSkemaVoForm.getModiby());
            detailSkema.setDsk_modidate(detailSkemaVoForm.getModidate());

            DetailSkema updated = detailSkemaRepository.save(detailSkema);
            return new DtoResponse(200, updated, DetailSkemaConstant.mUpdateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, DetailSkemaConstant.mUpdateFailed);
        }
    }

    @Override
    public DtoResponse deleteDetailSkema(DetailSkemaVoForm detailSkemaVoForm) {
        try {
            DetailSkemaPK detailSkemaPK = new DetailSkemaPK(
                detailSkemaVoForm.getDskId(),
                detailSkemaVoForm.getSkmId(),
                detailSkemaVoForm.getProId()
            );
            DetailSkemaVoForm result = new DetailSkemaVoForm();
            result.setDskId(detailSkemaVoForm.getDskId());
            result.setSkmId(detailSkemaVoForm.getSkmId());
            result.setProId(detailSkemaVoForm.getProId());

            detailSkemaRepository.deleteById(detailSkemaPK);
            return new DtoResponse(200, result, DetailSkemaConstant.mDeleteSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, DetailSkemaConstant.mDeleteFailed);
        }
    }
}
