package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.constant.SkemaConstant;
import id.co.prg7_sertfikasi.dao.SkemaDao;
import id.co.prg7_sertfikasi.model.Skema;
import id.co.prg7_sertfikasi.repository.SkemaRepository;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.SkemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkemaServiceImpl implements SkemaService {

    @Autowired
    private SkemaDao skemaDao;

    @Autowired
    private SkemaRepository skemaRepository;

    @Override
    public DtoResponse getAllSkemas() {
        return new DtoResponse(200, skemaDao.getAllSkemas());
    }

    @Override
    public DtoResponse getSkemaActive() {
        if (skemaDao.getSkemaActive() != null) {
            return new DtoResponse(200, skemaDao.getSkemaActive());
        }
        return new DtoResponse(200, null, SkemaConstant.mEmptyData);
    }

    @Override
    public DtoResponse saveSkema(Skema skema) {
        try {
            skemaRepository.save(skema);
            return new DtoResponse(200, skema, SkemaConstant.mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, skema, SkemaConstant.mCreateFailed);
        }
    }

    @Override
    public DtoResponse updateSkema(Skema skema) {
        try {
            Skema updatedSkema = skemaRepository.save(skema);
            if (updatedSkema != null) {
                return new DtoResponse(200, updatedSkema, SkemaConstant.mUpdateSuccess);
            } else {
                return new DtoResponse(404, null, SkemaConstant.mNotFound);
            }
        } catch (Exception e) {
            return new DtoResponse(500, null, SkemaConstant.mUpdateFailed);
        }
    }

    @Override
    public DtoResponse deleteSkema(Skema skema) {
        Skema skemaData = skemaRepository.findById(skema.getSkm_id()).orElseThrow();
        if (skemaData != null) {
            try {
                skemaRepository.delete(skema);
                return new DtoResponse(200, skemaData, SkemaConstant.mDeleteSuccess);
            } catch (Exception e) {
                return new DtoResponse(500, skemaData, SkemaConstant.mDeleteFailed);
            }
        }
        return new DtoResponse(404, null, SkemaConstant.mNotFound);
    }
}
