package id.co.prg7_sertfikasi.vo;

import id.co.prg7_sertfikasi.model.Skema;

import java.math.BigDecimal;

public class SkemaVo {
    private Integer id;
    private String nama;
    private String deskripsi;
    private String prasyarat;
    private String kontak;
    private BigDecimal biaya;
    private Integer status;

    public SkemaVo() {}

    public SkemaVo(Skema skema) {
        this.id = skema.getSkm_id();
        this.nama = skema.getSkm_nama();
        this.deskripsi = skema.getSkm_deskripsi();
        this.prasyarat = skema.getSkm_prasyarat();
        this.kontak = skema.getSkm_kontak();
        this.biaya = skema.getSkm_biaya();
        this.status = skema.getSkm_status();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getPrasyarat() { return prasyarat; }
    public void setPrasyarat(String prasyarat) { this.prasyarat = prasyarat; }

    public String getKontak() { return kontak; }
    public void setKontak(String kontak) { this.kontak = kontak; }

    public BigDecimal getBiaya() { return biaya; }
    public void setBiaya(BigDecimal biaya) { this.biaya = biaya; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}
