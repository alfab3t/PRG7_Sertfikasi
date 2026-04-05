package id.co.prg7_sertfikasi.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stf_msprodi")
public class MsProdi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Integer pro_id;

    @Column(name = "pro_nama")
    private String pro_nama;

    @Column(name = "pro_singkatan")
    private String pro_singkatan;

    @Column(name = "pro_jurusan")
    private String pro_jurusan;

    @Column(name = "pro_status")
    private Integer pro_status;

    @Column(name = "pro_creaby")
    private Integer pro_creaby;

    @Column(name = "pro_creadate")
    private Date pro_creadate;

    @Column(name = "pro_modiby")
    private Integer pro_modiby;

    @Column(name = "pro_modidate")
    private Date pro_modidate;

    public MsProdi() {}

    public Integer getPro_id() { return pro_id; }
    public void setPro_id(Integer pro_id) { this.pro_id = pro_id; }

    public String getPro_nama() { return pro_nama; }
    public void setPro_nama(String pro_nama) { this.pro_nama = pro_nama; }

    public String getPro_singkatan() { return pro_singkatan; }
    public void setPro_singkatan(String pro_singkatan) { this.pro_singkatan = pro_singkatan; }

    public String getPro_jurusan() { return pro_jurusan; }
    public void setPro_jurusan(String pro_jurusan) { this.pro_jurusan = pro_jurusan; }

    public Integer getPro_status() { return pro_status; }
    public void setPro_status(Integer pro_status) { this.pro_status = pro_status; }

    public Integer getPro_creaby() { return pro_creaby; }
    public void setPro_creaby(Integer pro_creaby) { this.pro_creaby = pro_creaby; }

    public Date getPro_creadate() { return pro_creadate; }
    public void setPro_creadate(Date pro_creadate) { this.pro_creadate = pro_creadate; }

    public Integer getPro_modiby() { return pro_modiby; }
    public void setPro_modiby(Integer pro_modiby) { this.pro_modiby = pro_modiby; }

    public Date getPro_modidate() { return pro_modidate; }
    public void setPro_modidate(Date pro_modidate) { this.pro_modidate = pro_modidate; }
}
