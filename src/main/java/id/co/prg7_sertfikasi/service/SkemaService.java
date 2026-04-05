package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.model.Skema;
import id.co.prg7_sertfikasi.response.DtoResponse;

public interface SkemaService {
    DtoResponse getAllSkemas();
    DtoResponse getSkemaActive();
    DtoResponse saveSkema(Skema skema);
    DtoResponse updateSkema(Skema skema);
    DtoResponse deleteSkema(Skema skema);
}
