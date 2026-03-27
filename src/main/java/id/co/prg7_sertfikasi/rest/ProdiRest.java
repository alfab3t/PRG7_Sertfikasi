package id.co.prg7_sertfikasi.rest;

import id.co.prg7_sertfikasi.constant.ProdiConstant;
import id.co.prg7_sertfikasi.model.Prodi;
import id.co.prg7_sertfikasi.service.ProdiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodis")
public class ProdiRest {

    private final ProdiService prodiService;

    public ProdiRest(ProdiService prodiService) {
        this.prodiService = prodiService;
    }

    @GetMapping("/getProdis")
    public ResponseEntity<List<Prodi>> getProdis() {
        return new ResponseEntity<>(prodiService.getProdis(), HttpStatus.OK);
    }

    @GetMapping("/getProdi/{id}")
    public ResponseEntity<Prodi> getProdiById(@PathVariable int id) {
        Prodi prodi = prodiService.getProdiById(id);
        if (prodi != null) {
            return new ResponseEntity<>(prodi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveProdi")
    public ResponseEntity<String> saveProdi(@RequestBody Prodi prodi) {
        int nextId = prodiService.getProdis().size() + 1;
        prodi.setId(nextId);
        prodiService.saveProdi(prodi);
        return new ResponseEntity<>(ProdiConstant.mCreateSuccess, HttpStatus.CREATED);
    }

    @PutMapping("/updateProdi/{id}")
    public ResponseEntity<String> updateProdi(@PathVariable int id, @RequestBody Prodi prodi) {
        Prodi existing = prodiService.getProdiById(id);
        if (existing != null) {
            prodi.setId(id);
            prodiService.updateProdi(prodi);
            return new ResponseEntity<>(ProdiConstant.mUpdateSuccess, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ProdiConstant.mNotFound, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteProdi/{id}")
    public ResponseEntity<String> deleteProdi(@PathVariable int id) {
        Prodi existing = prodiService.getProdiById(id);
        if (existing != null) {
            prodiService.deleteProdi(id);
            return new ResponseEntity<>(ProdiConstant.mDeleteSuccess, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ProdiConstant.mNotFound, HttpStatus.NOT_FOUND);
        }
    }
}
