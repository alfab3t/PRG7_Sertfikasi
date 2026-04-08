package id.co.prg7_sertfikasi.rest;

import id.co.prg7_sertfikasi.model.TrSertifikasi;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.TrSertifikasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sertifikasi")
public class TrSertifikasiRest {

    @Autowired
    private TrSertifikasiService trSertifikasiService;

    @GetMapping("/getSertifikasi")
    public DtoResponse getSertifikasi() {
        return trSertifikasiService.getAllSertifikasi();
    }

    @PostMapping("/saveSertifikasi")
    public DtoResponse saveSertifikasi(@RequestBody TrSertifikasi trSertifikasi) {
        return trSertifikasiService.saveSertifikasi(trSertifikasi);
    }
}
