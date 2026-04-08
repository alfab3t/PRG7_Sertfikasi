package id.co.prg7_sertfikasi.service;

import id.co.prg7_sertfikasi.response.DtoResponse;
import id.co.prg7_sertfikasi.vo.DetailSkemaVoForm;

public interface DetailSkemaService {
    DtoResponse getAllDetailSkemas();
    DtoResponse getDetailSkemaActive();
    DtoResponse saveDetailSkema(DetailSkemaVoForm detailSkemaVoForm);
    DtoResponse updateDetailSkema(DetailSkemaVoForm detailSkemaVoForm);
    DtoResponse deleteDetailSkema(DetailSkemaVoForm detailSkemaVoForm);
}
