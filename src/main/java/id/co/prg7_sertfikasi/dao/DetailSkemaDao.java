package id.co.prg7_sertfikasi.dao;

import id.co.prg7_sertfikasi.vo.DetailSkemaVo;

import java.util.List;

public interface DetailSkemaDao {
    List<DetailSkemaVo> getAllDetailSkemas();
    List<DetailSkemaVo> getDetailSkemaActive();
}
