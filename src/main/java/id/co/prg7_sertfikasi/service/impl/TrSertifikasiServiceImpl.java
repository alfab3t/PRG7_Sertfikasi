package id.co.prg7_sertfikasi.service.impl;

import id.co.prg7_sertfikasi.constant.TrSertifikasiConstant;
import id.co.prg7_sertfikasi.model.TrSertifikasi;
import id.co.prg7_sertfikasi.repository.TrSertifikasiRepository;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.TrSertifikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrSertifikasiServiceImpl implements TrSertifikasiService {

    @Autowired
    private TrSertifikasiRepository trSertifikasiRepository;

    @Override
    public DtoResponse getAllSertifikasi() {
        List<TrSertifikasi> list = trSertifikasiRepository.findAll();
        if (list.isEmpty()) {
            return new DtoResponse(200, null, TrSertifikasiConstant.mEmptyData);
        }
        return new DtoResponse(200, list);
    }

    @Override
    public DtoResponse saveSertifikasi(TrSertifikasi trSertifikasi) {
        try {
            // auto increment tsk_id
            List<TrSertifikasi> list = trSertifikasiRepository.findAll();
            int nextId = list.isEmpty() ? 1 : list.size() + 1;
            trSertifikasi.getTrSertifikasiPK().setTsk_id(nextId);

            trSertifikasiRepository.save(trSertifikasi);
            return new DtoResponse(200, trSertifikasi, TrSertifikasiConstant.mCreateSuccess);
        } catch (Exception e) {
            return new DtoResponse(500, null, TrSertifikasiConstant.mCreateFailed);
        }
    }
}
