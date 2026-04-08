package id.co.prg7_sertfikasi.rest;

import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.service.DetailSkemaService;
import id.co.prg7_sertfikasi.vo.DetailSkemaVoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detailskemas")
public class DetailSkemaRest {

    @Autowired
    private DetailSkemaService detailSkemaService;

    @GetMapping("/getDetailSkemas")
    public DtoResponse getDetailSkemas() {
        return detailSkemaService.getAllDetailSkemas();
    }

    @GetMapping("/getDetailSkemaActive")
    public DtoResponse getDetailSkemaActive() {
        return detailSkemaService.getDetailSkemaActive();
    }

    @PostMapping("/saveDetailSkema")
    public DtoResponse createDetailSkema(@RequestBody DetailSkemaVoForm detailSkemaVoForm) {
        return detailSkemaService.saveDetailSkema(detailSkemaVoForm);
    }

    @PostMapping("/updateDetailSkema")
    public DtoResponse updateProdi(@RequestBody DetailSkemaVoForm detailSkemaVoForm) {
        return detailSkemaService.updateDetailSkema(detailSkemaVoForm);
    }

    @PostMapping("/deleteDetailSkema")
    public DtoResponse deleteDetailSkema(@RequestBody DetailSkemaVoForm detailSkemaVoForm) {
        return detailSkemaService.deleteDetailSkema(detailSkemaVoForm);
    }
}
