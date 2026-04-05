package id.co.prg7_sertfikasi.rest;

import id.co.prg7_sertfikasi.model.MsProdi;
import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.MsProdiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msprodis")
public class MsProdiRest {

    @Autowired
    private MsProdiService msProdiService;

    @GetMapping("/getProdis")
    public DtoResponse getProdis() {
        return msProdiService.getAllProdis();
    }

    @GetMapping("/getProdi/{id}")
    public DtoResponse getProdiById(@PathVariable int id) {
        return msProdiService.getProdiById(id);
    }

    @PostMapping("/saveProdi")
    public DtoResponse saveProdi(@RequestBody MsProdi prodi) {
        return msProdiService.saveProdi(prodi);
    }

    @PostMapping("/updateProdi")
    public DtoResponse updateProdi(@RequestBody MsProdi prodi) {
        return msProdiService.updateProdi(prodi);
    }

    @PostMapping("/deleteProdi")
    public DtoResponse deleteProdi(@RequestBody MsProdi prodi) {
        return msProdiService.deleteProdi(prodi);
    }
}
