package id.co.prg7_sertfikasi.dao;

import id.co.prg7_sertfikasi.vo.SkemaVo;

import java.util.List;

public interface SkemaDao {
    List<SkemaVo> getAllSkemas();
    List<SkemaVo> getSkemaActive();
}
