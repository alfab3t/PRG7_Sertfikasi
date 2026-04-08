package id.co.prg7_sertfikasi.vo;

import java.io.Serializable;
import java.util.Date;

public class DetailSkemaVoForm implements Serializable {
    private Integer dskId;
    private Integer skmId;
    private Integer proId;
    private Date tanggalMulai;
    private Date tanggalBerakhir;
    private Integer totalPeserta;
    private Integer kompeten;
    private Integer belumKompeten;
    private Integer tidakHadir;
    private Integer status;
    private Integer creaby;
    private Date creadate;
    private Integer modiby;
    private Date modidate;

    public DetailSkemaVoForm() {}

    public Integer getDskId() { return dskId; }
    public void setDskId(Integer dskId) { this.dskId = dskId; }

    public Integer getSkmId() { return skmId; }
    public void setSkmId(Integer skmId) { this.skmId = skmId; }

    public Integer getProId() { return proId; }
    public void setProId(Integer proId) { this.proId = proId; }

    public Date getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(Date tanggalMulai) { this.tanggalMulai = tanggalMulai; }

    public Date getTanggalBerakhir() { return tanggalBerakhir; }
    public void setTanggalBerakhir(Date tanggalBerakhir) { this.tanggalBerakhir = tanggalBerakhir; }

    public Integer getTotalPeserta() { return totalPeserta; }
    public void setTotalPeserta(Integer totalPeserta) { this.totalPeserta = totalPeserta; }

    public Integer getKompeten() { return kompeten; }
    public void setKompeten(Integer kompeten) { this.kompeten = kompeten; }

    public Integer getBelumKompeten() { return belumKompeten; }
    public void setBelumKompeten(Integer belumKompeten) { this.belumKompeten = belumKompeten; }

    public Integer getTidakHadir() { return tidakHadir; }
    public void setTidakHadir(Integer tidakHadir) { this.tidakHadir = tidakHadir; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public Integer getCreaby() { return creaby; }
    public void setCreaby(Integer creaby) { this.creaby = creaby; }

    public Date getCreadate() { return creadate; }
    public void setCreadate(Date creadate) { this.creadate = creadate; }

    public Integer getModiby() { return modiby; }
    public void setModiby(Integer modiby) { this.modiby = modiby; }

    public Date getModidate() { return modidate; }
    public void setModidate(Date modidate) { this.modidate = modidate; }
}
