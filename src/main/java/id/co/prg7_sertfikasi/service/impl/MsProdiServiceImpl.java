package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.constant.MsProdiConstant;
import id.co.prg7_sertfikasi.model.MsProdi;
import id.co.prg7_sertfikasi.repository.MsProdiRepository;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.MsProdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsProdiServiceImpl implements MsProdiService {

    @Autowired
    private MsProdiRepository msProdiRepository;

    @Override
    public DtoResponse getAllProdis() {
        return new DtoResponse(200, msProdiRepository.findAll());
    }

    @Override
    public DtoResponse getProdiById(int id) {
        MsProdi prodi = msProdiRepository.findById(id).orElse(null);
        if (prodi != null) {
            return new DtoResponse(200, prodi);
        }
        return new DtoResponse(404, null, MsProdiConstant.mNotFound);
    }

    @Override
    public DtoResponse saveProdi(MsProdi prodi) {
        try {
            msProdiRepository.save(prodi);
            return new DtoResponse(200, prodi, MsProdiConstant.mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, MsProdiConstant.mCreateFailed);
        }
    }

    @Override
    public DtoResponse updateProdi(MsProdi prodi) {
        try {
            MsProdi updated = msProdiRepository.save(prodi);
            if (updated != null) {
                return new DtoResponse(200, updated, MsProdiConstant.mUpdateSuccess);
            }
            return new DtoResponse(404, null, MsProdiConstant.mNotFound);
        } catch (Exception e) {
            return new DtoResponse(500, null, MsProdiConstant.mUpdateFailed);
        }
    }

    @Override
    public DtoResponse deleteProdi(MsProdi prodi) {
        MsProdi existing = msProdiRepository.findById(prodi.getPro_id()).orElse(null);
        if (existing != null) {
            try {
                msProdiRepository.delete(existing);
                return new DtoResponse(200, existing, MsProdiConstant.mDeleteSuccess);
            } catch (Exception e) {
                return new DtoResponse(500, existing, MsProdiConstant.mDeleteFailed);
            }
        }
        return new DtoResponse(404, null, MsProdiConstant.mNotFound);
    }
}
