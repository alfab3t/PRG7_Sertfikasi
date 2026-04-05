package id.co.prg7_sertfikasi.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stf_msuser")
public class MsUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_id")
    private Integer usr_id;

    @Column(name = "usr_nama")
    private String usr_nama;

    @Column(name = "usr_email")
    private String usr_email;

    @Column(name = "usr_username")
    private String usr_username;

    @Column(name = "usr_password")
    private String usr_password;

    @Column(name = "usr_role")
    private String usr_role;

    @Column(name = "usr_status")
    private Integer usr_status;

    @Column(name = "pro_id")
    private Integer pro_id;

    @Column(name = "usr_creaby")
    private Integer usr_creaby;

    @Column(name = "usr_creadate")
    private Date usr_creadate;

    @Column(name = "usr_modiby")
    private Integer usr_modiby;

    @Column(name = "usr_modidate")
    private Date usr_modidate;

    public MsUser() {}

    public Integer getUsr_id() { return usr_id; }
    public void setUsr_id(Integer usr_id) { this.usr_id = usr_id; }

    public String getUsr_nama() { return usr_nama; }
    public void setUsr_nama(String usr_nama) { this.usr_nama = usr_nama; }

    public String getUsr_email() { return usr_email; }
    public void setUsr_email(String usr_email) { this.usr_email = usr_email; }

    public String getUsr_username() { return usr_username; }
    public void setUsr_username(String usr_username) { this.usr_username = usr_username; }

    public String getUsr_password() { return usr_password; }
    public void setUsr_password(String usr_password) { this.usr_password = usr_password; }

    public String getUsr_role() { return usr_role; }
    public void setUsr_role(String usr_role) { this.usr_role = usr_role; }

    public Integer getUsr_status() { return usr_status; }
    public void setUsr_status(Integer usr_status) { this.usr_status = usr_status; }

    public Integer getPro_id() { return pro_id; }
    public void setPro_id(Integer pro_id) { this.pro_id = pro_id; }

    public Integer getUsr_creaby() { return usr_creaby; }
    public void setUsr_creaby(Integer usr_creaby) { this.usr_creaby = usr_creaby; }

    public Date getUsr_creadate() { return usr_creadate; }
    public void setUsr_creadate(Date usr_creadate) { this.usr_creadate = usr_creadate; }

    public Integer getUsr_modiby() { return usr_modiby; }
    public void setUsr_modiby(Integer usr_modiby) { this.usr_modiby = usr_modiby; }

    public Date getUsr_modidate() { return usr_modidate; }
    public void setUsr_modidate(Date usr_modidate) { this.usr_modidate = usr_modidate; }
}
